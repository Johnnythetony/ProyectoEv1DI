package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.GameFilterDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Backlog;
import com.liceolapaz.dam.proyectoev1di.Entities.Company;
import com.liceolapaz.dam.proyectoev1di.Entities.GamesPlatforms;
import com.liceolapaz.dam.proyectoev1di.Entities.Videogame;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameQueryAssembler extends DBConnection
{
    private CriteriaBuilder cb;
    private CriteriaQuery<Videogame> cq;

    public CriteriaQuery<Videogame> buildQuery(EntityManager em, GameFilterDTO filters)
    {
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Videogame.class);
        Root<Videogame> gameRoot = cq.from(Videogame.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filters.getSearchText() != null && !filters.getSearchText().isEmpty())
        {
            String searchPattern = "%" + filters.getSearchText().toLowerCase() + "%";

            Predicate titleLike = cb.like(cb.lower(gameRoot.get("titulo")), searchPattern);
            predicates.add(titleLike);
        }

        List<String> selectedGenres = getActiveFilters(filters.getSelectedGenres());

        if (!selectedGenres.isEmpty())
        {
            Predicate genreIn = gameRoot.get("genero").in(selectedGenres);
            predicates.add(genreIn);
        }

        List<String> selectedCompanies = getActiveFilters(filters.getSelectedCompanies());

        if (!selectedCompanies.isEmpty())
        {
            Join<Videogame, Company> companyJoin = gameRoot.join("companhia", JoinType.INNER);

            Predicate companyIn = companyJoin.get("nombre").in(selectedCompanies);
            predicates.add(companyIn);
        }

        List<String> selectedPlatforms = getActiveFilters(filters.getSelectedPlatforms());

        if (!selectedPlatforms.isEmpty())
        {
            Join<?, ?> vpJoin = gameRoot.join("gamesPlatforms", JoinType.INNER);

            Join<?, ?> platformJoin = vpJoin.join("plataforma", JoinType.INNER);

            Predicate platformIn = platformJoin.get("nombre").in(selectedPlatforms);
            predicates.add(platformIn);
        }

        if (filters.getNoprice())
        {
            Join<Videogame, GamesPlatforms> priceJoin = gameRoot.join("gamesPlatforms");

            Double minPrice = filters.getPreciomin();
            Double maxPrice = filters.getPreciomax();

            if (minPrice != null && minPrice > 0) {
                Predicate minPredicate = cb.greaterThanOrEqualTo(
                        priceJoin.get("precio_juego"),
                        minPrice
                );
                predicates.add(minPredicate);
            }

            if (maxPrice != null && maxPrice < 10000)
            {
                Predicate maxPredicate = cb.lessThanOrEqualTo(
                        priceJoin.get("precio_juego"),
                        maxPrice
                );
                predicates.add(maxPredicate);
            }
        }

        if (!predicates.isEmpty())
        {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        cq.select(gameRoot);

        cq.distinct(true);

        cq.orderBy(cb.asc(gameRoot.get("titulo")));

        return cq;
    }

    public CriteriaQuery<Videogame> buildDetailsQuery(EntityManager em, String gameTitle)
    {
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(Videogame.class);
        Root<Videogame> gameRoot = cq.from(Videogame.class);

        gameRoot.fetch("companhia", JoinType.LEFT);

        Fetch<Videogame, GamesPlatforms> vpFetch = gameRoot.fetch("gamesPlatforms", JoinType.LEFT);
        vpFetch.fetch("plataforma", JoinType.LEFT);

        Fetch<Videogame, Backlog> ubFetch = gameRoot.fetch("backlog", JoinType.LEFT);
        ubFetch.fetch("usuario", JoinType.LEFT);

        Predicate whereTitle = cb.equal(gameRoot.get("titulo"), gameTitle);
        cq.where(whereTitle);

        cq.select(gameRoot).distinct(true);

        return cq;
    }

    private List<String> getActiveFilters(Map<String, Boolean> filterMap) {
        if (filterMap == null) {
            return new ArrayList<>();
        }
        return filterMap.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

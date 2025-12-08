package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.GameFilterDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Videogame;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

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

            Predicate nameLike = cb.like(cb.lower(gameRoot.get("name")), searchPattern);
            predicates.add(nameLike);
        }

        /*
        List<Predicate> platformPredicates = new ArrayList<>();

        if (filters.isIncludePlaystation()) {
            platformPredicates.add(cb.equal(gameRoot.get("platform"), "Playstation"));
        }
        if (filters.isIncludeXbox()) {
            platformPredicates.add(cb.equal(gameRoot.get("platform"), "Xbox"));
        }

        if (!platformPredicates.isEmpty()) {
            predicates.add(cb.or(platformPredicates.toArray(new Predicate[0])));
        }*/

        if (!predicates.isEmpty())
        {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        cq.orderBy(cb.asc(gameRoot.get("name")));

        return cq;
    }
}

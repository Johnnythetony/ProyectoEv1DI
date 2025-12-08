package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.GameFilterDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Company;
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

        // --- 1. Filtro por Texto (Título del videojuego) ---
        if (filters.getSearchText() != null && !filters.getSearchText().isEmpty())
        {
            String searchPattern = "%" + filters.getSearchText().toLowerCase() + "%";

            // Búsqueda LIKE insensible a mayúsculas/minúsculas en la columna 'titulo'
            Predicate titleLike = cb.like(cb.lower(gameRoot.get("titulo")), searchPattern);
            predicates.add(titleLike);
        }

        // --- 2. Filtros por Género (Columna directa en 'videojuegos') ---
        // Asumimos que getSelectedGenres devuelve un Map<String, Boolean> o similar
        List<String> selectedGenres = getActiveFilters(filters.getSelectedGenres());

        if (!selectedGenres.isEmpty())
        {
            // WHERE Videogame.genero IN ('Aventura', 'RPG', ...)
            Predicate genreIn = gameRoot.get("genero").in(selectedGenres);
            predicates.add(genreIn);
        }

        // --- 3. Filtros por Compañía (JOIN con la tabla 'companhias') ---
        List<String> selectedCompanies = getActiveFilters(filters.getSelectedCompanies()); // Asumo un método similar

        if (!selectedCompanies.isEmpty())
        {
            // INNER JOIN: Solo juegos que tengan una compañía asignada y que cumpla el filtro
            // 'companhia' es el nombre del atributo de relación en la Entidad Videogame
            Join<Videogame, Company> companyJoin = gameRoot.join("companhia", JoinType.INNER);

            // WHERE Companhia.nombre IN ('Nintendo', 'Sony', ...)
            Predicate companyIn = companyJoin.get("nombre").in(selectedCompanies);
            predicates.add(companyIn);
        }

        // -------------------------------------------------------------

        // --- Aplicar Todos los Filtros (AND) ---
        if (!predicates.isEmpty())
        {
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        // --- Finalización de la consulta ---

        // Seleccionamos la entidad Videogame completa
        cq.select(gameRoot);

        // Usamos DISTINCT para evitar duplicados si hay JOINs (aunque aquí el JOIN es 1:1 o M:1, es buena práctica)
        cq.distinct(true);

        // Ordenación por el título del juego
        cq.orderBy(cb.asc(gameRoot.get("titulo")));

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

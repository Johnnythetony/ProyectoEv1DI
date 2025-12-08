package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.VideogameDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.PrivateVideogameDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.VideogameDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Videogame;
import com.liceolapaz.dam.proyectoev1di.Mapper.VideogameMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;

public class VideogameService extends DBConnection implements VideogameDAO
{
    @Override
    public void createVideogame(PrivateVideogameDTO videogame)
    {
        Videogame new_game = VideogameMapper.INSTANCE.privateDTOtoDAO(videogame);

        initTransaction();

        getSession().persist(new_game);

        commitTransaction();
    }

    @Override
    public void updateVideogame(PrivateVideogameDTO videogame)
    {
        String titulo = VideogameMapper.INSTANCE.privateDTOtoDAO(videogame).getTitulo();

        initTransaction();

        Videogame game = getSession().createQuery(criteriaQueryGame(titulo)).getSingleResult();

        getSession().merge(game);

        commitTransaction();
    }

    @Override
    public void deleteVideogame(VideogameDTO videogame)
    {
        String titulo = videogame.getTitulo();

        initTransaction();

        Videogame game = getSession().createQuery(criteriaQueryGame(titulo)).getSingleResult();

        getSession().remove(game);

        commitTransaction();
    }

    @Override
    public VideogameDTO getVideogame(String titulo)
    {
        Videogame game;

        initTransaction();

        game = getSession().createQuery(criteriaQueryGame(titulo)).getSingleResult();

        commitTransaction();

        return VideogameMapper.INSTANCE.DAOtoDTO(game);
    }

    public ArrayList<String> getGenres()
    {
        ArrayList<String> genres = new ArrayList<>();

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);

        Root<Videogame> gameRoot = cq.from(Videogame.class);

        cq.select(gameRoot.get("genero"));

        cq.distinct(true);

        genres = (ArrayList<String>) getSession().createQuery(cq).getResultList();

        commitTransaction();

        return genres;
    }

    private CriteriaQuery<Videogame> criteriaQueryGame(String title)
    {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Videogame> cq = cb.createQuery(Videogame.class);

        Root<Videogame> game_root = cq.from(Videogame.class);

        cq.select(game_root);
        cq.where(cb.equal(game_root.get("titulo"), title));

        return cq;
    }
}

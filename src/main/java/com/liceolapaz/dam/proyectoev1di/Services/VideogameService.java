package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.VideogameDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.GameFilterDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.PrivateVideogameDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.VideogameDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Videogame;
import com.liceolapaz.dam.proyectoev1di.Mapper.VideogameMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VideogameService extends DBConnection implements VideogameDAO
{
    private GameQueryAssembler gqa = new GameQueryAssembler();

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

    public PrivateVideogameDTO getVideogameInfo(String titulo)
    {
        Videogame game;

        initTransaction();

        game = getSession().createQuery(criteriaQueryGame(titulo)).getSingleResult();

        commitTransaction();

        return VideogameMapper.INSTANCE.DAOtoPrivateDTO(game);
    }

    public ArrayList<String> getGenres()
    {
        ArrayList<String> genres;

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

    public ArrayList<String> getCompanies()
    {
        return new CompanyService().getCompanies();
    }

    public ArrayList<String> getPlatforms()
    {
        return new PlatformService().getPlatforms();
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

    public List<VideogameDTO> getFiteredGames(GameFilterDTO filters)
    {
        List<VideogameDTO> juegos;

        initTransaction();

        CriteriaQuery<Videogame> cq = gqa.buildQuery(getSession(), filters);

        juegos = getSession().createQuery(cq).getResultList().stream().map(VideogameMapper.INSTANCE::DAOtoDTO).toList();

        commitTransaction();

        return juegos;
    }

    public Videogame getVideogameDetails(String gameTitle)
    {
        Videogame videogame;
        initTransaction();
        try
        {
            CriteriaQuery<Videogame> cq = gqa.buildDetailsQuery(getSession(), gameTitle);

            TypedQuery<Videogame> query = getSession().createQuery(cq);

            videogame = query.getSingleResult();

            commitTransaction();

            return videogame;

        }
        catch (NoResultException e)
        {
            commitTransaction();
            return null;
        }
    }
}

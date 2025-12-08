package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.PlatformDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.PlatformDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.Company;
import com.liceolapaz.dam.proyectoev1di.Entities.Platform;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;

public class PlatformService extends DBConnection implements PlatformDAO
{
    @Override
    public void createPlatform(PlatformDTO backlog)
    {

    }

    @Override
    public void updatePlatform(PlatformDTO backlog)
    {

    }

    @Override
    public void deletePlatform(PlatformDTO backlog)
    {

    }


    @Override
    public PlatformDTO getPlatform(String platformname)
    {
        return null;
    }

    public ArrayList<String> getPlatforms()
    {
        ArrayList<String> platforms;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);

        Root<Platform> gameRoot = cq.from(Platform.class);

        cq.select(gameRoot.get("nombre"));

        cq.distinct(true);

        platforms = (ArrayList<String>) getSession().createQuery(cq).getResultList();

        commitTransaction();

        return platforms;
    }
}

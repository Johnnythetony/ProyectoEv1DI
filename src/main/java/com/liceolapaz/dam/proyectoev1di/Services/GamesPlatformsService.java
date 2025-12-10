package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.GamesPlatformsDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.GamesPlatformsDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.GamesPlatforms;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GamesPlatformsService extends DBConnection implements GamesPlatformsDAO
{
    @Override
    public void createGamesPlatformsDAO(GamesPlatformsDTO gp_dto) {

    }

    @Override
    public void updateGamesPlatformsDAO(GamesPlatformsDTO gp_dto) {

    }

    @Override
    public void deleteGamesPlatformsDAO(GamesPlatformsDTO gp_dto) {

    }

    public Float getPriceLimit(boolean is_max)
    {
        Float result = null;

        try
        {
            initTransaction();
            CriteriaBuilder cb = getSession().getCriteriaBuilder();
            CriteriaQuery<Float> cq = cb.createQuery(Float.class);
            Root<GamesPlatforms> vpRoot = cq.from(GamesPlatforms.class);

            if (is_max)
            {
                cq.select(cb.max(vpRoot.get("precio_juego")));
            }
            else
            {
                cq.select(cb.min(vpRoot.get("precio_juego")));
            }
            result = getSession().createQuery(cq).getResultList().getFirst();
            commitTransaction();
        }
        catch (Exception e)
        {
            rollbackTransaction();
            return is_max ? 100.0f : 0.0f;
        }
        return result != null ? result : (is_max ? 100.0f : 0.0f);
    }
}

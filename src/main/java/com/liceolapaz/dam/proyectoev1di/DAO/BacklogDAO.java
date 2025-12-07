package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.BacklogDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.User;

public interface BacklogDAO
{
    void createBacklog(BacklogDTO backlog);
    void updateBacklog(BacklogDTO backlog);

    BacklogDTO getBacklog(User user);
}

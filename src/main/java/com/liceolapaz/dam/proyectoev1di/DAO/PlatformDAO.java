package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.PlatformDTO;

public interface PlatformDAO
{
    void createPlatform(PlatformDTO backlog);
    void updatePlatform(PlatformDTO backlog);
    void deletePlatform(PlatformDTO backlog);

    PlatformDTO getPlatform(String platformname);
}

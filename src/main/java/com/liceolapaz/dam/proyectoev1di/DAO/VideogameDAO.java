package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.PrivateVideogameDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.VideogameDTO;

public interface VideogameDAO
{
    void createVideogame(PrivateVideogameDTO videogame);
    void updateVideogame(PrivateVideogameDTO videogame);
    void deleteVideogame(VideogameDTO videogame);

    VideogameDTO getVideogame(String name);
}

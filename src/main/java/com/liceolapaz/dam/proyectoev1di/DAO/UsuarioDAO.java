package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.UsuarioDTO;

public interface UsuarioDAO
{
    void createUser(UsuarioDTO usuario);
    void updateUser(UsuarioDTO usuario);
    void deleteUser(UsuarioDTO usuario);

    void verifyUser(String username, String password);
    void getUser(String username);
}

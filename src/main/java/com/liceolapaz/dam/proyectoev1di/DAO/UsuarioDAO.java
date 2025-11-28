package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.UsuarioDTO;

public interface UsuarioDAO
{
    void createUser(Usuario usuario);
    void updateUser(Usuario usuario);
    void deleteUser(Usuario usuario);

    void verifyUser(String username, String password);
    void getUser(String username);
}

package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;

public class UsuarioDAOImp extends DBConnection implements UsuarioDAO
{
    public UsuarioDAOImp(){}

    @Override
    public void createUser(Usuario usuario)
    {
        initTransaction();
        getSession().persist(usuario);
        commitTransaction();
    }

    @Override
    public void updateUser(Usuario usuario) {

    }

    @Override
    public void deleteUser(Usuario usuario) {

    }

    @Override
    public void verifyUser(String username, String password) {

    }

    @Override
    public void getUser(String username) {

    }
}

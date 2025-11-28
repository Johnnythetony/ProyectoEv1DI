package com.liceolapaz.dam.proyectoev1di.DBConnectivity;

import org.hibernate.SessionFactory;

public class DBConnection
{
    private DBConnection instance;
    private SessionFactory session_factory;

    public DBConnection getInstance()
    {
        if (instance == null)
        {
            instance = new DBConnection();
        }
        return instance;
    }

    private void getSessionFactory()
    {
    }
}

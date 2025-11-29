package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;

public class SessionManager
{
    private static SessionManager INSTANCE;

    private UserDTO cur_user;

    public static SessionManager getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new SessionManager();
        }
        return INSTANCE;
    }

    public void setUser(UserDTO user)
    {
        cur_user = user;
    }

    public UserDTO getUser()
    {
        return cur_user;
    }
}

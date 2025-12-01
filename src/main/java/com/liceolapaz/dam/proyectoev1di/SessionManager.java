package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;

import java.util.LinkedList;

public class SessionManager
{
    private static SessionManager INSTANCE;

    private UserDTO cur_user;

    private LinkedList<String> previous_views = new LinkedList<String>();

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

    public void addPreviousView(String view)
    {
        if(previous_views.size() > 5)
        {
            previous_views.removeFirst();
            previous_views.add(view);
        }
        else
        {
            previous_views.add(view);
        }
    }

    public String nextPreviousView()
    {
        return previous_views.poll();
    }

    public boolean previousViewExists()
    {
        return !previous_views.isEmpty();
    }
}

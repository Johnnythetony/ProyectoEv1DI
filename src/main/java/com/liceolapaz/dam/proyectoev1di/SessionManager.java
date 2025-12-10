package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.Controllers.UserMenuController;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.VideogameDTO;
import com.liceolapaz.dam.proyectoev1di.Services.UserService;
import javafx.collections.ObservableList;

import java.util.LinkedList;

public class SessionManager
{
    private static SessionManager INSTANCE;

    private UserDTO cur_user;

    private UserDTO user_mod;

    private VideogameDTO current_game;

    private ObservableList<UserDTO> admin_user_list;

    private UserMenuController user_menu;

    private LinkedList<String> previous_views = new LinkedList<String>();

    private UserService user_service = new UserService();

    public static SessionManager getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new SessionManager();
        }
        return INSTANCE;
    }

    public UserMenuController getUserMenuController()
    {
        return this.user_menu;
    }

    public void setUserMenuController(UserMenuController user_menu)
    {
        this.user_menu = user_menu;
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

    public boolean userIsAdmin()
    {
        return user_service.isAdmin(cur_user.getUsername());
    }

    public VideogameDTO getCurrent_game() {
        return current_game;
    }

    public void setCurrent_game(VideogameDTO current_game) {
        this.current_game = current_game;
    }

    public ObservableList<UserDTO> getAdmin_user_list() {
        return admin_user_list;
    }

    public void setAdmin_user_list(ObservableList<UserDTO> admin_user_list) {
        this.admin_user_list = admin_user_list;
    }

    public UserDTO getUser_mod() {
        return user_mod;
    }

    public void setUser_mod(UserDTO user_mod) {
        this.user_mod = user_mod;
    }
}

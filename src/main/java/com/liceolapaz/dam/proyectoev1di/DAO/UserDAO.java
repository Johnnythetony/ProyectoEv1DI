package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.RegisterUserDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;

public interface UserDAO
{
    void createUser(RegisterUserDTO usuario);
    void updateUser(UserDTO usuario);
    void deleteUser(UserDTO usuario);

    boolean verifyUser(String username, String password);
    UserDTO getUser(String username);
}

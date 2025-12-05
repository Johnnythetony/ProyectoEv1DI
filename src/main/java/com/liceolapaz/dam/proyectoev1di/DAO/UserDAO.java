package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.PrivateUserDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;

public interface UserDAO
{
    void createUser(PrivateUserDTO usuario);
    void updateUser(PrivateUserDTO usuario);
    void deleteUser(UserDTO usuario);

    boolean verifyUser(String username, String password);
    UserDTO getUser(String username);
}

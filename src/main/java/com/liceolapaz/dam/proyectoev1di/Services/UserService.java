package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.UserDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.User;
import com.liceolapaz.dam.proyectoev1di.Mapper.UserMapper;
import com.liceolapaz.dam.proyectoev1di.Utils.HashUtil;

public class UserService extends DBConnection implements UserDAO
{
    public UserService(){}

    @Override
    public void createUser(UserDTO user)
    {
        User userDAO = UserMapper.INSTANCE.DTOtoDAO(user);
        userDAO.setPassword(HashUtil.hashPassword(user.getPassword()));
        initTransaction();
        getSession().persist(userDAO);
        commitTransaction();
    }

    @Override
    public void updateUser(UserDTO user)
    {
        User userDAO = UserMapper.INSTANCE.DTOtoDAO(user);
        initTransaction();
        getSession().merge(userDAO);
        commitTransaction();
    }

    @Override
    public void deleteUser(UserDTO usuario)
    {
        User userDAO = UserMapper.INSTANCE.DTOtoDAO(usuario);
        initTransaction();
        getSession().remove(userDAO);
        commitTransaction();
    }

    @Override
    public boolean verifyUser(String username, String password)
    {
        boolean verified = false;

        initTransaction();
        User usuario = getSession().byNaturalId(User.class)
                .using("username","jamp1")
                .load();
        verified = HashUtil.checkPassword(password, usuario.getPassword());
        commitTransaction();

        return verified;
    }

    @Override
    public UserDTO getUser(String username)
    {
        initTransaction();
        User usuario = getSession().byNaturalId(User.class)
                .using("username","jamp1")
                .load();
        commitTransaction();

        return UserMapper.INSTANCE.DAOtoDTO(usuario);
    }
}

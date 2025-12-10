package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.UserDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.PrivateUserDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.User;
import com.liceolapaz.dam.proyectoev1di.Mapper.UserMapper;
import com.liceolapaz.dam.proyectoev1di.Mapper.VideogameMapper;
import com.liceolapaz.dam.proyectoev1di.Utils.HashUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class UserService extends DBConnection implements UserDAO
{
    public UserService(){}

    @Override
    public void createUser(PrivateUserDTO user)
    {
        User userDAO = UserMapper.INSTANCE.PrivateDTOtoDAO(user);
        userDAO.setPassword(HashUtil.hashPassword(user.getPassword()));

        initTransaction();

        getSession().persist(userDAO);

        commitTransaction();
    }

    @Override
    public void updateUser(PrivateUserDTO user_dto)
    {
        String username = user_dto.getUsername();

        initTransaction();

        User user_dao = getSession().createQuery(criteriaQueryUser(username)).getSingleResult();

        if(user_dao == null) return;

        UserMapper.INSTANCE.updateFromPrivateModel(user_dto, user_dao);
        getSession().merge(user_dao);

        commitTransaction();
    }

    @Override
    public void deleteUser(UserDTO user_dto)
    {
        String username = UserMapper.INSTANCE.DTOtoDAO(user_dto).getUsername();

        initTransaction();

        User user_dao = getSession().createQuery(criteriaQueryUser(username)).getSingleResult();

        if(user_dao == null) return;

        getSession().remove(user_dao);

        commitTransaction();
    }

    @Override
    public boolean verifyUser(String username, String password)
    {
        boolean verified;

        if(!usernameExists(username)) return false;

        initTransaction();

        User user = getSession().createQuery(criteriaQueryUser(username)).getSingleResult();

        verified = HashUtil.checkPassword(password, user.getPassword());

        commitTransaction();

        return verified;
    }

    @Override
    public UserDTO getUser(String username)
    {
        initTransaction();

        User usuario = getSession().createQuery(criteriaQueryUser(username)).getSingleResult();

        commitTransaction();

        return UserMapper.INSTANCE.DAOtoDTO(usuario);
    }

    public boolean usernameExists(String username)
    {
        boolean exists;

        try
        {
            initTransaction();

            exists = getSession().createQuery(criteriaQueryUser(username)).getSingleResult() != null;

            commitTransaction();
        }
        catch (Exception e)
        {
            exists = false;
            commitTransaction();
        }


        return exists;
    }

    public boolean emailExists(String email)
    {
        boolean exists;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> user_root = cq.from(User.class);

        cq.select(user_root);
        cq.where(cb.equal(user_root.get("mail"), email));
        exists = !getSession().createQuery(cq).getResultList().isEmpty();

        commitTransaction();

        return exists;
    }

    public boolean isAdmin(String username)
    {
        boolean user_is_admin;

        initTransaction();

        CriteriaQuery<User> cq = criteriaQueryUser(username);

        if(getSession().createQuery(cq).getSingleResult() != null)
        {
            user_is_admin = getSession().createQuery(cq).getSingleResult().isAdmin();
        }
        else
        {
            return false;
        }

        commitTransaction();

        return user_is_admin;
    }

    public List<UserDTO> retrieveUsers(String username)
    {
        List<UserDTO> users;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> user_root = cq.from(User.class);

        cq.select(user_root);

        String searchPattern = "%" + username + "%";

        cq.where(cb.like(cb.lower(user_root.get("username")), searchPattern));

        users = getSession().createQuery(cq).getResultList().stream().map(UserMapper.INSTANCE::DAOtoDTO).toList();

        commitTransaction();

        return users;
    }

    private CriteriaQuery<User> criteriaQueryUser(String username)
    {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> user_root = cq.from(User.class);

        cq.select(user_root);
        cq.where(cb.equal(user_root.get("username"), username));

        return cq;
    }
}

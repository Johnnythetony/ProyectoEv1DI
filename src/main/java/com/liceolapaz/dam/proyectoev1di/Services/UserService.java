package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.UserDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.RegisterUserDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.User;
import com.liceolapaz.dam.proyectoev1di.Mapper.UserMapper;
import com.liceolapaz.dam.proyectoev1di.Utils.HashUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserService extends DBConnection implements UserDAO
{
    public UserService(){}

    @Override
    public void createUser(RegisterUserDTO user)
    {
        User userDAO = UserMapper.INSTANCE.RegisterDTOtoDAO(user);
        userDAO.setPassword(HashUtil.hashPassword(user.getPassword()));

        initTransaction();

        getSession().persist(userDAO);

        commitTransaction();
    }

    @Override
    public void updateUser(UserDTO user_dto)
    {
        String username = UserMapper.INSTANCE.DTOtoDAO(user_dto).getUsername();

        initTransaction();

        User user_dao = getSession().createQuery(criteriaQueryUser(username)).getSingleResult();

        UserMapper.INSTANCE.updateFromModel(user_dto, user_dao);
        getSession().merge(user_dao);

        commitTransaction();
    }

    @Override
    public void deleteUser(UserDTO user_dto)
    {
        String username = UserMapper.INSTANCE.DTOtoDAO(user_dto).getUsername();

        initTransaction();

        User user_dao = getSession().createQuery(criteriaQueryUser(username)).getSingleResult();

        getSession().remove(user_dao);

        commitTransaction();
    }

    @Override
    public boolean verifyUser(String username, String password)
    {
        boolean verified;

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

        initTransaction();

        exists = getSession().createQuery(criteriaQueryUser(username)).getSingleResult() != null;

        commitTransaction();

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

        user_is_admin = getSession().createQuery(cq).getSingleResult().isAdmin();

        commitTransaction();

        return user_is_admin;
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

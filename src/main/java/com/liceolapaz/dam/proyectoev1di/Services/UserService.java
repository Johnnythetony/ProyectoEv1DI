package com.liceolapaz.dam.proyectoev1di.Services;

import com.liceolapaz.dam.proyectoev1di.DAO.UserDAO;
import com.liceolapaz.dam.proyectoev1di.DBConnectivity.DBConnection;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.Entities.User;
import com.liceolapaz.dam.proyectoev1di.Mapper.UserMapper;
import com.liceolapaz.dam.proyectoev1di.Utils.HashUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

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
    public void updateUser(UserDTO user_dto)
    {
        Long user_id = UserMapper.INSTANCE.DTOtoDAO(user_dto).getId();

        initTransaction();

        User user_dao = getSession().find(User.class, user_id);
        UserMapper.INSTANCE.updateFromModel(user_dto, user_dao);
        getSession().merge(user_dao);

        commitTransaction();
    }

    @Override
    public void deleteUser(UserDTO user_dto)
    {
        Long user_id = UserMapper.INSTANCE.DTOtoDAO(user_dto).getId();

        initTransaction();

        User user_dao = getSession().find(User.class, user_id);
        getSession().remove(user_dao);

        commitTransaction();
    }

    @Override
    public boolean verifyUser(String username, String password)
    {
        boolean verified;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.select(cq.from(User.class));
        cq.where(cb.equal(cq.from(User.class).get("username"), username));
        User usuario = getSession().createQuery(cq).getSingleResult();

        verified = HashUtil.checkPassword(password, usuario.getPassword());
        commitTransaction();

        return verified;
    }

    @Override
    public UserDTO getUser(String username)
    {
        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.select(cq.from(User.class));
        cq.where(cb.equal(cq.from(User.class).get("username"), username));
        User usuario = getSession().createQuery(cq).getSingleResult();

        commitTransaction();

        return UserMapper.INSTANCE.DAOtoDTO(usuario);
    }

    public boolean usernameExists(String username)
    {
        boolean exists;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.select(cq.from(User.class));
        cq.where(cb.equal(cq.from(User.class).get("username"), username));
        exists = !getSession().createQuery(cq).getResultList().isEmpty();

        commitTransaction();

        return exists;
    }

    public boolean emailExists(String email)
    {
        boolean exists;

        initTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.select(cq.from(User.class));
        cq.where(cb.equal(cq.from(User.class).get("mail"), email));
        exists = !getSession().createQuery(cq).getResultList().isEmpty();

        commitTransaction();

        return exists;
    }
}

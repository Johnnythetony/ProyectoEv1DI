package com.liceolapaz.dam.proyectoev1di.DAO;

import com.liceolapaz.dam.proyectoev1di.DTO.UsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioDAOImp implements UsuarioDAO
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String mail;
    private boolean is_admin;
    private boolean stylesheet;

    @Override
    public void createUser(UsuarioDTO usuario) {

    }

    @Override
    public void updateUser(UsuarioDTO usuario) {

    }

    @Override
    public void deleteUser(UsuarioDTO usuario) {

    }

    @Override
    public void verifyUser(String username, String password) {

    }

    @Override
    public void getUser(String username) {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isStylesheet() {
        return stylesheet;
    }

    public void setStylesheet(boolean stylesheet) {
        this.stylesheet = stylesheet;
    }
}

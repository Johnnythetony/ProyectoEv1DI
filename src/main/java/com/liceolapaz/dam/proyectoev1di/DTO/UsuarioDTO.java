package com.liceolapaz.dam.proyectoev1di.DTO;

public class UsuarioDTO
{
    private int id;
    private String username;
    private String password;
    private String mail;
    private boolean is_admin;
    private boolean stylesheet;

    public UsuarioDTO(int id, String username, String password, String mail, boolean is_admin, boolean stylesheet) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.is_admin = is_admin;
        this.stylesheet = stylesheet;
    }

    public int getId() {
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

    public boolean isStylesheet()
    {
        return stylesheet;
    }

    public void setStylesheet(boolean stylesheet)
    {
        this.stylesheet = stylesheet;
    }
}

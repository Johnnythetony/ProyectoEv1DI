package com.liceolapaz.dam.proyectoev1di.DTO;

public class UserDTO
{
    private Long id;
    private String username;
    private String password;
    private String mail;
    private boolean admin;
    private boolean stylesheet;

    public UserDTO(Long id, String username, String password, String mail, boolean admin, boolean stylesheet)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.admin = admin;
        this.stylesheet = stylesheet;
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

    public boolean isAdmin() {
        return admin;
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

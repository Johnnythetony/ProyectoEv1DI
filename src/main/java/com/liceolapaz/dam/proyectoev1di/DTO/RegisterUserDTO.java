package com.liceolapaz.dam.proyectoev1di.DTO;

public class RegisterUserDTO
{
    private String username;
    private String mail;
    private String password;
    private boolean admin;
    private boolean stylesheet;

    public RegisterUserDTO(String username, String mail, String password)
    {
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.admin = false;
        this.stylesheet = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

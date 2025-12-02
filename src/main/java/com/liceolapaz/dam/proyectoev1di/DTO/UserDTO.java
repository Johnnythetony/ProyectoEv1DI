package com.liceolapaz.dam.proyectoev1di.DTO;

public class UserDTO
{
    private String username;
    private String mail;
    private boolean stylesheet;

    public UserDTO(String username, String mail)
    {
        this.username = username;
        this.mail = mail;
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

    public boolean isStylesheet()
    {
        return stylesheet;
    }

    public void setStylesheet(boolean stylesheet)
    {
        this.stylesheet = stylesheet;
    }
}

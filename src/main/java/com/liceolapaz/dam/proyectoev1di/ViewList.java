package com.liceolapaz.dam.proyectoev1di;

public enum ViewList 
{
    LOGIN("login-view.fxml"),
    REGISTER("register-view.fxml"),
    WINDOWBAR("window-bar.fxml");

    private final String fxml;

    ViewList(String fxml)
    {
        this.fxml = fxml;
    }

    public String getFXML()
    {
        return fxml;
    }
}

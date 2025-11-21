package com.liceolapaz.dam.proyectoev1di.ResourcePaths;

public enum Views
{
    LOGIN("login-view.fxml"),
    REGISTER("register-view.fxml"),
    WINDOWBAR("window-bar.fxml");

    private final String fxml;

    Views(String fxml)
    {
        this.fxml = fxml;
    }

    public String getFXML()
    {
        return fxml;
    }
}

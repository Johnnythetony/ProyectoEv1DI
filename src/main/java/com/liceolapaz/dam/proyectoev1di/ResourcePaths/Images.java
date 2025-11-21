package com.liceolapaz.dam.proyectoev1di.ResourcePaths;

public enum Images
{
    LOGIN_ICON("login-icon.png");

    private final String resource_path;

    Images(String image) { this.resource_path = "/images/" + image; }

    public String getResource_path() { return resource_path; }
}

package com.liceolapaz.dam.proyectoev1di.ResourcePaths;

public enum Stylesheets
{
    DEFAULT("backloggd-stylesheet.css");

    private final String resource_path;

    Stylesheets(String stylesheet) { this.resource_path = "/stylesheets/"+stylesheet; }

    public String getResource_path() { return resource_path; }
}

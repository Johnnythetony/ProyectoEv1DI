package com.liceolapaz.dam.proyectoev1di.DTO;

public class PlatformDTO
{
    private String nombre;

    public PlatformDTO() {}

    public PlatformDTO(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

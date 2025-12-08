package com.liceolapaz.dam.proyectoev1di.DTO;

public class CompanyDTO
{
    private String nombre;

    public CompanyDTO() {}

    public CompanyDTO(String nombre)
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

package com.liceolapaz.dam.proyectoev1di.DTO;

public class VideogameDTO
{
    private String titulo;

    public VideogameDTO(String titulo)
    {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

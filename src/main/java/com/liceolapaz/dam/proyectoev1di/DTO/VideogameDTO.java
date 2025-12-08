package com.liceolapaz.dam.proyectoev1di.DTO;

public class VideogameDTO
{
    private String titulo;
    private String portada;

    public VideogameDTO(String titulo, String portada)
    {
        this.titulo = titulo;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}

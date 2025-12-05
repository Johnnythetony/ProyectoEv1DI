package com.liceolapaz.dam.proyectoev1di.DTO;

public class PrivateVideogameDTO
{
    private String titulo;
    private String genero;
    private String companhia;
    private String portada;

    public PrivateVideogameDTO(String titulo, String genero, String companhia, String portada) {
        this.titulo = titulo;
        this.genero = genero;
        this.companhia = companhia;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}

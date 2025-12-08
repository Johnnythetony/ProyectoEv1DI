package com.liceolapaz.dam.proyectoev1di.DTO;

import com.liceolapaz.dam.proyectoev1di.Entities.Company;

public class PrivateVideogameDTO
{
    private String titulo;
    private String genero;
    private Company companhia;
    private String portada;

    public PrivateVideogameDTO(String titulo, String genero, Company companhia, String portada) {
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

    public Company getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Company companhia) {
        this.companhia = companhia;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}

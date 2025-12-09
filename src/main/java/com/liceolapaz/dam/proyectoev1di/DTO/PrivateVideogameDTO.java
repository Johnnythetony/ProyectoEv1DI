package com.liceolapaz.dam.proyectoev1di.DTO;

import com.liceolapaz.dam.proyectoev1di.Entities.Categoria;

import java.util.HashMap;

public class PrivateVideogameDTO
{
    private String titulo;
    private String genero;
    private Categoria categoria;
    private String portada;

    public PrivateVideogameDTO(String titulo, String genero, String portada, Categoria categoria)
    {
        this.titulo = titulo;
        this.genero = genero;
        this.portada = portada;
        this.categoria = categoria;
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

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

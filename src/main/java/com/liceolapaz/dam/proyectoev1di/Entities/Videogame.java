package com.liceolapaz.dam.proyectoev1di.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "videogames")
public class Videogame
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String genero;
    private String companhia;
    private String portada;

    public Videogame() {}

    public Videogame(Long id, String titulo, String genero, String companhia, String portada)
    {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.companhia = companhia;
        this.portada = portada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

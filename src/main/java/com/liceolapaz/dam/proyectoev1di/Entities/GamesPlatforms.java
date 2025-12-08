package com.liceolapaz.dam.proyectoev1di.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "videojuegos_plataformas")
public class GamesPlatforms
{
    @EmbeddedId
    private VideojuegoPlataformaId id;

    private Float precio_juego;

    @ManyToOne
    @MapsId("idVideojuego")
    @JoinColumn(name = "id_videojuego")
    private Videogame videogame;

    @ManyToOne
    @MapsId("idPlataforma")
    @JoinColumn(name = "id_plataforma")
    private Platform plataforma;

    public GamesPlatforms(){}

    public GamesPlatforms(Float precio_juego, Videogame videogame, Platform plataforma)
    {
        this.videogame = videogame;
        this.plataforma = plataforma;
        this.precio_juego = precio_juego;
    }

    public Float getPrecio_juego() {
        return precio_juego;
    }

    public void setPrecio_juego(Float precio_juego) {
        this.precio_juego = precio_juego;
    }
}

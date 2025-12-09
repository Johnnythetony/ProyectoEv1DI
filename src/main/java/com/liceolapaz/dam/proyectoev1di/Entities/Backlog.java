package com.liceolapaz.dam.proyectoev1di.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="usuarios_backlog")
public class Backlog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resenha;
    private short valoracion;
    private String estado;
    private float duracion;
    private LocalDate fecha_resenha;

    @ManyToOne
    @JoinColumn(name = "id_videojuego")
    private Videogame videojuego;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User usuario;

    public Backlog() {}

    public Backlog(Long id,String resenha, short valoracion, String estado, float duracion, LocalDate fecha_resenha)
    {
        this.id = id;
        this.resenha = resenha;
        this.valoracion = valoracion;
        this.estado = estado;
        this.duracion = duracion;
        this.fecha_resenha = fecha_resenha;
    }

    public Long getId() {
        return id;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public short getValoracion() {
        return valoracion;
    }

    public void setValoracion(short valoracion) {
        this.valoracion = valoracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFecha_resenha() {
        return fecha_resenha;
    }

    public void setFecha_resenha(LocalDate fecha_resenha) {
        this.fecha_resenha = fecha_resenha;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Videogame getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videogame videojuego) {
        this.videojuego = videojuego;
    }
}

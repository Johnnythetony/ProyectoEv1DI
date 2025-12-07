package com.liceolapaz.dam.proyectoev1di.DTO;

import java.time.LocalDate;

public class BacklogDTO
{
    private String resenha;
    private short valoracion;
    private String estado;
    private float duracion;
    private LocalDate fecha_resenha;

    public BacklogDTO(String resenha, short valoracion, String estado, float duracion, LocalDate fecha_resenha)
    {
        this.resenha = resenha;
        this.valoracion = valoracion;
        this.estado = estado;
        this.duracion = duracion;
        this.fecha_resenha = fecha_resenha;
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
}

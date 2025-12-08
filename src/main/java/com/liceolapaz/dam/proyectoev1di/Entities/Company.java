package com.liceolapaz.dam.proyectoev1di.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "companhias")
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "companhia", cascade = CascadeType.ALL)
    private List<Videogame> videojuegos;

    public Company() {}

    public Company(Long id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package com.liceolapaz.dam.proyectoev1di.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "videojuegos")
public class Videogame
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String genero;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria category;
    private String portada;

    @ManyToOne
    @JoinColumn(name = "id_companhia")
    private Company companhia;

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.ALL)
    private Set<GamesPlatforms> gamesPlatforms;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL)
    private Set<Backlog> backlog;

    public Videogame() {}

    public Videogame(Long id, String titulo, String genero, String portada,Categoria category, Company companhia, Set<GamesPlatforms> gamesPlatforms, Set<Backlog> backlog) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.portada = portada;
        this.companhia = companhia;
        this.category = category;
        this.gamesPlatforms = gamesPlatforms;
        this.backlog = backlog;
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

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Company getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Company companhia) {
        this.companhia = companhia;
    }

    public Set<GamesPlatforms> getGamesPlatforms() {
        return gamesPlatforms;
    }

    public void setGamesPlatforms(Set<GamesPlatforms> gamesPlatforms) {
        this.gamesPlatforms = gamesPlatforms;
    }

    public Set<Backlog> getBacklog() {
        return backlog;
    }

    public void setBacklog(Set<Backlog> backlog) {
        this.backlog = backlog;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }
}

package com.liceolapaz.dam.proyectoev1di.DTO;

public class GamesPlatformsDTO
{
    private Double price;

    public GamesPlatformsDTO(Double price)
    {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

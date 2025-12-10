package com.liceolapaz.dam.proyectoev1di.DTO;

import java.util.HashMap;

public class GameFilterDTO
{
    private Double preciomax;
    private Double preciomin;

    private Boolean noprice;

    private String searchText;

    private HashMap<String, Boolean> selectedGenres;

    private HashMap<String, Boolean> selectedCompanies;

    private HashMap<String, Boolean> selectedPlatforms;

    public GameFilterDTO(String searchText, HashMap<String, Boolean> selectedGenres, HashMap<String, Boolean> selectedCompanies, HashMap<String, Boolean> selectedPlatforms, Double preciomax, Double preciomin, Boolean noprice)
    {
        this.searchText = searchText;
        this.selectedGenres = selectedGenres;
        this.selectedCompanies = selectedCompanies;
        this.selectedPlatforms = selectedPlatforms;
        this.preciomax = preciomax;
        this.preciomin = preciomin;
        this.noprice = noprice;

    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public HashMap<String,Boolean> getSelectedGenres() {
        return selectedGenres;
    }

    public void setSelectedGenres(HashMap<String,Boolean> selectedGenres) {
        this.selectedGenres = selectedGenres;
    }

    public HashMap<String,Boolean> getSelectedCompanies() {
        return selectedCompanies;
    }

    public void setSelectedCompanies(HashMap<String,Boolean> selectedCompanies) {
        this.selectedCompanies = selectedCompanies;
    }

    public HashMap<String,Boolean> getSelectedPlatforms() {
        return selectedPlatforms;
    }

    public void setSelectedPlatforms(HashMap<String,Boolean> selectedPlatforms) {
        this.selectedPlatforms = selectedPlatforms;
    }

    public Double getPreciomin() {
        return preciomin;
    }

    public void setPreciomin(Double preciomin) {
        this.preciomin = preciomin;
    }

    public Double getPreciomax() {
        return preciomax;
    }

    public void setPreciomax(Double preciomax) {
        this.preciomax = preciomax;
    }

    public Boolean getNoprice() {
        return noprice;
    }

    public void setNoprice(Boolean noprice) {
        this.noprice = noprice;
    }
}

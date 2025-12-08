package com.liceolapaz.dam.proyectoev1di.DTO;

import java.util.HashMap;

public class GameFilterDTO
{
    private String searchText;

    private HashMap<String, Boolean> selectedGenres;

    private HashMap<String, Boolean> selectedCompanies;

    private HashMap<String, Boolean> selectedPlatforms;

    public GameFilterDTO(String searchText, HashMap<String, Boolean> selectedGenres, HashMap<String, Boolean> selectedCompanies, HashMap<String, Boolean> selectedPlatforms)
    {
        this.searchText = searchText;
        this.selectedGenres = selectedGenres;
        this.selectedCompanies = selectedCompanies;
        this.selectedPlatforms = selectedPlatforms;
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
}

package com.liceolapaz.dam.proyectoev1di.DTO;

import java.util.HashMap;

public class GameFilterDTO
{
    private String searchText;

    private HashMap<String, Boolean> selectedGenres;

    public GameFilterDTO(String searchText, HashMap<String, Boolean> selectedGenres)
    {
        this.searchText = searchText;
        this.selectedGenres = selectedGenres;
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
}

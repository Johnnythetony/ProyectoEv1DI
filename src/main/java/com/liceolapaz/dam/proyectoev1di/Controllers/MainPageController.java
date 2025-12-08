package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.DTO.GameFilterDTO;
import com.liceolapaz.dam.proyectoev1di.Services.VideogameService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable
{
    @FXML
    private VBox genreVB;

    private GameFilterDTO gameFilters;

    private VideogameService vg_service = new VideogameService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        ArrayList<String> genres = vg_service.getGenres();

        for(String genre : genres)
        {
            CheckBox cb = new CheckBox(genre);
            cb.setOnAction(event -> addCheckBoxFilter(genre));
            genreVB.getChildren().add(cb);
        }
    }

    @FXML
    public void updateFilters()
    {

    }

    @FXML
    public void addCheckBoxFilter(String filter)
    {
        gameFilters.getSelectedGenres().put(filter, true);
    }
}

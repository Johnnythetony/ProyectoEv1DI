package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.Entities.Backlog;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ReviewContainerController implements Initializable
{
    @FXML
    private Label reviewTA;

    @FXML
    private Label puntuacionL;

    @FXML
    private Label duracionL;

    @FXML
    private Label fechaL;

    @FXML
    private Label usernameL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    public void setReviewData(Backlog resenha)
    {
        reviewTA.setText(resenha.getResenha());
        puntuacionL.setText("Puntuación:\n"+String.valueOf(resenha.getValoracion())+"/10");
        duracionL.setText("Horas jugadas:\n"+resenha.getDuracion());
        fechaL.setText("Fecha creación:\n"+resenha.getFecha_resenha());
        usernameL.setText(resenha.getUsuario().getUsername());
    }
}

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
    private TextArea reviewTA;

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
        if(resenha.getResenha() == null)
        {
            reviewTA.setText("Sin reseña");
        }
        else
        {
            reviewTA.setText(resenha.getResenha());
        }

        if(resenha.getValoracion() == null)
        {
            puntuacionL.setText("Sin valoracion");
        }
        else
        {
            puntuacionL.setText("Puntuación:\n"+resenha.getValoracion()+"/10");
        }

        duracionL.setText("Horas jugadas:\n"+resenha.getDuracion());
        fechaL.setText("Fecha creación:\n"+resenha.getFecha_resenha());
        usernameL.setText(resenha.getUsuario().getUsername());
    }
}

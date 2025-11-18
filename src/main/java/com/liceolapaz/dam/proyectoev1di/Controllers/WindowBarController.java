package com.liceolapaz.dam.proyectoev1di.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WindowBarController implements Initializable
{
    @FXML
    private HBox window_bar;

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        makeDraggable();
    }

    @FXML
    public void onAppClosing(ActionEvent event)
    {
        Platform.exit();
    }

    @FXML
    public void onAppMinimizing(ActionEvent event)
    {
        Stage stage = (Stage) window_bar.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void makeDraggable()
    {
        window_bar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        window_bar.setOnMouseDragged(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setX(event.getScreenX() - xOffset);

            stage.setY(event.getScreenY() - yOffset);
        });
    }
}

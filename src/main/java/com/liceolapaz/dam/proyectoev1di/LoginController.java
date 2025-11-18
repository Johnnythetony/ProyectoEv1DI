package com.liceolapaz.dam.proyectoev1di;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML
    private ImageView login_icon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        login_icon.setImage(new Image(String.valueOf(getClass().getResource("/images/login-icon.png").toExternalForm())));
        login_icon.setPreserveRatio(true);
    }

    @FXML
    public void goToRegister(ActionEvent event)
    {
        ViewHandler.loadStage(ViewList.REGISTER.getFXML());
    }
}
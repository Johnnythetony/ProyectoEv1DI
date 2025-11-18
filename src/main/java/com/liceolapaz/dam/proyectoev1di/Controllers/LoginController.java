package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import com.liceolapaz.dam.proyectoev1di.ViewList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
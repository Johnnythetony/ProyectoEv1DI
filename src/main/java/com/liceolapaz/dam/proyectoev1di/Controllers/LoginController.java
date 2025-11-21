package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Images;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
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
        login_icon.setImage(new Image(String.valueOf(getClass().getResource(Images.LOGIN_ICON.getResource_path()).toExternalForm())));
        login_icon.setPreserveRatio(true);
    }

    @FXML
    public void goToRegister(ActionEvent event)
    {
        ViewHandler.loadStage(Views.REGISTER.getFXML());
    }

    @FXML
    public void manageLogin(ActionEvent event)
    {
        //ToDo Implementar logica de login
        ViewHandler.loadStage(Views.USERMENU.getFXML());
    }
}
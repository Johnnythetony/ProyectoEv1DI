package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminUserController implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    @FXML
    public void goToCreateUser()
    {
        ViewHandler.modalStage(Views.CREATEUSER.getFXML());
    }
}

package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

//ToDo modificar estilo de barra de menu para que se funda con la ventana y no parezca una division rara

public class UserMenuController implements Initializable
{
    @FXML
    private BorderPane containerPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    //ToDo Crear metodo para cambiar vista del panel central del borderpane en cuestion
    @FXML
    private void setPaneCenter(ActionEvent event)
    {
        containerPane.setCenter(ViewHandler.getNode(Views.LOGIN.getFXML()));
    }
}

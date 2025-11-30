package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable
{
    @FXML
    private BorderPane containerPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ViewHandler.setResizableStage(true);
    }

    private void setPaneCenter(String view)
    {
        containerPane.setCenter(ViewHandler.getNode(view));
    }

    @FXML
    public void setVistaCuenta(ActionEvent actionEvent)
    {
        setPaneCenter(Views.ACCOUNT.getFXML());
    }

    @FXML
    public void setVistaBacklog(ActionEvent actionEvent)
    {
        setPaneCenter(Views.USERLIBRARY.getFXML());
    }

    @FXML
    public void setVistaResumenUsuario(ActionEvent actionEvent)
    {
        setPaneCenter(Views.USERSTATS.getFXML());
    }

    @FXML
    public void setVistaBiblioteca(ActionEvent actionEvent)
    {
        setPaneCenter(Views.MAINPAGE.getFXML());
    }

    @FXML
    public void setVistaResumenGlobal(ActionEvent actionEvent)
    {
        setPaneCenter(Views.GLOBALSTATS.getFXML());
    }

    @FXML
    public void setVistaComunidad(ActionEvent actionEvent)
    {
        setPaneCenter(Views.COMMUNITY.getFXML());
    }

    @FXML
    public void goToLogin(ActionEvent actionEvent)
    {
        ViewHandler.loadStage(Views.LOGIN.getFXML());
    }

    @FXML
    public void systemExit(ActionEvent actionEvent)
    {
        Platform.exit();
    }
}

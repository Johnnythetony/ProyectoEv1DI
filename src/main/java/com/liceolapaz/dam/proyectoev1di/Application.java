package com.liceolapaz.dam.proyectoev1di;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Application extends javafx.application.Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        ViewHandler.initStage(ViewList.LOGIN.getFXML());
    }

    public static void main(String[] args) {
        launch();
    }
}
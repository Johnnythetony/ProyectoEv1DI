package com.liceolapaz.dam.proyectoev1di;

import javafx.stage.Stage;

public class Application extends javafx.application.Application
{
    @Override
    public void start(Stage stage)
    {
        ViewHandler.initStage(ViewList.LOGIN.getFXML());
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import com.liceolapaz.dam.proyectoev1di.Services.UserService;
import javafx.stage.Stage;

public class Application extends javafx.application.Application
{
    @Override
    public void start(Stage stage)
    {
        ViewHandler.initStage(Views.LOGIN.getFXML());
        new UserService();
    }

    public static void main(String[] args) {
        launch();
    }
}
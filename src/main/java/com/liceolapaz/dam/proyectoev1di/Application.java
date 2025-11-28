package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.DAO.Usuario;
import com.liceolapaz.dam.proyectoev1di.DAO.UsuarioDAOImp;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import javafx.stage.Stage;

public class Application extends javafx.application.Application
{
    @Override
    public void start(Stage stage)
    {
        ViewHandler.initStage(Views.LOGIN.getFXML());
    }

    public static void main(String[] args) {
        launch();
    }
}
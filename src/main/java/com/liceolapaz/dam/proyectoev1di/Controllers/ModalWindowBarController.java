package com.liceolapaz.dam.proyectoev1di.Controllers;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class ModalWindowBarController extends WindowBarController
{
    @Override
    public void onAppClosing(ActionEvent event)
    {
        ((Stage)window_bar.getScene().getWindow()).close();
    }
}

package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.Services.UserService;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Images;
import com.liceolapaz.dam.proyectoev1di.SessionManager;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML
    private ImageView login_icon;

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private Label loginerrL;

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
        UserService user_service = new UserService();

        if(user_service.verifyUser(usernameTF.getText(),passwordTF.getText()))
        {
            UserDTO current_user = user_service.getUser(usernameTF.getText());
            SessionManager.getInstance().setUser(current_user);
            ViewHandler.loadStage(Views.USERMENU.getFXML());
        }
        else
        {
            loginerrL.setText("Usuario/Contraseña no válido");
        }
    }
}
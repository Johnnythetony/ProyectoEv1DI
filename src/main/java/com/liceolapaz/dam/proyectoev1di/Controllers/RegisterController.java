package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.DTO.RegisterUserDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.UserDTO;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import com.liceolapaz.dam.proyectoev1di.Services.UserService;
import com.liceolapaz.dam.proyectoev1di.Utils.Debounce;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable
{
    @FXML
    private TextField usernameTF;

    @FXML
    private TextField emailTF;

    @FXML
    private PasswordField passwordPF;

    @FXML
    private PasswordField repeat_passwordPF;

    @FXML
    private Label passworderrmsgL;

    @FXML
    private Label usernameerrmsgL;

    @FXML
    private Label mailerrmsgL;

    @FXML
    private Label repeat_passworderrmsgL;

    private final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d).{8,50}$";

    private final UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Debounce db_username = new Debounce();
        db_username.newKeyframeText(e -> validateUsername(db_username.getNewValue()));

        Debounce db_mail = new Debounce();
        db_mail.newKeyframeText(e -> validateEmail(db_mail.getNewValue()));

        Debounce db_password = new Debounce();
        db_password.newKeyframeText(e -> validatePassword(db_password.getNewValue()));

        Debounce db_repeat_password = new Debounce();
        db_repeat_password.newKeyframeText(e -> confirmPassword(db_repeat_password.getNewValue()));

        usernameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            db_username.debounceText(newValue);
        });
        emailTF.textProperty().addListener((observable, oldValue, newValue) -> {
            db_mail.debounceText(newValue);
        });
        passwordPF.textProperty().addListener((observable, oldValue, newValue) -> {
            db_password.debounceText(newValue);
        });
        repeat_passwordPF.textProperty().addListener((observable, oldValue, newValue) -> {
            db_repeat_password.debounceText(newValue);
        });
    }

    private void confirmPassword(String newValue)
    {
        if(newValue.equals(passwordPF.getText()))
        {
            repeat_passworderrmsgL.setText("");
        }
        else
        {
            repeat_passworderrmsgL.setText("Las contraseñas no coinciden");
        }
    }

    private void validatePassword(String newValue)
    {
        if(newValue.matches(PASSWORD_REGEX))
        {
            passworderrmsgL.setText("");
        }
        else
        {
            passworderrmsgL.setText("La contraseña debe tener al menos 8 caracteres, una mayúscula y un número");
        }
    }

    private void validateEmail(String newValue)
    {
        if(userService.emailExists(newValue))
        {
            mailerrmsgL.setText("El correo electrónico ya existe");
        }
        else
        {
            mailerrmsgL.setText("");
        }
    }

    private void validateUsername(String username)
    {
        if(userService.usernameExists(username))
        {
            usernameerrmsgL.setText("El usuario ya existe");
        }
        else
        {
            usernameerrmsgL.setText("");
        }
    }

    @FXML
    public void goToLogin()
    {
        ViewHandler.loadStage(Views.LOGIN.getFXML());
    }

    @FXML
    public void submit()
    {
        UserService user_service = new UserService();

        user_service.createUser(new RegisterUserDTO(
                usernameTF.getText(),
                emailTF.getText(),
                passwordPF.getText()));
    }
}

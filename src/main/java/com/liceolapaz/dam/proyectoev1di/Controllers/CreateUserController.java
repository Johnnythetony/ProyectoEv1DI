package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.DTO.PrivateUserDTO;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Stylesheets;
import com.liceolapaz.dam.proyectoev1di.Services.UserService;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateUserController extends RegisterController
{
    @Override
    public void submit()
    {
        if(userService.emailExists(emailTF.getText())
                && userService.usernameExists(usernameTF.getText())
                && repeat_passwordPF.getText().equals(passwordPF.getText())
                && passwordPF.getText().matches(PASSWORD_REGEX))
        {
            UserService user_service = new UserService();

            user_service.createUser(new PrivateUserDTO(
                    usernameTF.getText(),
                    emailTF.getText(),
                    passwordPF.getText()));
            ((Stage) usernameTF.getScene().getWindow()).close();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText("Debe rellenar todos los campos");
            alert.getDialogPane().getStylesheets().add(ViewHandler.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());

            alert.showAndWait();
        }
    }
}

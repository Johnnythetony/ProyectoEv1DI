package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.SessionManager;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyUserController extends AccountViewController
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        super.initialize(url, resourceBundle);
        usernameL.setText(SessionManager.getInstance().getUser_mod().getUsername());
        mailL.setText(SessionManager.getInstance().getUser_mod().getMail());
    }

    @Override
    protected void validatePassword(String newValue)
    {
        if(newValue.matches(PASSWORD_REGEX))
        {
            if(user_service.verifyUser(SessionManager.getInstance().getUser_mod().getUsername(), passwordPF.getText()))
            {
                passworderrmsgL.setText("No puede usar la contraseña anterior");
            }
            else
            {
                passworderrmsgL.setText("");
            }
        }
        else
        {
            passworderrmsgL.setText("La contraseña debe tener al menos 8 caracteres, una mayúscula y un número");
        }
    }
}

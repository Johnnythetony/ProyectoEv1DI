package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.model.validators.CustomValidator;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class RegisterController implements Initializable
{
    @FXML
    private BorderPane rootPane;

    //ToDo Implementar codigo a los Predicates para conectarlos al servicio de Usuario y
    //     poder comprobar si los datos ya existen en la bbdd
    private Predicate<String> name = value -> value.matches("nombre");
    private Predicate<String> mail = value -> {
        return true;
    };
    private Predicate<String> password = value -> {
        return true;
    };
    private Predicate<String> repeat_password = value -> {
        return true;
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Form form = Form.of(
                Group.of(
                        Field.ofStringType("")
                                .placeholder("Introduce un nombre de usuario")
                                .label("Nombre de usuario")
                                .validate(CustomValidator.forPredicate(name, "El nombre ya existe")),
                        Field.ofStringType("")
                                .placeholder("Introduce un correo electrónico")
                                .label("Correo electrónico")
                                .validate(CustomValidator.forPredicate(mail, "El correo ya existe")),
                        Field.ofStringType("")
                                .placeholder("Introduce una contraseña")
                                .label("Contraseña")
                                .validate(CustomValidator.forPredicate(password, "La contraseña no es válida")),
                        Field.ofStringType("")
                                .placeholder("Repite la contraseña")
                                .label("Repetir contraseña")
                                .validate(CustomValidator.forPredicate(repeat_password, "La contraseña no coincide"))
                )
        );

        rootPane.setCenter(new FormRenderer(form));
    }
}

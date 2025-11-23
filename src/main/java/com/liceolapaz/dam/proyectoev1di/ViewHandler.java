package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Stylesheets;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ViewHandler
{
    private static Stage stage;

    public static Node getNode(String view)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(ViewHandler.class.getResource(view));
            return loader.load();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText("No se pudo cargar la vista");
            alert.getDialogPane().getStylesheets().add(ViewHandler.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());

            //ToDo Usar para localizar errores
            e.printStackTrace();

            alert.showAndWait();
        }
        return null;
    }

    public static void loadScene(String view)
    {
        FXMLLoader loader = new FXMLLoader(ViewHandler.class.getResource(view));
        try
        {
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(ViewHandler.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText("No se pudo cargar la vista");
            alert.getDialogPane().getStylesheets().add(ViewHandler.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());

            //ToDo Usar para localizar errores
            e.printStackTrace();

            alert.showAndWait();
        }
    }

    public static void loadStage(String view)
    {
        stage.close();
        initStage(view);
    }

    public static void initStage(String view)
    {
        try
        {
            stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(view));
            Scene scene = new Scene(fxmlLoader.load());

            FXMLLoader fxmlLoaderWBar = new FXMLLoader(ViewHandler.class.getResource(Views.WINDOWBAR.getFXML()));
            Node wbar = fxmlLoaderWBar.load();
            ((BorderPane)scene.getRoot()).setTop(wbar);

            stage.initStyle(StageStyle.TRANSPARENT);
            scene.getStylesheets().add(Application.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText("No se pudo cargar la ventana");
            alert.getDialogPane().getStylesheets().add(ViewHandler.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());

            //ToDo Usar para localizar errores
            e.printStackTrace();

            alert.showAndWait();
        }
    }
}

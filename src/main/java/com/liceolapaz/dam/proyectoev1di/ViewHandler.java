package com.liceolapaz.dam.proyectoev1di;

import com.liceolapaz.dam.proyectoev1di.Controllers.ModalWindowBarController;
import com.liceolapaz.dam.proyectoev1di.Controllers.WindowBarController;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Stylesheets;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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

    public static void setResizableStage(boolean resizable)
    {
        stage.setResizable(resizable);
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
            fxmlLoaderWBar.setController(new WindowBarController());
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

    public static void modalStage(String view)
    {
        try
        {
            Stage new_stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(view));
            Scene scene = new Scene(fxmlLoader.load());

            FXMLLoader fxmlLoaderWBar = new FXMLLoader(ViewHandler.class.getResource(Views.WINDOWBAR.getFXML()));
            fxmlLoaderWBar.setController(new ModalWindowBarController());
            Node wbar = fxmlLoaderWBar.load();
            ((BorderPane)scene.getRoot()).setTop(wbar);

            new_stage.initOwner(stage);
            new_stage.initModality(Modality.APPLICATION_MODAL);

            new_stage.initStyle(StageStyle.TRANSPARENT);
            scene.getStylesheets().add(Application.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());
            new_stage.resizableProperty().setValue(Boolean.FALSE);
            new_stage.setScene(scene);
            new_stage.showAndWait();
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

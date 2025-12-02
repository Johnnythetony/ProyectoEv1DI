package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Views;
import com.liceolapaz.dam.proyectoev1di.Services.UserService;
import com.liceolapaz.dam.proyectoev1di.SessionManager;
import com.liceolapaz.dam.proyectoev1di.Utils.Debounce;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable
{
    @FXML
    private AnchorPane containerPane;

    @FXML
    private Menu my_accountM;

    @FXML
    private Menu adminM;

    private Debounce db_return_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ViewHandler.setResizableStage(true);
        my_accountM.setText(SessionManager.getInstance().getUser().getUsername());
        db_return_button = new Debounce();
        db_return_button.newKeyframe(e->{
            if(SessionManager.getInstance().previousViewExists())
            {
                setPanePreviousView(SessionManager.getInstance().nextPreviousView());
            }
        });

        if(SessionManager.getInstance().userIsAdmin())
        {
            adminM.setVisible(true);
            adminM.setDisable(false);
        };
    }

    private void setPaneView(String view)
    {
        containerPane.getChildren().clear();
        containerPane.getChildren().add(ViewHandler.getNode(view));

        AnchorPane.setTopAnchor(containerPane.getChildren().getFirst(), 0.0);
        AnchorPane.setBottomAnchor(containerPane.getChildren().getFirst(), 0.0);
        AnchorPane.setLeftAnchor(containerPane.getChildren().getFirst(), 0.0);
        AnchorPane.setRightAnchor(containerPane.getChildren().getFirst(), 0.0);

        SessionManager.getInstance().addPreviousView(view);
    }

    private void setPanePreviousView(String view)
    {
        containerPane.getChildren().clear();
        containerPane.getChildren().add(ViewHandler.getNode(view));

        AnchorPane.setTopAnchor(containerPane.getChildren().getFirst(), 0.0);
        AnchorPane.setBottomAnchor(containerPane.getChildren().getFirst(), 0.0);
        AnchorPane.setLeftAnchor(containerPane.getChildren().getFirst(), 0.0);
        AnchorPane.setRightAnchor(containerPane.getChildren().getFirst(), 0.0);
    }

    @FXML
    public void setAccountView(ActionEvent actionEvent)
    {
        setPaneView(Views.ACCOUNT.getFXML());
    }

    @FXML
    public void setBacklogView(ActionEvent actionEvent)
    {
        setPaneView(Views.USERLIBRARY.getFXML());
    }

    @FXML
    public void setUserResumeView(ActionEvent actionEvent)
    {
        setPaneView(Views.USERSTATS.getFXML());
    }

    @FXML
    public void setGlobalLibraryView(ActionEvent actionEvent)
    {
        setPaneView(Views.MAINPAGE.getFXML());
    }

    @FXML
    public void setGlobalResumeView(ActionEvent actionEvent)
    {
        setPaneView(Views.GLOBALSTATS.getFXML());
    }

    @FXML
    public void setCommunityView(ActionEvent actionEvent)
    {
        setPaneView(Views.COMMUNITY.getFXML());
    }

    @FXML
    public void goToLogin(ActionEvent actionEvent)
    {
        ViewHandler.loadStage(Views.LOGIN.getFXML());
    }

    @FXML
    public void systemExit(ActionEvent actionEvent)
    {
        Platform.exit();
    }

    @FXML
    public void returnToPreviousView(ActionEvent actionEvent)
    {
        db_return_button.debounce();
    }
}

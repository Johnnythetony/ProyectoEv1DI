package com.liceolapaz.dam.proyectoev1di.Controllers;

import com.liceolapaz.dam.proyectoev1di.DTO.GameFilterDTO;
import com.liceolapaz.dam.proyectoev1di.DTO.VideogameDTO;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Images;
import com.liceolapaz.dam.proyectoev1di.ResourcePaths.Stylesheets;
import com.liceolapaz.dam.proyectoev1di.Services.VideogameService;
import com.liceolapaz.dam.proyectoev1di.Utils.Debounce;
import com.liceolapaz.dam.proyectoev1di.ViewHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainPageController implements Initializable
{
    @FXML
    private VBox genreVB;

    @FXML
    private VBox companyVB;

    @FXML
    private VBox platformVB;

    @FXML
    private FlowPane listajuegosFP;

    private GameFilterDTO gameFilters;

    private VideogameService vg_service = new VideogameService();

    private ArrayList<VideogameDTO> juegos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ArrayList<String> genres = vg_service.getGenres();
        ArrayList<String> companies = vg_service.getCompanies();
        ArrayList<String> platforms = vg_service.getPlatforms();

        gameFilters = new GameFilterDTO("", new HashMap<>(), new HashMap<>(), new HashMap<>());

        for(String genre : genres)
        {
            CheckBox cb = new CheckBox(genre);
            cb.setOnAction(event -> addGenreCheckBoxFilter(genre));
            genreVB.getChildren().add(cb);
            gameFilters.getSelectedGenres().put(genre, false);
        }

        for(String company : companies)
        {
            CheckBox cb = new CheckBox(company);
            cb.setOnAction(event -> addCompanyCheckBoxFilter(company));
            companyVB.getChildren().add(cb);
            gameFilters.getSelectedCompanies().put(company, false);
        }

        for(String platform : platforms)
        {
            CheckBox cb = new CheckBox(platform);
            cb.setOnAction(event -> addPlatformCheckBoxFilter(platform));
            platformVB.getChildren().add(cb);
            gameFilters.getSelectedPlatforms().put(platform, false);
        }

        Debounce db = new Debounce();
        db.newKeyframe(e -> {
            gameFilters.setSearchText(db.getNewValue());
            applyFilters();
        });
    }

    @FXML
    public void applyFilters()
    {
        juegos = (ArrayList<VideogameDTO>) vg_service.getFiteredGames(gameFilters);

        for(VideogameDTO game : juegos)
        {
            listajuegosFP.getChildren().add(createGameCard(game));
        }
    }

    @FXML
    public void addGenreCheckBoxFilter(String filter)
    {
        gameFilters.getSelectedGenres().put(filter, true);
        applyFilters();
    }

    @FXML
    public void addCompanyCheckBoxFilter(String filter)
    {
        gameFilters.getSelectedCompanies().put(filter, true);
        applyFilters();
    }

    @FXML
    public void addPlatformCheckBoxFilter(String filter)
    {
        gameFilters.getSelectedPlatforms().put(filter, true);
        applyFilters();
    }

    private StackPane createGameCard(VideogameDTO game) {

        // --- Dimensiones Deseadas ---
        final double IMAGE_WIDTH = 80;
        final double IMAGE_HEIGHT = 120;

        // --- 1. Imagen (Portada) ---
        ImageView imageView = new ImageView();
        try {
            Image image;
            if(game.getPortada() != null)
            {
                image = new Image(game.getPortada(), IMAGE_WIDTH, IMAGE_HEIGHT, false, true);
            }
            else
            {
                image = new Image(Images.LOGIN_ICON.getResource_path(), IMAGE_WIDTH, IMAGE_HEIGHT, false, true);
            }
            imageView.setImage(image);
            imageView.setFitWidth(IMAGE_WIDTH);
            imageView.setFitHeight(IMAGE_HEIGHT);
        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.TRANSPARENT);
            alert.setContentText("No se pudo cargar la imagen");
            alert.getDialogPane().getStylesheets().add(ViewHandler.class.getResource(Stylesheets.DEFAULT.getResource_path()).toExternalForm());

            //ToDo Usar para localizar errores
            e.printStackTrace();

            alert.showAndWait();
        }

        // --- 2. Etiqueta (Título Superpuesto) ---
        Label titleLabel = new Label(game.getTitulo());

        titleLabel.setWrapText(true); // Permite que el texto se ajuste si es largo

        // --- 3. StackPane (Contenedor de Superposición) ---
        StackPane gameCard = new StackPane();
        gameCard.setPrefSize(IMAGE_WIDTH, IMAGE_HEIGHT);

        // Posicionar el título en la parte inferior del StackPane
        StackPane.setAlignment(titleLabel, Pos.BOTTOM_CENTER);

        // Añadir imagen y título. El que se añade último queda encima.
        gameCard.getChildren().addAll(imageView, titleLabel);

        // Espacio entre tarjetas en el FlowPane
        gameCard.setPadding(new Insets(5, 5, 5, 5));

        return gameCard;
    }
}

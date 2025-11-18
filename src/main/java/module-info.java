module com.liceolapaz.dam.proyectoev1di {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.liceolapaz.dam.proyectoev1di to javafx.fxml;
    exports com.liceolapaz.dam.proyectoev1di;
}
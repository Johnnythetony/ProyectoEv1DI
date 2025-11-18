module com.liceolapaz.dam.proyectoev1di {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.dlsc.formsfx;

    opens com.liceolapaz.dam.proyectoev1di to javafx.fxml;
    exports com.liceolapaz.dam.proyectoev1di;
}
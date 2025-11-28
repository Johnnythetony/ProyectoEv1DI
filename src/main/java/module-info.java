module com.liceolapaz.dam.proyectoev1di {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.dlsc.formsfx;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens com.liceolapaz.dam.proyectoev1di to javafx.fxml;
    exports com.liceolapaz.dam.proyectoev1di;
    exports com.liceolapaz.dam.proyectoev1di.Controllers;
    opens com.liceolapaz.dam.proyectoev1di.Controllers to javafx.fxml;
    exports com.liceolapaz.dam.proyectoev1di.ResourcePaths;
    opens com.liceolapaz.dam.proyectoev1di.ResourcePaths to javafx.fxml;
}
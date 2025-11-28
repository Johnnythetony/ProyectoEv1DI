module com.liceolapaz.dam.proyectoev1di {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.dlsc.formsfx;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires io.github.cdimascio.dotenv.java;
    requires java.naming;

    opens com.liceolapaz.dam.proyectoev1di to javafx.fxml, org.hibernate.orm.core;
    opens com.liceolapaz.dam.proyectoev1di.Controllers to javafx.fxml, org.hibernate.orm.core;
    opens com.liceolapaz.dam.proyectoev1di.ResourcePaths to javafx.fxml, org.hibernate.orm.core;
    opens com.liceolapaz.dam.proyectoev1di.DAO to javafx.fxml, org.hibernate.orm.core;
    opens com.liceolapaz.dam.proyectoev1di.DBConnectivity to javafx.fxml, org.hibernate.orm.core;
    opens com.liceolapaz.dam.proyectoev1di.DTO to javafx.fxml, org.hibernate.orm.core;
    opens com.liceolapaz.dam.proyectoev1di.Utils to javafx.fxml, org.hibernate.orm.core;
    exports com.liceolapaz.dam.proyectoev1di;
    exports com.liceolapaz.dam.proyectoev1di.Controllers;
    exports com.liceolapaz.dam.proyectoev1di.ResourcePaths;
    exports com.liceolapaz.dam.proyectoev1di.DAO;
    exports com.liceolapaz.dam.proyectoev1di.DBConnectivity;
    exports com.liceolapaz.dam.proyectoev1di.DTO;
    exports com.liceolapaz.dam.proyectoev1di.Utils;

}
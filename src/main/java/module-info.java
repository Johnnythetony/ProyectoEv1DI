module com.liceolapaz.dam.proyectoev1di {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires com.dlsc.formsfx;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires io.github.cdimascio.dotenv.java;
    requires java.naming;
    requires jbcrypt;
    requires org.mapstruct;

    opens com.liceolapaz.dam.proyectoev1di to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.Controllers to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.ResourcePaths to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.DAO to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.DBConnectivity to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.DTO to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.Utils to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    opens com.liceolapaz.dam.proyectoev1di.Mapper to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    exports com.liceolapaz.dam.proyectoev1di.Mapper;
    exports com.liceolapaz.dam.proyectoev1di;
    exports com.liceolapaz.dam.proyectoev1di.Controllers;
    exports com.liceolapaz.dam.proyectoev1di.ResourcePaths;
    exports com.liceolapaz.dam.proyectoev1di.DAO;
    exports com.liceolapaz.dam.proyectoev1di.DBConnectivity;
    exports com.liceolapaz.dam.proyectoev1di.DTO;
    exports com.liceolapaz.dam.proyectoev1di.Utils;
    opens com.liceolapaz.dam.proyectoev1di.Entities to javafx.fxml, org.hibernate.orm.core, org.mapstruct;
    exports com.liceolapaz.dam.proyectoev1di.Entities;
    exports com.liceolapaz.dam.proyectoev1di.Services;
    opens com.liceolapaz.dam.proyectoev1di.Services to javafx.fxml, org.hibernate.orm.core, org.mapstruct;

}
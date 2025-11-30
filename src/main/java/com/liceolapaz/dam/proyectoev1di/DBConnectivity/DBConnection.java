package com.liceolapaz.dam.proyectoev1di.DBConnectivity;

import com.liceolapaz.dam.proyectoev1di.Entities.User;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection
{
    private static SessionFactory session_factory;
    private Session session;

    protected DBConnection()
    {
        if (session_factory == null)
        {
            createSessionFactory();
        }
    }

    protected void createSessionFactory()
    {
        Dotenv dotenv = Dotenv.configure()
                .directory(this.getClass().getClassLoader().getResource(".env").toString())
                .filename(".env")
                .load();

        Configuration hibernate_cfg = new Configuration();

        //Definir las propiedades de configuración de Hibernate
        hibernate_cfg.setProperty("hibernate.connection.url", AssemblyURL.assembleURL());
        hibernate_cfg.setProperty("hibernate.connection.driver_class", dotenv.get("DB_DRIVER_MYSQL"));
        hibernate_cfg.setProperty("hibernate.connection.username", dotenv.get("DB_USER_MYSQL"));
        hibernate_cfg.setProperty("hibernate.connection.password", dotenv.get("DB_PASSWORD_MYSQL"));
        hibernate_cfg.setProperty("hibernate.dialect",dotenv.get("DB_DIALECT"));
        hibernate_cfg.setProperty("hibernate.hbn2ddl.auto", dotenv.get("HBN2DDL_AUTO"));

        //Mostramos sql para depurar y a la hora de compilar para recibir pistas y autocompletar al escribir consultas
        hibernate_cfg.setProperty("hibernate.show_sql", "true");
        hibernate_cfg.setProperty("hibernate.format_sql", "true");

        //Mapear entidades
        hibernate_cfg.addAnnotatedClass(User.class);

        session_factory = hibernate_cfg.buildSessionFactory();
    }

    protected Session getSession()
    {
        if(session == null)
        {
            session = session_factory.openSession();
        }
        return session;
    }

    protected void initTransaction()
    {
        if(session_factory == null)
        {
            createSessionFactory();
        }
        getSession().getTransaction().begin();
    }

    protected void commitTransaction()
    {
        getSession().getTransaction().commit();
        session.close();
        session = null;
    }
}

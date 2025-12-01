package com.liceolapaz.dam.proyectoev1di.ResourcePaths;

public enum SSLCerts
{
    TRUSTSTORE("truststore.jks");

    private final String resource_path;

    SSLCerts(String ssl_cert) { this.resource_path = "SSL-certs/"+ssl_cert; }

    public String getResource_path() { return resource_path; }
}

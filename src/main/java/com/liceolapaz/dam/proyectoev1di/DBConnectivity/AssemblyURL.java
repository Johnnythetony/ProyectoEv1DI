package com.liceolapaz.dam.proyectoev1di.DBConnectivity;

import io.github.cdimascio.dotenv.Dotenv;

public class AssemblyURL
{
    public static String assembleURL()
    {
        Dotenv de = Dotenv.configure()
                .directory(AssemblyURL.class.getClassLoader().getResource(".env").toString())
                .filename(".env")
                .load();

        StringBuilder url = new StringBuilder();

        url.append(de.get("DB_URL"));
        url.append("?useSSL=true");
        url.append("&sslMode=VERIFY_IDENTITY");
        url.append("&trustCertificateKeyStoreUrl=");
        url.append(AssemblyURL.class.getClassLoader().getResource("SSL-certs/truststore.jks").toString());
        url.append("&trustCertificateKeyStorePassword=");
        url.append(de.get("TRUSTSTORE_PASSWORD"));

        return url.toString();
    }
}

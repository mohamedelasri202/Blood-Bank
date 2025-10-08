package com.bloodbank.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "bloodbankPU";
    private static EntityManagerFactory factory;

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/config.properties"));

            Map<String, String> dbSettings = new HashMap<>();
            dbSettings.put("jakarta.persistence.jdbc.url", props.getProperty("DB_URL"));
            dbSettings.put("jakarta.persistence.jdbc.user", props.getProperty("DB_USER"));
            dbSettings.put("jakarta.persistence.jdbc.password", props.getProperty("DB_PASSWORD"));


            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, dbSettings);
            System.out.println(" Database connection initialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load database configuration file!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(" Failed to create EntityManagerFactory!");
        }
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void closeFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}

package com.examen.repositories.implement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/Gestion_ecole"; // URL de votre base de données
    private static final String USER = "postgres"; // Nom d'utilisateur PostgreSQL
    private static final String PASSWORD = "root"; // Mot de passe PostgreSQL

    // Méthode pour établir une connexion à la base de données
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la connexion à la base de données");
        }
    }
}

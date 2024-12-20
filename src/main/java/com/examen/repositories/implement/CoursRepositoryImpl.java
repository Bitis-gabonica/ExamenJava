package com.examen.repositories.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examen.entity.Cours;
import com.examen.entity.Niveau;
import com.examen.entity.Professeur;
import com.examen.repositories.interfaces.CoursRepository;

public class CoursRepositoryImpl implements CoursRepository {
    private final Connection connection;

    // Constructeur pour initialiser la connexion
    public CoursRepositoryImpl() {
        this.connection = DatabaseConnection.getConnection(); // Utilisation de DatabaseConnection
    }

    @Override
    public void insert(Cours cours) {
        String sql = "INSERT INTO cours (module, professeur_id, niveau_id) VALUES (?, ?, ?)";
        try (PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            psmt.setString(1, cours.getModule());
            psmt.setInt(2, cours.getProfesseur().getId()); // ID du professeur
            psmt.setInt(3, cours.getNiveau().getId());     // ID du niveau

            psmt.executeUpdate();

            // Récupérer l'ID généré automatiquement
            ResultSet generatedKeys = psmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                cours.setId(generatedKeys.getInt(1));
                System.out.println("Cours inséré avec ID : " + cours.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'insertion du cours");
        }
    }

    @Override
    public List<Cours> lister() {
        List<Cours> courses = new ArrayList<>();
        String sql = "SELECT c.id, c.module, p.id as professeur_id, p.nom as professeur_nom, "
                   + "n.id as niveau_id, n.nom as niveau_nom "
                   + "FROM cours c "
                   + "JOIN professeur p ON c.professeur_id = p.id "
                   + "JOIN niveau n ON c.niveau_id = n.id";

        try (PreparedStatement psmt = connection.prepareStatement(sql);
             ResultSet resultSet = psmt.executeQuery()) {

            while (resultSet.next()) {
                // Construire l'objet Professeur
                Professeur professeur = new Professeur();
                professeur.setId(resultSet.getInt("professeur_id"));
                professeur.setNom(resultSet.getString("professeur_nom"));

                // Construire l'objet Niveau
                Niveau niveau = new Niveau();
                niveau.setId(resultSet.getInt("niveau_id"));
                niveau.setNom(resultSet.getString("niveau_nom"));

                // Construire l'objet Cours
                Cours cours = new Cours();
                cours.setId(resultSet.getInt("id"));
                cours.setModule(resultSet.getString("module"));
                cours.setProfesseur(professeur);
                cours.setNiveau(niveau);

                courses.add(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la récupération des cours");
        }

        return courses;
    }
}

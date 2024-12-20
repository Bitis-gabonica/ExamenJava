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
import com.examen.repositories.interfaces.ProfesseurRepository;

public class ProfesseurRepositoryImpl implements ProfesseurRepository {
    private final Connection connection;

    // Constructeur pour initialiser la connexion
    public ProfesseurRepositoryImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insert(Professeur professeur) {
        String sql = "INSERT INTO professeur (nom) VALUES (?)";
        try (PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            psmt.setString(1, professeur.getNom()); // Insérer le nom du professeur

            psmt.executeUpdate();

            // Récupérer l'ID généré automatiquement
            ResultSet generatedKeys = psmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                professeur.setId(generatedKeys.getInt(1));
                System.out.println("Professeur inséré avec ID : " + professeur.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'insertion du professeur");
        }
    }

    @Override
    public List<Professeur> lister() {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM professeur";

        try (PreparedStatement psmt = connection.prepareStatement(sql);
             ResultSet resultSet = psmt.executeQuery()) {

            while (resultSet.next()) {
                // Construire l'objet Professeur
                Professeur professeur = new Professeur();
                professeur.setId(resultSet.getInt("id"));
                professeur.setNom(resultSet.getString("nom"));

                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la récupération des professeurs");
        }

        return professeurs;
    }

    @Override
    public List<Cours> listerCoursByProfesseur(String nomProfesseur) {
        List<Cours> coursList = new ArrayList<>();
        String sql = "SELECT co.id, co.module, n.id as niveau_id, n.nom as niveau_nom, "
                   + "p.id as professeur_id, p.nom as professeur_nom "
                   + "FROM cours co "
                   + "JOIN professeur p ON co.professeur_id = p.id "
                   + "JOIN niveau n ON co.niveau_id = n.id "
                   + "WHERE p.nom = ?";

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, nomProfesseur); // Filtrer par nom du professeur

            try (ResultSet resultSet = psmt.executeQuery()) {
                while (resultSet.next()) {
                    // Construire l'objet Niveau
                    Niveau niveau = new Niveau();
                    niveau.setId(resultSet.getInt("niveau_id"));
                    niveau.setNom(resultSet.getString("niveau_nom"));

                    // Construire l'objet Cours
                    Cours cours = new Cours();
                    cours.setId(resultSet.getInt("id"));
                    cours.setModule(resultSet.getString("module"));
                    cours.setNiveau(niveau);

                    coursList.add(cours);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la récupération des cours par professeur");
        }

        return coursList;
    }
}


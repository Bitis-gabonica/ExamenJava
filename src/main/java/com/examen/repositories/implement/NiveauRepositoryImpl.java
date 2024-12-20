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
import com.examen.repositories.interfaces.NiveauRepository;

public class NiveauRepositoryImpl implements NiveauRepository {
    private final Connection connection;

    // Constructeur pour initialiser la connexion
    public NiveauRepositoryImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insert(Niveau niveau) {
        String sql = "INSERT INTO niveau (nom) VALUES (?)";
        try (PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            psmt.setString(1, niveau.getNom()); // Insérer le nom du niveau

            psmt.executeUpdate();

            // Récupérer l'ID généré automatiquement
            ResultSet generatedKeys = psmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                niveau.setId(generatedKeys.getInt(1));
                System.out.println("Niveau inséré avec ID : " + niveau.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'insertion du niveau");
        }
    }

    @Override
    public List<Niveau> lister() {
        List<Niveau> niveaux = new ArrayList<>();
        String sql = "SELECT * FROM niveau";

        try (PreparedStatement psmt = connection.prepareStatement(sql);
             ResultSet resultSet = psmt.executeQuery()) {

            while (resultSet.next()) {
                // Construire l'objet Niveau
                Niveau niveau = new Niveau();
                niveau.setId(resultSet.getInt("id"));
                niveau.setNom(resultSet.getString("nom"));

                niveaux.add(niveau);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la récupération des niveaux");
        }

        return niveaux;
    }

    @Override
    public List<Cours> listerCoursByNiveau(String nomNiveau) {
        List<Cours> coursList = new ArrayList<>();
        String sql = "SELECT co.id, co.module, n.id as niveau_id, n.nom as niveau_nom "
                   + "FROM cours co "
                   + "JOIN niveau n ON co.niveau_id = n.id "
                   + "WHERE n.nom = ?";

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, nomNiveau); // Filtrer par nom du niveau

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
            throw new RuntimeException("Erreur lors de la récupération des cours par niveau");
        }

        return coursList;
    }
}

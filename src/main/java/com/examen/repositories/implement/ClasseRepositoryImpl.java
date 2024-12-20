package com.examen.repositories.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examen.entity.Classe;
import com.examen.entity.Cours;
import com.examen.entity.Niveau;
import com.examen.repositories.interfaces.ClasseRepository;

public class ClasseRepositoryImpl implements ClasseRepository {
    private final Connection connection;

    // Constructeur pour initialiser la connexion
    public ClasseRepositoryImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insert(Classe classe) {
        String sql = "INSERT INTO classe (nom, niveau_id) VALUES (?, ?)";
        try (PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            psmt.setString(1, classe.getNom()); // Insérer le nom de la classe
            psmt.setInt(2, classe.getNiveau().getId()); // Insérer l'ID du niveau

            psmt.executeUpdate();

            // Récupérer l'ID généré automatiquement
            ResultSet generatedKeys = psmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                classe.setId(generatedKeys.getInt(1));
                System.out.println("Classe insérée avec ID : " + classe.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de l'insertion de la classe");
        }
    }

    @Override
    public List<Classe> lister() {
        List<Classe> classes = new ArrayList<>();
        String sql = "SELECT c.id, c.nom, n.id as niveau_id, n.nom as niveau_nom "
                   + "FROM classe c "
                   + "JOIN niveau n ON c.niveau_id = n.id";

        try (PreparedStatement psmt = connection.prepareStatement(sql);
             ResultSet resultSet = psmt.executeQuery()) {

            while (resultSet.next()) {
                // Construire l'objet Niveau
                Niveau niveau = new Niveau();
                niveau.setId(resultSet.getInt("niveau_id"));
                niveau.setNom(resultSet.getString("niveau_nom"));

                // Construire l'objet Classe
                Classe classe = new Classe();
                classe.setId(resultSet.getInt("id"));
                classe.setNom(resultSet.getString("nom"));
                classe.setNiveau(niveau);

                classes.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la récupération des classes");
        }

        return classes;
    }

    @Override
    public List<Cours> listerCoursByClasse(String nomClasse) {
        List<Cours> coursList = new ArrayList<>();
        String sql = "SELECT co.id, co.module, n.id as niveau_id, n.nom as niveau_nom, "
                   + "cl.id as classe_id, cl.nom as classe_nom "
                   + "FROM cours co "
                   + "JOIN niveau n ON co.niveau_id = n.id "
                   + "JOIN classe_cours cc ON co.id = cc.cours_id "
                   + "JOIN classe cl ON cc.classe_id = cl.id "
                   + "WHERE cl.nom = ?";

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, nomClasse); // Filtrer par nom de la classe

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
            throw new RuntimeException("Erreur lors de la récupération des cours par classe");
        }

        return coursList;
    }
}


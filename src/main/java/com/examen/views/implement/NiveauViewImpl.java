package com.examen.views.implement;

import java.util.List;
import java.util.Scanner;

import com.examen.entity.Cours;
import com.examen.entity.Niveau;
import com.examen.views.interfaces.NiveauView;

public class NiveauViewImpl implements NiveauView {

   @Override
public Niveau saisitNiveau() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("===== Saisie d'un Niveau =====");
    System.out.print("Entrez le nom du niveau : ");
    String nom = scanner.nextLine();

    // Création de l'objet Niveau
    Niveau niveau = new Niveau();
    niveau.setNom(nom);

    System.out.println("Niveau saisi avec succès !");
    return niveau;
}

@Override
public void listerCoursByNiveau(List<Cours> cours) {
    System.out.println("===== Liste des Cours par Niveau =====");

    if (cours.isEmpty()) {
        System.out.println("Aucun cours disponible pour ce niveau.");
        return;
    }

    for (Cours coursItem : cours) {
        System.out.println("ID: " + coursItem.getId() +
                ", Module: " + coursItem.getModule() +
                ", Professeur: " + (coursItem.getProfesseur() != null ? coursItem.getProfesseur().getNom() : "Non attribué") +
                ", Niveau: " + (coursItem.getNiveau() != null ? coursItem.getNiveau().getNom() : "Non spécifié"));
    }
}



   
    
}

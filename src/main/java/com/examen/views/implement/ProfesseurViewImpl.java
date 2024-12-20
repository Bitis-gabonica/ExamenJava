package com.examen.views.implement;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.views.interfaces.ProfesseurView;

public class ProfesseurViewImpl implements ProfesseurView {

    @Override
public void listerCoursByProfesseur(List<Cours> cours) {
    System.out.println("===== Liste des Cours par Professeur =====");

    if (cours.isEmpty()) {
        System.out.println("Aucun cours disponible pour ce professeur.");
        return;
    }

    for (Cours coursItem : cours) {
        System.out.println("ID: " + coursItem.getId() +
                ", Module: " + coursItem.getModule() +
                ", Niveau: " + (coursItem.getNiveau() != null ? coursItem.getNiveau().getNom() : "Non spécifié"));
    }
}

    
}

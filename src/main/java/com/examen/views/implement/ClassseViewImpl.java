package com.examen.views.implement;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.views.interfaces.ClasseView;

public class ClassseViewImpl implements ClasseView     {

    @Override
    public void listerCoursByClasse(List<Cours> cours) {
        System.out.println("===== Liste des Cours par Classe =====");
    
        if (cours.isEmpty()) {
            System.out.println("Aucun cours disponible pour cette classe.");
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

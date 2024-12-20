package com.examen.views.implement;

import java.util.Scanner;

import com.examen.entity.Cours;
import com.examen.entity.Niveau;
import com.examen.entity.Professeur;
import com.examen.views.interfaces.CoursView;

public class CoursViewImpl implements CoursView {

    @Override
    public Cours saisitCours() {
        Scanner scanner = new Scanner(System.in);

        // Saisie des informations de base
        System.out.println("===== Saisie d'un Cours =====");
        System.out.print("Entrez le nom du module : ");
        String module = scanner.nextLine();

        // Saisie des informations du professeur
        Professeur professeur = new Professeur();
        System.out.print("Entrez l'ID du professeur : ");
        professeur.setId(scanner.nextInt());
        scanner.nextLine(); // Consommer le saut de ligne

        // Saisie des informations du niveau
        Niveau niveau = new Niveau();
        System.out.print("Entrez l'ID du niveau : ");
        niveau.setId(scanner.nextInt());
        scanner.nextLine(); // Consommer le saut de ligne

        // Création de l'objet Cours
        Cours cours = new Cours();
        cours.setModule(module);
        cours.setProfesseur(professeur);
        cours.setNiveau(niveau);

        System.out.println("Cours saisi avec succès !");
        return cours;
    }
}

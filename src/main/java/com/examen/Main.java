package com.examen;

import java.util.List;
import java.util.Scanner;

import com.examen.entity.Cours;
import com.examen.entity.Niveau;
import com.examen.repositories.implement.ClasseRepositoryImpl;
import com.examen.repositories.implement.CoursRepositoryImpl;
import com.examen.repositories.implement.NiveauRepositoryImpl;
import com.examen.repositories.implement.ProfesseurRepositoryImpl;
import com.examen.repositories.interfaces.ClasseRepository;
import com.examen.repositories.interfaces.CoursRepository;
import com.examen.repositories.interfaces.NiveauRepository;
import com.examen.repositories.interfaces.ProfesseurRepository;
import com.examen.services.Implement.ClasseServicesImpl;
import com.examen.services.Implement.CoursServicesImpl;
import com.examen.services.Implement.NiveauServiceImplements;
import com.examen.services.Implement.ProfesseurServicesImpl;
import com.examen.services.interfaces.ClasseServices;
import com.examen.services.interfaces.CoursServices;
import com.examen.services.interfaces.NiveauService;
import com.examen.services.interfaces.ProfesseurServices;
import com.examen.views.implement.ClassseViewImpl;
import com.examen.views.implement.CoursViewImpl;
import com.examen.views.implement.NiveauViewImpl;
import com.examen.views.implement.ProfesseurViewImpl;
import com.examen.views.interfaces.ClasseView;
import com.examen.views.interfaces.CoursView;
import com.examen.views.interfaces.NiveauView;
import com.examen.views.interfaces.ProfesseurView;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ClasseRepository classeRepository = new ClasseRepositoryImpl();
        ClasseServices classesService = new ClasseServicesImpl(classeRepository);
        ClasseView classeView = new ClassseViewImpl();

        CoursRepository coursRepository = new CoursRepositoryImpl();
        CoursServices coursService = new CoursServicesImpl(coursRepository);
        CoursView coursView = new CoursViewImpl();

        NiveauRepository niveauRepository = new NiveauRepositoryImpl();
        NiveauService niveauService = new NiveauServiceImplements(niveauRepository);
        NiveauView niveauView = new NiveauViewImpl();

        ProfesseurRepository professeurRepository = new ProfesseurRepositoryImpl();
        ProfesseurServices professeurService = new ProfesseurServicesImpl(professeurRepository);
        ProfesseurView professeurView = new ProfesseurViewImpl();

        int choix = 0;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Créer un Cours");
            System.out.println("2. Créer un Niveau");
            System.out.println("3. Afficher les cours par Niveau");
            System.out.println("4. Afficher les cours par Classe");
            System.out.println("5. Afficher les cours par Professeur");
            System.out.println("6. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                    // Saisie et création d'un cours
                    Cours cours = coursView.saisitCours();
                    coursService.insert(cours);
                    System.out.println("Cours créé avec succès !");
                    break;

                case 2:
                    // Saisie et création d'un niveau
                    Niveau niveau = niveauView.saisitNiveau();
                    niveauService.insert(niveau);
                    System.out.println("Niveau créé avec succès !");
                    break;

                case 3:
                    // Afficher les cours par niveau
                    System.out.print("Entrez le nom du niveau : ");
                    String nomNiveau = sc.nextLine();
                    List<Cours> coursParNiveau = niveauService.listerCoursByNiveau(nomNiveau);
                    niveauView.listerCoursByNiveau(coursParNiveau);
                    break;

                case 4:
                    // Afficher les cours par classe
                    System.out.print("Entrez le nom de la classe : ");
                    String nomClasse = sc.nextLine();
                    List<Cours> coursParClasse = classesService.listerCoursByClasse(nomClasse);
                    classeView.listerCoursByClasse(coursParClasse);
                    break;

                case 5:
                    // Afficher les cours par professeur
                    System.out.print("Entrez le nom du professeur : ");
                    String nomProfesseur = sc.nextLine();
                    List<Cours> coursParProfesseur = professeurService.listerCoursByProfesseur(nomProfesseur);
                    professeurView.listerCoursByProfesseur(coursParProfesseur);
                    break;

                case 6:
                    // Quitter le programme
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        } while (choix != 6);

        sc.close();
    }
}

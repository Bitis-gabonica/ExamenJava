package com.examen.entity;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode

public class Classe {
    
    private int id;
    private List<Cours> courses;
    private List<Etudiant> etudiants;
    private List<Professeur> professeurs;
    private Niveau niveau;
    private String nom;

    public Classe(int id, List<Cours> courses, List<Etudiant> etudiants, List<Professeur> professeurs, Niveau niveau,String nom) {
        this.id = id;
        this.courses = courses;
        this.etudiants = etudiants;
        this.professeurs = professeurs;
        this.niveau = niveau;
        this.nom = nom;
    }

    public Classe() {
    }

    

}

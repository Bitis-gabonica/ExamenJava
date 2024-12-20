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

public class Professeur {
    
    private int id;
    private String nom;
    private List<Cours> courses;
    private List<Classe> classes;

    
    public Professeur() {
    }

    public Professeur(List<Classe> classes, List<Cours> courses, int id, String nom) {
        this.classes = classes;
        this.courses = courses;
        this.id = id;
        this.nom = nom;
    }
}

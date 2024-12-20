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

public class Niveau {
    
    private int id;
    private String nom;
    private List<Cours> cours;
    private List<Classe> classes;

    public Niveau() {
    }

    public Niveau(List<Classe> classes, List<Cours> cours, int id, String nom) {
        this.classes = classes;
        this.cours = cours;
        this.id = id;
        this.nom = nom;
    }
    

}

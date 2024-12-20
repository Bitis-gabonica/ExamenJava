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

public class Etudiant {

    private int id;
    private String nomComplet;
    private Classe classe;
    private List<Cours> courses;
    private Niveau niveau;
    
    public Etudiant() {
    }

    public Etudiant(Classe classe, List<Cours> courses, int id, Niveau niveau, String nomComplet) {
        this.classe = classe;
        this.courses = courses;
        this.id = id;
        this.niveau = niveau;
        this.nomComplet = nomComplet;
    }

}

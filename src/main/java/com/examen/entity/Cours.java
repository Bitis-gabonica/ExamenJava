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

public class Cours {


    private int id;
    private Professeur professeur;
    private List<Classe> classes;
    private String module;
    private Niveau niveau;
    private List<Session> sessions;

    
    public Cours() {
    }

    public Cours(List<Classe> classes, int id, String module, Niveau niveau, Professeur professeur, List<Session> sessions) {
        this.classes = classes;
        this.id = id;
        this.module = module;
        this.niveau = niveau;
        this.professeur = professeur;
        this.sessions = sessions;
    }
}

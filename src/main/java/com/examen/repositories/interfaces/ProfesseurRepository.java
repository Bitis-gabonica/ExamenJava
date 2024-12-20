package com.examen.repositories.interfaces;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.entity.Professeur;

public interface ProfesseurRepository extends Repository<Professeur> {
    public List<Cours> listerCoursByProfesseur(String nom); 

}

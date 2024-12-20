package com.examen.repositories.interfaces;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.entity.Niveau;


public interface NiveauRepository extends Repository<Niveau> {

    public List<Cours> listerCoursByNiveau(String Nom); 
}

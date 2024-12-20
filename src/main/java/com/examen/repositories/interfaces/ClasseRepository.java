package com.examen.repositories.interfaces;

import java.util.List;

import com.examen.entity.Classe;
import com.examen.entity.Cours;

public interface ClasseRepository extends Repository<Classe> {

public List<Cours> listerCoursByClasse(String nom); 
}



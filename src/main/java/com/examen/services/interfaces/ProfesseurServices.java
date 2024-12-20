package com.examen.services.interfaces;

import java.util.List;

import com.examen.entity.Classe;
import com.examen.entity.Cours;
import com.examen.entity.Professeur;

public interface ProfesseurServices {
public  void insert(Professeur professeur);
   
 public List<Professeur> lister(); 
 public List<Cours> listerCoursByProfesseur(String Nom); 
}

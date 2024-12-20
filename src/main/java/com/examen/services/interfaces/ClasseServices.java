package com.examen.services.interfaces;

import java.util.List;

import com.examen.entity.Classe;
import com.examen.entity.Cours;

public interface ClasseServices {


public  void insert(Classe classe);
   
 public List<Classe> lister(); 
 public List<Cours> listerCoursByClasse(String Nom); 
}

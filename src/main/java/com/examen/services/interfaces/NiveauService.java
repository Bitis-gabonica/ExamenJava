package com.examen.services.interfaces;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.entity.Niveau;

public interface NiveauService {
public  void insert(Niveau niveau);
   
 public List<Niveau> lister(); 
 public List<Cours> listerCoursByNiveau(String Nom); 
}

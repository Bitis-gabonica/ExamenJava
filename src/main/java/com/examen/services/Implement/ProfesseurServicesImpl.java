package com.examen.services.Implement;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.entity.Professeur;
import com.examen.repositories.interfaces.ProfesseurRepository;
import com.examen.services.interfaces.ProfesseurServices;

public class ProfesseurServicesImpl implements ProfesseurServices {

    private final ProfesseurRepository professeurRepository;

    public ProfesseurServicesImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }


    @Override
    public void insert(Professeur professeur) {
       professeurRepository.insert(professeur);
    }

    @Override
    public List<Professeur> lister() {
        return professeurRepository.lister();
        
    }

    @Override
    public List<Cours> listerCoursByProfesseur(String Nom) {
        return professeurRepository.listerCoursByProfesseur(Nom);
    }
    
}

package com.examen.services.Implement;

import java.util.List;

import com.examen.entity.Classe;
import com.examen.entity.Cours;
import com.examen.entity.Niveau;
import com.examen.repositories.interfaces.NiveauRepository;
import com.examen.services.interfaces.NiveauService;

public class NiveauServiceImplements implements NiveauService {

    private final NiveauRepository niveauRepository;

    public NiveauServiceImplements(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }



    @Override
    public void insert(Niveau niveau) {
        niveauRepository.insert(niveau);
    }

    @Override
    public List<Niveau> lister() {
        return niveauRepository.lister();
    }

    @Override
    public List<Cours> listerCoursByNiveau(String Nom) {
        
        return niveauRepository.listerCoursByNiveau(Nom);
    }
    
}

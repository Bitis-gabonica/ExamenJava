package com.examen.services.Implement;

import java.util.List;

import com.examen.entity.Classe;
import com.examen.entity.Cours;
import com.examen.repositories.interfaces.ClasseRepository;
import com.examen.services.interfaces.ClasseServices;

public class ClasseServicesImpl implements ClasseServices {

    private final ClasseRepository classeRepository;

    public ClasseServicesImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }


    @Override
    public void insert(Classe classe) {
        classeRepository.insert(classe);
    }

    @Override
    public List<Classe> lister() {
        return classeRepository.lister();
       
    }

    @Override
    public List<Cours> listerCoursByClasse(String Nom) {
        return classeRepository.listerCoursByClasse(Nom);
    }
    


}

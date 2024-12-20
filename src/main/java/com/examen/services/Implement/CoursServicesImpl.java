package com.examen.services.Implement;

import java.util.List;

import com.examen.entity.Cours;
import com.examen.repositories.interfaces.CoursRepository;
import com.examen.services.interfaces.CoursServices;

public class CoursServicesImpl implements CoursServices {

    private final CoursRepository coursRepository;

    public CoursServicesImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }


    @Override
    public void insert(Cours cours) {
        coursRepository.insert(cours);
    }

    @Override
    public List<Cours> lister() {
       return coursRepository.lister();
    }
    
}

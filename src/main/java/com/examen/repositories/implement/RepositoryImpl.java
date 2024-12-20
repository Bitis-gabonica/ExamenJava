package com.examen.repositories.implement;

import java.util.ArrayList;
import java.util.List;

import com.examen.repositories.interfaces.Repository;

public class RepositoryImpl <T> implements Repository<T> {
    protected  final List<T> list=new ArrayList<>();
    
    @Override
    public  void insert(T data){
        list.add(data);

    }
    @Override
    public List<T> lister(){
        return list;
    }
}

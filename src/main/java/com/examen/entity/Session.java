package com.examen.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode

class Session {
    private int id;
    private String date;
    private String startTime;
    private String endTime;
    private String location; //
    private Cours cours;


    
    public Session(int id, String date, String startTime, String endTime, String location, Cours cours) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.cours = cours;
    }

    public Session() {
    }

}

package com.sport.thoris.ridiculusfc.models;

import java.util.List;

/**
 * Created by thoris on 17/11/2017.
 */

public class Partida {

    private List<Time> times;

    public List<Time> getTimes() {return this.times; }
    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public Partida(){
    }

}

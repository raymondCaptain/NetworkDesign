package com.example.networkdesign.NetworkDesign.Model;

public class Movie {
    /**
     * act : rose
     * name : avater
     * actvie : true
     */

    private String act;
    private String name;
    private boolean actvie;

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActvie() {
        return actvie;
    }

    public void setActvie(boolean actvie) {
        this.actvie = actvie;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "act='" + act + '\'' +
//                ", name='" + name + '\'' +
//                ", actvie=" + actvie +
//                '}';
//    }
}

package com.company.entities;

public class SeniorManager {
    private int id ;
    private String name;

    public SeniorManager(String name){

    }

    public SeniorManager(int id, String name){
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Senior Manager id: " + getId() + " , name: " + getName();}
}


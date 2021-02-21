package com.company.entities;

public class ProjectManager {
    private int id;
    private String name;
    private int project;
    private int senior_manager_id;

    public ProjectManager(int id, String name){

    }

    public ProjectManager(String name , int project , int senior_manager_id){
        setName(name);
        setProject(project);
        setSenior_manager_id(senior_manager_id);
    }

    public ProjectManager(int id , String name , int project , int senior_manager_id){
        setId(id);
        setName(name);
        setProject(project);
        setSenior_manager_id(senior_manager_id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getSenior_manager_id() {
        return senior_manager_id;
    }

    public void setSenior_manager_id(int senior_manager_id) {
        this.senior_manager_id = senior_manager_id;
    }

    @Override
    public String toString(){
        return "Project Manager ID : " + getId() + ", name " + getName() + ", project: " + getProject() + ", senior Manager id : " + senior_manager_id;
    }
}

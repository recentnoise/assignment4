package com.company.controllers;
import java.util.List;

import com.company.entities.ProjectManager;
import com.company.entities.SeniorManager;
import com.company.repositories.interfaces.SeniorManagerRepository;
public class SeniorManagerController {
    private final SeniorManagerRepository repo;

    public SeniorManagerController(SeniorManagerRepository repo){
        this.repo = repo;
    }

    public String createSeniorManager(String name){
        SeniorManager seniorManager = new SeniorManager(name);

        boolean created = repo.createSeniorManager(seniorManager);
        return (created ? "SeniorManager was created!" : "SeniorManager wasn't created!");
    }

    public String getSeniorManager(int id){
        ProjectManager seniorManager = repo.getSeniorManager(id);
        return (seniorManager == null ? "SeniorManager was not found" : seniorManager.toString());

    }
    public String getAllSeniorManagers(){
        List<SeniorManager> seniorManagers = repo.getAllSeniorManagers();
        return seniorManagers.toString();
    }
}

package com.company.controllers;

import java.util.List;

import com.company.entities.ProjectManager;
import com.company.entities.SeniorManager;
import com.company.repositories.interfaces.ProjectManagerRepository;
import com.company.repositories.interfaces.SeniorManagerRepository;

public class ProjectManagerController {
    private final ProjectManagerRepository repo;
    private final SeniorManagerRepository senirepo;

    public ProjectManagerController(ProjectManagerRepository repo , SeniorManagerRepository senirepo){
        this.repo = repo;
        this.senirepo = senirepo;
    }

    public String createProjectManager(String name , int project , int senior_manager_id){
        ProjectManager projectManager = new ProjectManager(name , project , senior_manager_id);

        boolean created= repo.createProjectManager(projectManager);

        return(created ? "Project Manager was created!" : "Project Manager wasn't created!");

    }

    public String getProjectManager(int id){
    ProjectManager projectManager = repo.getProjectManager(id);
return(projectManager == null ? "Project MAnager not found!" : projectManager.toString());

    }
public  String getAllProjectManager(){
List<ProjectManager> projectManagers = repo.getAllProjectManager();

return projectManagers.toString();
}

public String createSeniorManager(String name){
 SeniorManager seniorManager = new SeniorManager(name);

 boolean created = senirepo.createSeniorManager(seniorManager);

 return (created ? "Senior manager was created !" : "Senior manager wasn't created!");

}
    public ProjectManager getSeniorManager(int id){
        ProjectManager seniorManager = senirepo.getSeniorManager(id);
        return  seniorManager;
    }

    public String getAllSeniorManagers(int id){
        List<SeniorManager> seniorManagers = senirepo.getAllSeniorManagers();

        return seniorManagers.toString();
    }

}

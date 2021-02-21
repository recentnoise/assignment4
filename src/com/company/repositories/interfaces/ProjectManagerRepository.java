package com.company.repositories.interfaces;

import com.company.entities.ProjectManager;
import com.company.entities.SeniorManager;
import java.util.List;
public interface ProjectManagerRepository extends SeniorManagerRepository {
    boolean createProjectManager(ProjectManager projectManager);
    ProjectManager getProjectManager(int id);
    List<ProjectManager> getAllProjectManager();

}

package com.company.repositories.interfaces;

import com.company.entities.ProjectManager;
import com.company.entities.SeniorManager;

import java.util.List;
    public interface SeniorManagerRepository {
    boolean createSeniorManager(SeniorManager seniorManager);
    ProjectManager getSeniorManager(int id);
    List<SeniorManager> getAllSeniorManagers();
}

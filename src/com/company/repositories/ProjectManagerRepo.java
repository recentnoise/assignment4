package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.ProjectManager;
import com.company.entities.SeniorManager;
import com.company.repositories.interfaces.ProjectManagerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerRepo implements ProjectManagerRepository {
    private final IDB db;

    public ProjectManagerRepo(IDB db){
        this.db = db;
    }

    @Override
public boolean createProjectManager(ProjectManager projectManager){
    Connection connect = null;
    try {
        connect = db.getConnection();
        String sql ="INSERT INTO ProjectManagers(name , project , senior_manager_id ) VALUES (?,?,?)";

        PreparedStatement st = connect.prepareStatement(sql);
        st.setString(1,projectManager.getName());
        st.setInt(1,projectManager.getProject());
        st.setInt(1,projectManager.getSenior_manager_id());
        boolean executed = st.execute();
        return executed;
    }catch (SQLException throwables){
    throwables.printStackTrace();
    }catch (ClassNotFoundException e) {
        e.printStackTrace();
    }finally {
        try {
        connect.close();
        } catch (SQLException throwables){
        throwables.printStackTrace();
        }
    }
    return false;
    }

    @Override

    public ProjectManager getProjectManager(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,project , senior_manager_id FROM ProjectManagers WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);


            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProjectManager projectManager = new ProjectManager(rs.getInt("id") , rs.getString("name") , rs.getInt("project") , rs.getInt("senior_manager_id"));


                return projectManager;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<ProjectManager> getAllProjectManager(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM ProjectManager";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<ProjectManager> projectManagers = new ArrayList<>();
            while (rs.next()) {
                ProjectManager projectManager = new ProjectManager(rs.getInt("id"),
                        rs.getString("name") , rs.getInt("project") , rs.getInt("senior_manager_id"));


                projectManagers.add(projectManager);
            }

            return projectManagers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean createSeniorManager(SeniorManager seniorManager) {
        return false;
    }

    @Override
    public ProjectManager getSeniorManager(int id) {
        return null;
    }

    @Override
    public List<SeniorManager> getAllSeniorManagers() {
        return null;
    }
}


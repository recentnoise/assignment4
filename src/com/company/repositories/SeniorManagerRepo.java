package com.company.repositories;
import com.company.data.interfaces.IDB;
import com.company.entities.ProjectManager;
import com.company.entities.SeniorManager;
import com.company.repositories.interfaces.SeniorManagerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SeniorManagerRepo implements SeniorManagerRepository {
    private final IDB db;

    public SeniorManagerRepo(IDB db){
        this.db = db;
    }

    @Override
public boolean createSeniorManager(SeniorManager seniorManager){
        Connection connection = null;
        try{
            connection = db.getConnection();
            String sql ="INSERT INTO SeniorManagers(name) VALUES(?)";
            PreparedStatement statement =connection.prepareStatement(sql);

            boolean executed =statement.execute();
            return executed;
        }catch (SQLException throwables){
throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
    try{
connection.close();
    } catch (SQLException throwables){
        throwables.printStackTrace();
    }
        }
return false;
    }
    @Override
    public ProjectManager getSeniorManager(int id){
        Connection connection = null;
        try {
connection = db.getConnection();
String sql ="Select id, name FROM SeniorManagers WHERE id=?";
PreparedStatement statement =connection.prepareStatement(sql);
statement.setInt(1,id);
ResultSet resultSet = statement.executeQuery();
if(resultSet.next()){
    ProjectManager projectManager = new ProjectManager(resultSet.getInt("id") ,resultSet.getString("name"));
    return projectManager;
}
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
e.printStackTrace();
        }finally {
try {
connection.close();
} catch (SQLException throwables){
    throwables.printStackTrace();
}
        }
return null;
    }

    @Override
    public List<SeniorManager> getAllSeniorManagers(){
        Connection connection =null;
try {
connection = db.getConnection();
String sql = "Select id, name FROM SeniorManagers";
Statement statement = connection.createStatement();

ResultSet resultSet = statement.executeQuery(sql);
List<SeniorManager> seniorManagers =new ArrayList<>();
while (resultSet.next()){
SeniorManager seniorManager= new SeniorManager(resultSet.getInt("id"), resultSet.getString("name"));
seniorManagers.add(seniorManager);
}
return seniorManagers;
}catch (SQLException throwables){
throwables.printStackTrace();
}catch (ClassNotFoundException e ){
e.printStackTrace();
}finally {
try {
connection.close();
} catch (SQLException throwables){
    throwables.printStackTrace();
}
}
return null;
    }
}

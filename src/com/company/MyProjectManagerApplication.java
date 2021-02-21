package com.company;

import com.company.controllers.ProjectManagerController;
import com.company.repositories.interfaces.SeniorManagerRepository;
import com.company.repositories.interfaces.ProjectManagerRepository;

import java.util.Scanner;
public class MyProjectManagerApplication {
    private final ProjectManagerController controller;
    private final Scanner scanner;

    public MyProjectManagerApplication(SeniorManagerRepository seniorManagerRepository , ProjectManagerRepository projectManagerRepository){
        controller = new ProjectManagerController(projectManagerRepository, seniorManagerRepository);
        scanner = new Scanner(System.in);
    }

    public void start(){
while (true){
    System.out.println();
    System.out.println("Welcome to My Application");
    System.out.println("Select option:");
    System.out.println("1. Get all Project Manager");
    System.out.println("2. Get Project Manager by id");
    System.out.println("3. Create Project Manager");
    System.out.println("0. Exit");
    System.out.println();
    try{
        System.out.println("ENter option 1-3 :");
int option = scanner.nextInt();
if(option == 1){
    getAllProjectManagerMenu();
}else if (option == 2){
    getProjectManagerByIdMenu();
} else if (option == 3){
    createProjectManagerMenu();
} else {
    break;
}
    } catch (Exception e){
        System.out.println(e.getMessage());
        scanner.next();
    }
    System.out.println("*********************");
}
    }
    public void getAllProjectManagerMenu() {
        String response = controller.getAllProjectManager();
        System.out.println(response);
    }

    public void getProjectManagerByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getProjectManager(id);
        System.out.println(response);
    }

    public void createProjectManagerMenu() {
        System.out.println("Please enter senior_manager_id");
        Integer senior_manager_id = Integer.parseInt(scanner.next());
        try{
            var id = controller.getProjectManager(senior_manager_id);
        }
        catch (Exception ex){
            return;
        }

        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter project");
        Integer project = Integer.parseInt(scanner.next());


        String response = controller.createProjectManager(name, project, senior_manager_id);
        System.out.println(response);
    }
}

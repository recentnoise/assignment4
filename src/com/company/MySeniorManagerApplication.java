package com.company;


import com.company.controllers.ProjectManagerController;
import com.company.entities.SeniorManager;
import com.company.repositories.interfaces.SeniorManagerRepository;
import com.company.repositories.interfaces.ProjectManagerRepository;

import java.util.Scanner;

public class MySeniorManagerApplication {
    private final ProjectManagerController controller;
    private final Scanner scanner;
    private int id;

    public MySeniorManagerApplication(ProjectManagerRepository projectManagerRepository , SeniorManagerRepository seniorManagerRepository){
    controller = new ProjectManagerController(projectManagerRepository , seniorManagerRepository);
    scanner = new Scanner(System.in);
    }
    public void start(){
        while (true){
    System.out.println();
    System.out.println("Welcome to My Application");
    System.out.println("Select option:");
    System.out.println("1. Get all Seniors");
    System.out.println("2. Get Senior by id");
    System.out.println("3. Create Senior");
    System.out.println("0. Exit");
    System.out.println();
            try {
                System.out.println("Enter option (1-3): ");
                int option = scanner.nextInt();
                if(option == 1){
                    getAllSeniorManagersMenu();
                } else if(option == 2){
                    getAllSeniorManagersByIdMenu();
                } else if (option == 3){
                    createSeniorManager();
                } else {
break;
                }

        }catch (Exception e){
                System.out.println(e.getMessage());
                scanner.next();
            }
            System.out.println("****************************");
    }
}

    public void getAllSeniorManagersMenu() {
        String response = controller.getAllSeniorManagers(id);
        System.out.println(response);
    }

    public void getAllSeniorManagersByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String seniorManager = controller.getAllSeniorManagers(id);
        System.out.println((seniorManager == null ? "Lokomotive was not found!" : seniorManager.toString()));
    }

/*    public void createSeniorManagerMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();

        String response = controller.createSeniorManager(name);
        System.out.println(response);
    }*/

    public void createSeniorManager(){
        System.out.println("Please enter name:");
        String name = scanner.next();

        String response = controller.createSeniorManager(name);
        System.out.println(response);
    }

}

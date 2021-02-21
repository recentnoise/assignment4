package com.company;

import com.company.data.interfaces.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.SeniorManagerRepo;
import com.company.repositories.ProjectManagerRepo;
import com.company.repositories.interfaces.ProjectManagerRepository;
import com.company.repositories.interfaces.SeniorManagerRepository;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IDB db = new PostgresDB();
        ProjectManagerRepository projectManagerRepository = new ProjectManagerRepo(db);
        SeniorManagerRepository seniorManagerRepository = new SeniorManagerRepo(db);
        MyProjectManagerApplication appProject = new MyProjectManagerApplication(seniorManagerRepository, projectManagerRepository);
        MySeniorManagerApplication appSenior = new MySeniorManagerApplication(projectManagerRepository, projectManagerRepository);


        System.out.println("1. Senior manager");
        System.out.println("2. Project manager");
        System.out.print("Enter option (1-2): ");
        int option = scanner.nextInt();
        if (option == 1) {
            appSenior.start();
        } else if (option == 2) {
            appProject.start();
        }
    }
}
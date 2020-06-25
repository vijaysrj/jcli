package com.jcli;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProjectCommands {


    public static void createProject(String projectName) throws Exception{

        if(projectName!=null) {

            System.out.println("Creating project :"+projectName+"...");
            Files.createDirectory(Path.of(projectName));

            Files.createDirectory(Path.of(projectName + "/" + "src"));
            System.out.println("Source Directory created..");
            Files.createDirectory(Path.of(projectName + "/" + "out"));
            System.out.println("Output Directory created..");
        }
    }
}

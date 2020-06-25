package com.jcli;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;

public class PackageCommands {
    public static void createPackage(String packageName) throws Exception{


        if(packageName!=null) {
            try {

                System.out.println("Creating Package: " + packageName + "...");


                String[] folders = packageName.split("\\.");


                String directory = "src/";
                for (String folder : Arrays.asList(folders)) {


                    directory = directory + folder;


                    Files.createDirectory(Path.of(directory));

                    directory = directory + "/";
                }

                System.out.println("Packages created..");
            }catch(NoSuchFileException nse){

                throw new Exception("Please execute this command from the root folder of the project created");


            }


        }
    }
}

package com.jcli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCommands {


    public static void createFile(String fileName) throws IOException {


        if(fileName!=null){

            System.out.println("Creating file: "+fileName);



            Files.createFile(Path.of(fileName));
            System.out.println("File created..");

        }


    }

    public static void deleteFile(String fileName) throws IOException {

        if(fileName!=null){

            System.out.println("Deleting file: "+fileName+"...");
            String newFileName = fileName.replace(".","\\").replace("\\java",".java");

            newFileName = "src\\"+newFileName;


            Files.deleteIfExists(Path.of(newFileName));

            System.out.println("File deleted...");

        }

    }

    public static void editFile(String fileName) throws IOException {

    if(fileName!=null){

        String newFileName = fileName.replace(".","\\").replace("\\java",".java");

        newFileName = "src\\"+newFileName;


        RuntimeCommandsExecutor.execute("notepad.exe "+newFileName);


    }

    }
}

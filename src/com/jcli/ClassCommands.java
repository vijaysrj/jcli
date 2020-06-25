package com.jcli;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassCommands {

    public static void createClass(String className) throws Exception{

        if(className!=null){


            System.out.println("Creating class: "+className+"...");
            String newClassName = className.replace(".","\\").replace("\\java",".java");

            newClassName = "src\\"+newClassName;

            Files.createFile(Path.of(newClassName));


            String[] splitPath = className.split("\\.");



            String classOnlyName = splitPath[splitPath.length-2];




            try(BufferedWriter writer = Files.newBufferedWriter(Path.of(newClassName))){

                writer.write("package "+className.replace("."+classOnlyName+".java","")+";");
                writer.write("\n");

                writer.write("public class "+classOnlyName+" {");
                writer.write("\n");
                writer.write("}");

            }

System.out.println("Class created...");


        }

    }



}

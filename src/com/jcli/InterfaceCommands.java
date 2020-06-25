package com.jcli;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class InterfaceCommands {

    public static void createInterface(String interfaceName) throws Exception{

        if(interfaceName!=null){

            System.out.println("Creating interface: "+interfaceName+"...");

            String newClassName = interfaceName.replace(".","/").replace("/java",".java");

            newClassName = "src\\"+newClassName;

            Files.createFile(Path.of(newClassName));


            String[] splitPath = interfaceName.split("\\.");



            String classOnlyName = splitPath[splitPath.length-2];




            try(BufferedWriter writer = Files.newBufferedWriter(Path.of(newClassName))){

                writer.write("package "+interfaceName.replace("."+classOnlyName+".java","")+";");
                writer.write("\n");

                writer.write("public interface "+classOnlyName+" {");
                writer.write("\n");
                writer.write("}");

            }


            System.out.println("Interface created...");


        }

    }



}

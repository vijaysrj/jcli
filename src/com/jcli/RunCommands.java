package com.jcli;

import java.nio.file.Path;

public class RunCommands {


    public static void run(boolean run, String className) throws Exception{


        if(run) {

            if(className==null){

                throw new Exception("Please specify the main class using -mc or --main-class flag");
            }

            System.out.println("Executing application..");
            String path = Path.of(".").toAbsolutePath().toString();

            path = path.replace("\\.", "");



            path = path + "\\"+"out";



            RuntimeCommandsExecutor.execute("java -cp " +path+" "+ className);
        }
    }




}

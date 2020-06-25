package com.jcli;

import java.io.IOException;

public class FileCommands {



    public static void editFile(String fileName) throws IOException {

    if(fileName!=null){

        String newFileName = fileName.replace(".","\\").replace("\\java",".java");

        newFileName = "src\\"+newFileName;


        RuntimeCommandsExecutor.execute("notepad.exe "+newFileName);


    }

    }
}

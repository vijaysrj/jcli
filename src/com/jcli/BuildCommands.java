package com.jcli;

import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;

public class BuildCommands {


    public static void buildProject(boolean build)throws Exception{


        if(build) {
            System.out.println("Compiling project...");

            Files.walkFileTree(Path.of("src"),new CompilerVisitor());

            RuntimeCommandsExecutor.execute("javac.exe "+ CompilerVisitor.allFiles +" -d out");

            System.out.println("Compilation completed...");

        }
    }
}

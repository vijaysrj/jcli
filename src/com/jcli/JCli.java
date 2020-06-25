package com.jcli;



import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


@Command(name="jcli",description = "A command line tool for Java",mixinStandardHelpOptions=true,version="jcli 1.0")
public class JCli implements Callable<String> {




    @Option(names={"--create-project","-new"},description = "Creates a new Java Project")
    private  String projectName;


    @Option(names = {"--create-class","-cc"},description = "Creates a new Java Class")
    private String className;


    @Option(names = {"--create-interface","-ci"},description = "Creates a new Java Interface")
    private String interfaceName;

    @Option(names={"--create-package","-cp"},description = "Creates a new Java Package")
    private String packageName;

    @Option(names={"--compile","-c"},description = "Compiles Project")
    private boolean build;

    @Option(names={"--run","-r"},description = "Executes Project")
    private boolean run;

    @Option(names={"--main-class","-mc"},description = "Denotes the main class(fully qualified name) which needs to be run")
    private String mainClass;

    @Option(names={"--edit","-e"},description = "Opens given file for editing")
    private String editFile;

    @Override
    public String call() throws Exception {



            ProjectCommands.createProject(projectName);

            PackageCommands.createPackage(packageName);

            ClassCommands.createClass(className);

            InterfaceCommands.createInterface(interfaceName);

            FileCommands.editFile(editFile);

            BuildCommands.buildProject(build);

            RunCommands.run(run,mainClass);

            //add commands for deleting files and folders
            //return proper error message when user fails to type properly


        return "success";
    }

    public static void main(String[] args) {

        int exitCode = new CommandLine(new JCli()).execute(args);

        System.exit(exitCode);
    }


}

package com.jcli;



import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


@Command(name="jcli",description = "A command line tool for Java",mixinStandardHelpOptions=true,version="jcli 1.0")
public class JCli implements Callable<String> {




    @Option(names={"--create-project","-new"},description = "Creates a new Java Project")
    private  String projectName;


    @Option(names = {"--create-class","-cc"},description = "Creates a new Java Class in the package under src folder")
    private String className;


    @Option(names = {"--create-interface","-ci"},description = "Creates a new Java Interface in the package under src folder")
    private String interfaceName;

    @Option(names={"--create-package","-cp"},description = "Creates a new Java Package under src folder")
    private String packageName;

    @Option(names={"--compile","-c"},description = "Compiles Project")
    private boolean build;

    @Option(names={"--run","-r"},description = "Executes Project")
    private boolean run;

    @Option(names={"--main-class","-mc"},description = "Denotes the main class(fully qualified name) which needs to be run")
    private String mainClass;

    @Option(names={"--create-file","-cf"},description ="Creates a new file in the same directory where the command is executed")
    private  String createFile;

    @Option(names={"--edit","-e"},description = "Opens given file for editing (searches in src folder under the package given in the file name)")
    private String editFile;


    @Option(names={"--delete","-d"},description = "Deletes given file (searches in src folder under the package given in the file name)")
    private String deleteFile;

    @Override
    public String call() throws Exception {



            ProjectCommands.createProject(projectName);

            PackageCommands.createPackage(packageName);

            ClassCommands.createClass(className);

            InterfaceCommands.createInterface(interfaceName);

            FileCommands.createFile(createFile);

            FileCommands.editFile(editFile);

            FileCommands.deleteFile(deleteFile);


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

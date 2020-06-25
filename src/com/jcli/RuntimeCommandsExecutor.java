package com.jcli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeCommandsExecutor {



    public static void execute(String command) throws IOException {



        Runtime rt = Runtime.getRuntime();

        Process proc = rt.exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));


        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }



        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }
}

package com.jcli;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CompilerVisitor extends SimpleFileVisitor<Path> {

    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{java}");

    static String allFiles = "";

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {


        System.out.println("Visiting file "+file.getFileName());
        if (matcher.matches(file.getFileName())) {

            System.out.println("Compiling code");
            allFiles = allFiles+file.toAbsolutePath()+" ";



        }
        return FileVisitResult.CONTINUE;
    }


}

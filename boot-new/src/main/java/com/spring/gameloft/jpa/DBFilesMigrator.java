package com.spring.gameloft.jpa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DBFilesMigrator {

    public static void main(String[] args) throws IOException {
        File file = new File("../../../spring-training/spring-boot/src/main/resources/sql/orm_schema.sql");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        Files.walk(Paths.get("../../../sql_files"), 20, FileVisitOption.FOLLOW_LINKS)
             .peek(System.out::println)
             .filter(path -> path.endsWith("db.sql"))
             .flatMap(path -> {
                 try {
                     return Files.lines(path, StandardCharsets.UTF_8);

                 } catch (IOException e) {
                     e.printStackTrace();
                     return null;
                 }
             })
             .filter(line -> !line.contains("DROP"))
             .forEach(line -> {
                 try {
                     bw.write(line + "\n");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });
        bw.flush();
        bw.close();
    }
}

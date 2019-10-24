package com.spring.gameloft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class FileUploadController {
    String path = "/home/gabi/Projects/mvc/play/";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        Files.write(Paths.get(path + "uploaded_file.txt"), file.getBytes());
        return "file uploaded!";
    }
}

package com.robosh.ejournal.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
public class SubmitHomeworkService {

    public String createFile() {
        String path = "\\";
        path = path + "orestorest";
        //Creating a File object
        File file = new File(path);
        //Creating the directory
        boolean bool = file.mkdir();
        if (bool) {
            return "Directory created successfully";
        } else {
            return "Sorry couldn’t create specified directory";
        }
    }
}

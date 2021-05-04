package com.robosh.ejournal.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SubmitHomeworkService {

    public String createFile() {
        String path = "";
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

    public String showDirectory() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        return "success";
    }

    public String startShellScript() {
        try {
            File file = new File("script/");
            File[] files = file.listFiles();
            System.out.println(files[0].getName());
            Process process = Runtime.getRuntime().exec("sh script/repositoryTest.sh");
            process.getInputStream();
//            System.out.println(process.exitValue());
//            while (exec.isAlive()); {
//
            System.out.println("AAAAAAAAAAAA");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        File[] xmlFiles = getXMLFiles(new File("/home/orest/OrestData/diploma/e-learning-portal-back-end/build/test-results/test"));
//        for (File xmlFile : xmlFiles) {
//            System.out.println(xmlFile.getName());
//        }
        //        try {
//            //constructor of file class having file as argument
//            File file = new File("/home/orest/OrestData/diploma/e-learning-portal-back-end/build/test-results/test/");
//            FileInputStream fis = new FileInputStream(file);     //opens a connection to an actual file
//            System.out.println("file content: ");
//            int r = 0;x
//            while ((r = fis.read()) != -1) {
//                System.out.print((char) r);      //prints the content of the file
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "success1";
    }

    public static File[] getXMLFiles(File folder) {
        List<File> aList = new ArrayList<File>();

        System.out.println("TAGGERR " + folder.getName());
        File[] files = folder.listFiles();
        for (File pf : files) {

            if (pf.isFile() && getFileExtensionName(pf).indexOf("xml") != -1) {
                aList.add(pf);
            }
        }
        return aList.toArray(new File[aList.size()]);
    }

    public static String getFileExtensionName(File f) {
        if (f.getName().indexOf(".") == -1) {
            return "";
        } else {
            return f.getName().substring(f.getName().length() - 3, f.getName().length());
        }
    }
}

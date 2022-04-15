package Stage2.io.MainTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Methods {

    public void TreeView(String path) {
        File dir = new File(path);
        ArrayList<String> treeOfFiles = new ArrayList<>();
        if (dir.isDirectory()) {
            for (int i = 0; i < dir.listFiles().length; i++) {
                if (dir.listFiles()[i].isDirectory()) {
                    treeOfFiles.add("|-----" + dir.listFiles()[i].getName());
                    for (File file : dir.listFiles()[i].listFiles()) {
                        if (i == dir.listFiles().length - 1) {
                            treeOfFiles.add("\t" + file.getName());
                        } else {
                            treeOfFiles.add("|\t" + file.getName());
                        }
                    }
                }
            }
        }
        try {
            try (PrintWriter inputFileMainTask = new PrintWriter(new FileOutputStream
                    ("E:/Test_Automation/src/main/java/Stage2/I_O/MainTask/MainTask.txt"))) {
                for (String string : treeOfFiles) {
                    inputFileMainTask.println(string);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getNumberOfDirectories(String path) {
        int numberOfDirectories = 0;
        int numberOfFiles = 0;
        int allFilesNameLength = 0;
        int averageAmountOfFiles;
        int averageFileNameLength;
        try {
            ArrayList <String> treeFromFile = new ArrayList<>(Files.readAllLines(Path.of(path)));
            for (String strings : treeFromFile){
                if (strings.contains("|-----")){
                    numberOfDirectories++;
                }
                if (strings.contains("\t")){
                    numberOfFiles++;
                    allFilesNameLength += strings.length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        averageAmountOfFiles = numberOfFiles / numberOfDirectories;
        averageFileNameLength = allFilesNameLength / numberOfFiles;
        System.out.println("Number of directories : "+numberOfDirectories);
        System.out.println("Number of files in directory : "+numberOfFiles);
        System.out.println("Average amount of files in directory : "+averageAmountOfFiles);
        System.out.println("Average file name length : "+averageFileNameLength);
    }
}

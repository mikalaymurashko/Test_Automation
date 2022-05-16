package Stage2.io.MainTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Methods {

    public static void openFile(File file, ArrayList arrayList) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                arrayList.add("|-----" + f.getName());
                openFile(f, arrayList);
            } else {
                arrayList.add("|\t" + f.getName());
            }
        }
        arrayList.add("|");
    }

    public void treeView(String path) {
        File dir = new File(path);
        ArrayList<String> treeOfFiles = new ArrayList<>();
        treeOfFiles.add(dir.getName());
        treeOfFiles.add("|");
        openFile(dir, treeOfFiles);
        try {
            try (PrintWriter inputFileMainTask = new PrintWriter(new FileOutputStream
                    ("E:/Test_Automation/src/main/java/Stage2/io/MainTask/MainTask.txt"))) {
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
            ArrayList<String> treeFromFile = new ArrayList<>(Files.readAllLines(Path.of(path)));
            for (String strings : treeFromFile) {
                if (strings.contains("|-----")) {
                    numberOfDirectories++;
                }
                if (strings.contains("\t")) {
                    numberOfFiles++;
                    allFilesNameLength += strings.length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        averageAmountOfFiles = numberOfFiles / numberOfDirectories;
        averageFileNameLength = allFilesNameLength / numberOfFiles;
        System.out.println("Number of directories : " + numberOfDirectories);
        System.out.println("Number of files in directory : " + numberOfFiles);
        System.out.println("Average amount of files in directory : " + averageAmountOfFiles);
        System.out.println("Average file name length : " + averageFileNameLength);
    }
}

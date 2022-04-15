package Stage2.io.OptionalTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OptionalTask3 {
    public static void reverseLettersOrderInStrings() {
//        3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
        File optional3 = new File("E:/Test_Automation/src/main/java/Stage2/I_O/optionalTask/FilesForTask/task3.txt");
        File fileJava = new File("E:/Test_Automation/src/main/java/Stage2/I_O/optionalTask/ClassForOptionalTask2.java");
        ArrayList<String> listJava = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileJava)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                listJava.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(optional3)){
                for (String s : listJava){
                StringBuilder sb = new StringBuilder(s);
                fileWriter.write(sb.reverse().toString());
                fileWriter.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package Stage2.io.OptionalTask;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionalTask2 {
    //    2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
    public static void swapPublicToPrivate() {
        File fileJava = new File("E:/Test_Automation/src/main/java/Stage2/I_O/optionalTask", "ClassForOptionalTask2.java");
        ArrayList<String> listJava = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileJava)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                listJava.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileJava))) {
            for (String s : listJava) {
                if (s.contains("class")) {
                    bufferedWriter.write(s);
                } else {
                    bufferedWriter.write(s.replace("public", "private"));
                }
                bufferedWriter.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Stage2.io.OptionalTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class OptionalTask1 {
    //    1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
    private final static String PATH = "E:/Test_Automation/src/main/java/Stage2/io/optionalTask/FilesForTask";
    public static void generateRandomNumbers() {
        int[] randomNumbersArray = new int[10];
        for (int i = 0; i < randomNumbersArray.length; i++) {
            randomNumbersArray[i] = (int) (Math.random() * 50);
        }
        File optional1dir = new File(PATH);
        optional1dir.mkdir();
        File optional1 = new File(PATH + "/task1.txt");

        try (PrintWriter pw = new PrintWriter(optional1)) {
            pw.println(Arrays.toString(randomNumbersArray));
            pw.println("\n");
            Arrays.sort(randomNumbersArray);
            pw.println(Arrays.toString(randomNumbersArray));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

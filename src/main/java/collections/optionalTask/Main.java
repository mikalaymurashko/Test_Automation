package collections.optionalTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

//  Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        Stack<Object> stack = new Stack<>();
        String userDir = System.getProperty("user.dir");
        Files.readAllLines(Path.of(String.join(File.separator, userDir, "src", "main", "java", "collections",
                "optionalTask", "textFiles", "song.txt"))).forEach(stack::push);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

//  Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
        String number;
        Stack<Character> integerStack = new Stack<Character>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = br.readLine();
        for (int i = 0; i < number.length(); i++) {
            integerStack.push(number.charAt(i));
        }
        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }
        System.out.println();

//  Создать список из элементов каталога и его подкаталогов.
        File dir = new File("e:" + File.separator + "LearnEpam6");
        List<File> fileList = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                fileList.add(file);
            }
        }
        System.out.println(fileList);

//  Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
        List<String> poem = new ArrayList<>();
        poem.add("Spring is green");
        poem.add("Summer is bright");
        poem.add("Autumn is yellow");
        poem.add("Winter is white");
        poem.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(poem);
    }
}

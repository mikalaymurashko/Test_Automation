package fundamentals.MethodsMainTask;

import java.util.Scanner;

public class RandomNumbers {
    public static void randomNumbers(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}

package Stage1.fundamentals.MethodsMainTask;

import java.util.Scanner;

public class ArgsInReversedOrder {
    public static void argsInReversedOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input amount of numbers");
        int amount = scanner.nextInt();
        for (int i = 0; i < amount; i++) {
            int randomNumber = (int) (Math.random() * 100);
            System.out.println(randomNumber);
            System.out.print(randomNumber);

        }
    }
}

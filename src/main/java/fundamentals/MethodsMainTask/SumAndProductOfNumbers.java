package fundamentals.MethodsMainTask;

import java.util.Scanner;

public class SumAndProductOfNumbers {
    public static void sumAndProductOfNumbers() {
        System.out.println();
        System.out.println("Input the first number");
        Scanner sc1 = new Scanner(System.in);
        int num1 = sc1.nextInt();
        System.out.println("Input the second number");
        Scanner sc2 = new Scanner(System.in);
        int num2 = sc2.nextInt();
        System.out.println("Sum = " + (num1 + num2));
        System.out.println("Product of numbers = " + num1 * num2);
    }
}

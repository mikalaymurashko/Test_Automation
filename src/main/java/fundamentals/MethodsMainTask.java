package fundamentals;

import java.util.Scanner;

public class MethodsMainTask {

    public static void task1() {
        System.out.println("Input username:");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        System.out.println("Hello, " + sc);
    }

    public static void task2(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input amount of numbers");
        int amount = scanner.nextInt();
        for (int i = 0; i < amount; i++) {
            int randomNumber = (int) (Math.random() * 100);
            System.out.println(randomNumber);
            System.out.print(randomNumber);

        }
    }

    public static void task4() {
        System.out.println();
        System.out.println("Imput the first number");
        Scanner sc1 = new Scanner(System.in);
        int num1 = sc1.nextInt();
        System.out.println("Imput the second number");
        Scanner sc2 = new Scanner(System.in);
        int num2 = sc2.nextInt();
        System.out.println("Sum = " + (num1 + num2));
        System.out.println("Product of numbers = " + num1 * num2);
    }

    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of month");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
                System.out.println("january");
                break;
            case 2:
                System.out.println("february");
                break;
            case 3:
                System.out.println("march");
                break;
            case 4:
                System.out.println("april");
                break;
            case 5:
                System.out.println("may");
                break;
            case 6:
                System.out.println("june");
                break;
            case 7:
                System.out.println("july");
                break;
            case 8:
                System.out.println("august");
                break;
            case 9:
                System.out.println("september");
            case 10:
                System.out.println("october");
                break;
            case 11:
                System.out.println("november");
                break;
            case 12:
                System.out.println("december");
                break;
            default:
                System.out.println("You input the wrong number");
        }
    }
}

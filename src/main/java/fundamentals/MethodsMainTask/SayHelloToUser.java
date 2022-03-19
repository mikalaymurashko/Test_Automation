package fundamentals.MethodsMainTask;

import java.util.Scanner;

public class SayHelloToUser {
    public static void sayHelloToUser() {
        System.out.println("Input username:");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        System.out.println("Hello, " + sc);
    }
}

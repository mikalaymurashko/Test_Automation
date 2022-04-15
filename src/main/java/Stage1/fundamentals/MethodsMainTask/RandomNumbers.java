package Stage1.fundamentals.MethodsMainTask;

public class RandomNumbers {
    public static void randomNumbers(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}

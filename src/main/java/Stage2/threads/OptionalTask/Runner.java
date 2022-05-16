package Stage2.threads.OptionalTask;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5,true);
        for (int i = 1; i < 11; i++) {
            new Airport(i,semaphore).start();
        }
    }
}

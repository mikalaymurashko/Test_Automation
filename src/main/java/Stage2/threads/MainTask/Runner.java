package Stage2.threads.MainTask;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore parkingSpace = new Semaphore(2,true);
        new Car(1111,parkingSpace).start();
        new Car(2222,parkingSpace).start();
        new Car(3333,parkingSpace).start();
        new Car(4444,parkingSpace).start();
        new Car(5555,parkingSpace).start();
        new Car(6666,parkingSpace).start();
    }
}

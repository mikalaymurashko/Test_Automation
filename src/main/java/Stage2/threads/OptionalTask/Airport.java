package Stage2.threads.OptionalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Airport extends Thread {
    private int planeId;
    private Semaphore runway;

    public Airport(int planeId, Semaphore runway){
        this.planeId = planeId;
        this.runway = runway;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            System.out.println("Plane № " + planeId + " entering the runway");
            System.out.println("One of runways is in use");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Plane № " + planeId + " was took off");
            runway.release();
            System.out.println("One of runways is free now");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

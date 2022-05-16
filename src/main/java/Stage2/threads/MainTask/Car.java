package Stage2.threads.MainTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private int carId;
    private Semaphore parkingSpace;
    private int timeToWait;

    public Car(int carId, Semaphore parkingSpace) {
        this.carId = carId;
        this.parkingSpace = parkingSpace;
        this.timeToWait = (int) (Math.random() * 30);
    }

    @Override
    public void run() {
        int timeOfParking = (int) (10 + Math.random() * 20);
        try {
            System.out.println("Car № " + carId + " arrived at the parking and will wait only " + timeToWait +
                    " seconds");
            if (parkingSpace.tryAcquire()) {
                System.out.println("Car № " + carId + " successfully parked for " + timeOfParking + " seconds");
                TimeUnit.SECONDS.sleep(timeOfParking);
                System.out.println("Car № " + carId + " is leaving parking");
                parkingSpace.release();
            } else if (parkingSpace.tryAcquire(timeToWait, TimeUnit.SECONDS)) {
                System.out.println("Car № " + carId + " found free parking place and parked successful for " +
                        timeOfParking + " seconds");
                TimeUnit.SECONDS.sleep(timeOfParking);
                System.out.println("Car № " + carId + " is leaving parking");
                parkingSpace.release();
            } else {
                System.out.println("Car № " + carId + " doesn't want to wait any longer and leaves");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


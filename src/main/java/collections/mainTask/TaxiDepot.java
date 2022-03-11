package collections.mainTask;

import collections.mainTask.car.Car;

import java.util.ArrayList;
import java.util.List;

public class TaxiDepot {

    public int autoparkCost(List<Car> cars) {
        int carsCost = 0;
        for (Car car : cars) {
            carsCost += car.getCost();
        }
        return carsCost;
    }

    public void sortByFuelConsumption(List<Car> cars) {
        cars.sort(new FuelConsumptionComparator());
    }

    public Car carInSpeedRange(List<Car> cars, int rangeMinSpeed, int rangeMaxSpeed) {
        for (Car car : cars) {
            if (car.getMaxSpeed() >= rangeMinSpeed && car.getMaxSpeed() <= rangeMaxSpeed) {
                return car;
            }
        }
        return null;
    }

    public List<Car> carsInSpeedRange(List<Car> cars, int rangeMinSpeed, int rangeMaxSpeed) {
        List<Car> carsInSpeedRange = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= rangeMinSpeed && car.getMaxSpeed() <= rangeMaxSpeed) {
                carsInSpeedRange.add(car);
            }

        }
        return carsInSpeedRange;
    }
}



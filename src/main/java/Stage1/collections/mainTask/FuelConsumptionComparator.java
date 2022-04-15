package Stage1.collections.mainTask;

import Stage1.collections.mainTask.car.Car;

import java.util.Comparator;

public class FuelConsumptionComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Double.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }
}

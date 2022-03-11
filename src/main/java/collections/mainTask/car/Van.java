package collections.mainTask.car;

import java.util.Objects;

public class Van extends Car {

    public Van(int id, String model, int cost, double fuelConsumption, int maxSpeed, int productionYear, int passengerSeats,TypeOfBody typeOfBody) {
        super(id, model, cost, fuelConsumption, maxSpeed, productionYear, passengerSeats, typeOfBody);
    }

int maxLoad;

    @Override
    public String toString() {
        return "Van{" +
                "maxLoad=" + maxLoad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Van van = (Van) o;
        return maxLoad == van.maxLoad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxLoad);
    }

    public Van(int id, String model, int cost, double fuelConsumption, int maxSpeed, int productionYear, int passengerSeats, TypeOfBody typeOfBody, int maxLoad) {
        super(id, model, cost, fuelConsumption, maxSpeed, productionYear, passengerSeats, typeOfBody);
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }
}

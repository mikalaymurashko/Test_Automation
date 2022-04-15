package Stage1.collections.mainTask.car;

import java.util.Objects;

public abstract class Car  {
    private int id;
    private String model;
    private int cost;
    private double fuelConsumption;
    private int maxSpeed;
    private int productionYear;
    private int passengerSeats;
    private TypeOfBody typeOfBody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public void setPassengerSeats(int passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public Car(int id, String model, int cost, double fuelConsumption, int maxSpeed, int productionYear, int passengerSeats, TypeOfBody typeOfBody) {
        this.id = id;
        this.model = model;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.productionYear = productionYear;
        this.passengerSeats = passengerSeats;
        this.typeOfBody = typeOfBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && cost == car.cost && Double.compare(car.fuelConsumption, fuelConsumption) == 0 && maxSpeed == car.maxSpeed && productionYear == car.productionYear && passengerSeats == car.passengerSeats && Objects.equals(model, car.model) && typeOfBody == car.typeOfBody;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, cost, fuelConsumption, maxSpeed, productionYear, passengerSeats, typeOfBody);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                ", productionYear=" + productionYear +
                ", passengerSeats=" + passengerSeats +
                ", typeOfBody=" + typeOfBody +
                '}';
    }
}
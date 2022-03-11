package collections.mainTask;

import collections.mainTask.car.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new PassengerCar(1, "VW polo", 13980, 6.1, 198, 2019,4, TypeOfBody.SEDAN));
        cars.add(new PassengerCar(2, "Skoda Rapid", 14600, 6.0, 204, 2018,4, TypeOfBody.SEDAN));
        cars.add(new PassengerCar(3, "Kia Rio", 16250, 6.3, 183, 2020,4,TypeOfBody.SEDAN));
        cars.add(new PassengerCar(4, "Kia Ceed", 12950, 7.3, 195, 2016,4,TypeOfBody.HATCHBACK));
        cars.add(new PassengerCar(5, "Daewoo Nexia", 3200, 8.1, 175, 2009,4,TypeOfBody.SEDAN));
        cars.add(new PassengerCar(6, "Ford Focus", 13550, 5.9, 203, 2013,4,TypeOfBody.HATCHBACK));
        cars.add(new PassengerCar(7, "Skoda Octavia", 22980, 7.7, 240, 2017,4,TypeOfBody.SEDAN));
        cars.add(new Van(8, "Mazda MPV", 6700,15.4,180,2014,6,TypeOfBody.MINIVAN));
        cars.add(new Van(9,"Opel Zafira", 4000, 13.3,192,1999,6,TypeOfBody.MINIVAN));
        cars.add(new Van(10,"VW Caddy", 25100,11.9,179,2014,6,TypeOfBody.MINIVAN));
        cars.add(new Van(11,"Citroen C8",9200,13.8,170,2003,6,TypeOfBody.MINIVAN));
        cars.add(new Minibus(12,"Mercedes Sprinter",10000,19.0,180,2004,8,TypeOfBody.VAN));
        cars.add(new Minibus(13,"VW Crafter",16500,17.2,190,2007,8,TypeOfBody.VAN));
        cars.add(new Minibus(14,"Fiat Ducato", 11900, 14.6,175,2007,8,TypeOfBody.VAN));


        TaxiDepot taxiDepot = new TaxiDepot();
        System.out.println(taxiDepot.autoparkCost(cars));
        taxiDepot.sortByFuelConsumption(cars);
        System.out.println(cars);
        System.out.println(taxiDepot.carsInSpeedRange(cars,170,180));

        }

}

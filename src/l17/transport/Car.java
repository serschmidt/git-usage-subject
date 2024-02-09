package l17.transport;

public class Car {
    String name;
    int age;

    public Car(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Auto, " + this.name + ", " + age);
    }


    public static double totalDistanceOfAllClass = 0;

    private double fuelVolume = 14;

    public double getFuelVolume() {
        return this.fuelVolume;
    }

    public void refuel (double l) {
        this.fuelVolume += l;
    }
    public void go (int distance){
        this.fuelVolume -= distance * 5.5 / 100;
        Car.totalDistanceOfAllClass += distance;
    }

}
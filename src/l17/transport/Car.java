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
}
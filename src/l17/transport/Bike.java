package l17.transport;

public class Bike {
    String name;
    int age;

    public Bike(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Bike, " + this.name + ", " + age);
    }
}
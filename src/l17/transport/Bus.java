package l17.transport;

public class Bus {
    String name;
    int age;

    public Bus(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Bus, " + this.name + ", " + age);
    }
}
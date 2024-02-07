package l17.animal;

public class Cow {
    String name;
    int age;

    public Cow(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Kuh, " + this.name + ", " + age);
    }
}
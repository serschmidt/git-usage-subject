package l17.people;

public class Man {
    String name;
    int age;

    public Man(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Man, " + this.name + ", " + age);
    }
}
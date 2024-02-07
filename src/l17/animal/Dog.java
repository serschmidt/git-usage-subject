package l17.animal;

public class Dog {
    String name;
    int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Hund, " + this.name + ", " + age);
    }
}
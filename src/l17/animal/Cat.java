package l17.animal;
import l17.people.*;

import java.util.Scanner;

public class Cat {
    String name;
    int age;
//    private final static int chromosomNumber;


//    static {
//        System.out.println("Задайте количество Хромозон у кошки: ");
//        Scanner scanner = new Scanner(System.in);
//        chromosomNumber =  Integer.parseInt(scanner.nextLine());
//        scanner.close();
//    }
//    public static int getChromosomNumber()
//    {
//        return chromosomNumber;
//    }
//
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return ("Katze, " + this.name + ", " + age + " и имеет: "+ Man.getChromosomNumber() + " хромозонов");
    }
}

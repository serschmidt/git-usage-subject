import l17.people.*;
import l17.animal.*;
import l17.transport.*;

public class L17Main {
    public static void main(String[] args) {
        Man karl = new Man("Sergej", 42);
        System.out.println(karl);

        String s = karl.toString();         // оказывается тоже самое
        System.out.println(s);


        Woman anna = new Woman("Anna", 33);
        System.out.println(anna);

        Man fritzi = new Man("Fritz", 9);
        System.out.println(fritzi);

        Cat mietze = new Cat("Mietze", 3);
        System.out.println(mietze);

        Dog sharik = new Dog("Шарик", 5);
        System.out.println(sharik);

        Cow marta = new Cow("Марта", 10);
        System.out.println(marta);

        Car passat = new Car("Passat", 4);
        System.out.println(passat);

        Bike welo = new Bike("Велик", 7);
        System.out.println(welo);

        Bus s55 = new Bus("Линия S55", 2);
        System.out.println(s55);


    }
}

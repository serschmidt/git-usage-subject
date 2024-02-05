package wk6;

class Pokemon {
    String name;
    int currentHp;
    int maxHp;
    int attack;
    int defense;
    int specialAttack;
    double speed;

    // Конструктор покемона
    Pokemon() {
        name = "pokemon";
        maxHp = 100;
        attack = 10;
        defense = 5;
        specialAttack = 30;
        speed = 5.5;
        currentHp = maxHp;
    }

    Pokemon(String name, int maxHp, int attack, int defense, int specialAttack, double speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.speed = speed;
        this.currentHp = this.maxHp;
    }

    public void fight() {
        System.out.println(this.name + " атакует сильно сильно:");
    }

    public void sleep() {
        if (currentHp < maxHp / 10) {
            System.out.println(name + " хочет спать: ");
            currentHp += maxHp / 2;
        } else {
            System.out.println(name + " полный интузиазма. ");
        }

    }
}

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon Dedenne = new Pokemon("Dedenne", 100, 9, 15,20, 8);

        Dedenne.sleep();
    }
}
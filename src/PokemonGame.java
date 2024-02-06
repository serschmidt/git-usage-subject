package wk6;

import java.util.Random;
import java.util.Scanner;

class Pokemon {
    String name;
    int currentHp;
    int maxHp;
    int attack;
    int defense;
    int specialAttack;
    int speed;

    // Конструктор покемона
    Pokemon() {
        name = "pokemon";
        maxHp = 100;
        attack = 10;
        defense = 5;
        specialAttack = 30;
        speed = 5;
        currentHp = maxHp;
    }

    Pokemon(String name, int maxHp, int attack, int defense, int specialAttack, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.speed = speed;
        this.currentHp = this.maxHp;
    }

    public void fight() {
        System.out.println(this.name + " атакует сильно силой: " + attack);
    }

    public void fight(Pokemon enemy) {
        double r = Math.random();
        System.out.println(this.name + " атакует " + enemy.name + " сильно c силой: " + this.attack);
        enemy.currentHp = enemy.currentHp - (r > .75 ? (int) (r * this.specialAttack) : this.attack) + (int) (r * enemy.defense);
        if (enemy.currentHp < 0) {
            enemy.currentHp = 0;
        }
        System.out.println(enemy.name + " получил удар с силой: " + this.attack + " и имеет теперь " + enemy.currentHp + " очков");
        System.out.println(enemy.name + " атакует " + this.name + " сильно c силой: " + enemy.attack);
        r = Math.random();
        this.currentHp = this.currentHp - (r > .75 ? (int) (r * enemy.specialAttack) : enemy.attack) + (int) (r * enemy.defense);
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
        System.out.println(this.name + " получил удар с силой: " + enemy.attack + " и имеет теперь " + this.currentHp + " очков");
    }

    public void sleep() {
        if (currentHp < maxHp / 10) {
            System.out.println(name + " имеет " + currentHp + " очков здоровья и хочет спать: ");
            currentHp += (int) ((Math.random() + 1) * maxHp / 3);
            System.out.println(name + " выспался и унего стало " + currentHp + " очков здоровья. ");
        } else {
            System.out.println(name + " полный интузиазма. ");
        }

    }
}

public class PokemonGame {
    public static void main(String[] args) {
        Pokemon Absol = new Pokemon("Dedenne", 100, 9, 15, 20, 8);
        Pokemon Pancham = new Pokemon("Pancham", 90, 10, 13, 25, 7);
        Pokemon Pangoro = new Pokemon("Pangoro", 95, 8, 17, 23, 9);
        Pokemon Machop = new Pokemon("Machop", 101, 10, 10, 20, 8);
        Pokemon Machoke = new Pokemon("Machoke", 98, 11, 14, 28, 6);
        Pokemon Machamp = new Pokemon("Machamp", 91, 12, 16, 19, 7);

        Absol.sleep();

        Pangoro.fight();

        Pancham.fight(Machop);

        Machoke.fight(Machamp);

//-----------------------------------------------------------------------------------------
//Задание 2:

        Pokemon[] Team1 = new Pokemon[3];
        Pokemon[] Team2 = new Pokemon[3];

        Team1[0] = Absol;
        Team1[1] = Pancham;
        Team1[2] = Pangoro;

        Team2[0] = Machop;
        Team2[1] = Machoke;
        Team2[2] = Machamp;

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Сколько раз будут комманды покемонов сражаться: ");
        int s = Integer.parseInt((scanner.nextLine()));

        for (int k = 0; k < s; k++) {
            teamFight(Team1, Team2);


            teamRelax(Team1, Team2);
        }

    }

    public static void teamRelax(Pokemon[] team1, Pokemon[] team2) {
        for (int i = 0; i < team1.length; i++) {
            team1[i].sleep();
            team2[i].sleep();
        }
    }

    public static void teamFight(Pokemon[] team1, Pokemon[] team2) {

        for (int i = 0; i < team1.length; i++) { // каждый из Покемонов борется
            for (int j = 0; j < 3; j++) {
                if (team1[i].currentHp > 0 | team2[i].currentHp > 0) {
                    team1[i].fight(team2[i]);
                } else {
                    System.out.println(" Атака не состаялась ");
                }
            }


        }

    }

}
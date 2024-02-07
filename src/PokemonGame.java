package wk6;

import java.util.Random;
import java.util.Scanner;


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
package wk6;

public class Pokemon {
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
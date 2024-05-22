package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;
import java.text.MessageFormat;
import java.util.Random;

public class Pokemon {
    private final String name, type1, type2;
    private double hp;
    private final int id,attack,defence,spAttack,spDefence,speed,total;
    protected Attack[] attacks;

    public Pokemon(int id, String name, String type1, String type2, int total, double hp, int attack, int defence, int spAttack, int spDefence, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.spAttack = spAttack;
        this.spDefence = spDefence;
        this.speed = speed;
    }
    public Pokemon getClone() {
        return new Pokemon(id, name, type1, type2, total, hp, attack, defence, spAttack, spDefence, speed);
    }

    public void doAttack (Pokemon enemy, Attack attack) {  // doAttack with known attack
        double damage = attack.power() * ((double) enemy.getAttack() / enemy.getDefence()) * 0.04;
        //System.out.printf("      damage: %.1f = %d * (%d / %d) * 1/25 %n", damage, attack.getPower(), enemy.getAttack(), enemy.getDefence());
        //Schaden = (Atk_Pw) * (APk_A / DPk_D) * (1.0/25.0)
        enemy.setHp( enemy.getHp() - damage );
        System.out.printf("%s uses attack  %s (%s's new HP  = %.1f)%n%n", this.name, attack.name(), enemy.getName(), enemy.getHp());
    }

    public void doAttack (Pokemon enemy) {   // prepare for attack -> find out which attack will be executed
        int r = new Random().nextInt(attacks.length);
        if (this.hp > 0) {
            System.out.println("ENEMY ATTACK:");
            doAttack(enemy, attacks[r]);
        }
    }

    public void setHp (double hp) {
        this.hp = hp;
    }

    public void setAttacks(Attack attack1, Attack attack2) {
        attacks = new Attack[2];
        this.attacks[0] = attack1;
        this.attacks[1] = attack2;
    }

    //======================= GETTERS
    public String getName() {
        return name;
    }
    public double getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public int getSpAttack() {
        return spAttack;
    }
    public int getSpDefence() {
        return spDefence;
    }
    public int getSpeed() {
        return speed;
    }
    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        //return MessageFormat.format("POKEMON {0}, Attack {1}, Defence {2}, HP {3}, speed {4}, special Attack {5}, special Defence {6}",
        //        name, attack, defence, hp, speed, spAttack, spDefence);
        return MessageFormat.format("POKEMON {0} (Attack {1}, Defence {2}, HP {3}, speed {4})",
                name, attack, defence, hp, speed);
    }
}




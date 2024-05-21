package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;

import java.text.MessageFormat;

public class Pokemon {
    private final String name, type1, type2;
    private double hp;
    private final int id,attack,defence,spAttack,spDefence,speed,total;

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
        //System.out.println(this.name);  //to console
    }
    public Pokemon getClone() {
        return new Pokemon(id, name, type1, type2, total, hp, attack, defence, spAttack, spDefence, speed);
    }

    public void doAttack (Pokemon enemy) {
        if (this.hp > 0) {
            double damage = this.attack * (enemy.getAttack() / enemy.getDefence()) * 0.04;
            //Schaden = (Atk_Pw) * (APk_A / DPk_D) * (1.0/25.0)
            enemy.setHp( enemy.getHp() - damage );
            System.out.printf("%s attacked %s, hp = %f%n", name, enemy.getName(), enemy.getHp());
        }
    }

    public void chooseAttack () {

    }

    public void setHp (double hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
    public String getType1() {
        return type1;
    }
    public String getType2() {
        return type2;
    }
    public int getId() {
        return id;
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
        return MessageFormat.format("{0}, A {1}, D {2}, hp {3}, speed {4} sA {5}, sD {6}",
                name, attack, defence, hp, speed, spAttack,spDefence);
    }
}




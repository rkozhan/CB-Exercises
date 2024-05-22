package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Pokemon userPokemon, enemyPokemon;
    private final boolean isUserPokemonFaster;
    public Battle(Pokemon userPokemon, Pokemon enemyPokemon) {
        setUserPokemon(userPokemon);
        setEnemyPokemon(enemyPokemon);
        isUserPokemonFaster = checkIfUserPokemonIsFaster();

    }

    public void setUserPokemon(Pokemon userPokemon) {
        this.userPokemon = userPokemon.getClone();
        this.userPokemon.setAttacks(userPokemon.attacks[0], userPokemon.attacks[1]);
    }

    public void setEnemyPokemon(Pokemon enemyPokemon) {
        this.enemyPokemon = enemyPokemon.getClone();
        this.enemyPokemon.setAttacks(enemyPokemon.attacks[0], enemyPokemon.attacks[1]);
    }

    public boolean checkIfUserPokemonIsFaster() {
        return userPokemon.getSpeed() > enemyPokemon.getSpeed() ||
                userPokemon.getSpeed() == enemyPokemon.getSpeed() && new Random().nextBoolean();
    }

    protected void startBattle() {
        if (this.userPokemon.getHp() > 0 && this.enemyPokemon.getHp() > 0) {
            if (isUserPokemonFaster) {
                chooseAttack();
                this.enemyPokemon.doAttack(this.userPokemon);
            } else {
                this.enemyPokemon.doAttack(this.userPokemon);
                chooseAttack();
            }

            startBattle();
        } else {
            //done TODO: sout(... who wins ...)
            String winner = this.userPokemon.getHp() > 0
                    ? "VICTORY !!! Your Pokemon " + this.userPokemon.getName()
                    : "DEFEAT !!! Enemy Pokemon " + this.enemyPokemon.getName();
            System.out.println(winner + " is a winner!!!");
        }
    }

    private void chooseAttack () {
        if (this.userPokemon.getHp() > 0) {
            System.out.println("CHOOSE ATTACK:");
            for (int i = 0; i < this.userPokemon.attacks.length; i++) {
                System.out.println("-->  ENTER " + (i +1) + " to choose " + this.userPokemon.attacks[i]);
            }
        /*
        try {
            //done TODO Scanner Variable
            this.userPokemon.doAttack(
                    this.enemyPokemon,
                    this.userPokemon.attacks[new Scanner(System.in).nextInt() -1]
            );
        }
        catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
            chooseAttack();
        }
        */
            try {
                int choice = new Scanner(System.in).nextInt() - 1;
                if (choice < 0 || choice >= this.userPokemon.attacks.length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                this.userPokemon.doAttack(this.enemyPokemon, this.userPokemon.attacks[choice]);
            } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                chooseAttack();
            }
        }
    }
}

package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;

import java.util.Random;

public class Figthing {
    private final Pokemon userPokemon, enemyPokemon;
    private Pokemon attacker, attacked;
    public Figthing(Pokemon userPokemon, Pokemon enemyPokemon) {
        this.userPokemon = userPokemon.getClone();
        this.enemyPokemon = enemyPokemon.getClone();
        startFigthing();
    }
    private void startFigthing () {
        System.out.println(userPokemon + " VS " + enemyPokemon);
        if (userPokemon.getSpeed() > enemyPokemon.getSpeed() ||
                userPokemon.getSpeed() == enemyPokemon.getSpeed() && new Random().nextBoolean()) {

            //attacker = this.userPokemon;
            //attacked = this.enemyPokemon;
        } else {
            //attacker = this.enemyPokemon;
            //attacked = this.userPokemon;
        }

        //doRound();
    }

    private void doRound () {
        attacker.doAttack(attacked);
        attacked.doAttack(attacker);
        if ((attacker.getHp() > 0) && (attacked.getHp() > 0)) {
            doRound();
        }
    }
}

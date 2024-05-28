package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Game {
    //done TODO: final
    private int totalNum;
    private final List<Attack> attacks;
    private final List<Pokemon> pokemons;
    private Pokemon userPokemon;

    public Game () {
        this.attacks = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        setAttacksFromCSV();
        setPokemonsFromCSV();
        setRandomAttacksToPokemon();
    }

    public void startGame() {
        choosePokemon();
        Pokemon enemyPokemon = pokemons.get(new Random().nextInt(0, totalNum));

        System.out.printf("NEW BATTLE: your %s (speed %d) VS %s (speed %d)%n",
                userPokemon.getName(), userPokemon.getSpeed(), enemyPokemon.getName(), enemyPokemon.getSpeed());
        Battle battle = new Battle(userPokemon, enemyPokemon);
        battle.startBattle();
    }

    private void choosePokemon() {
        System.out.println("--> ENTER number from 1 to " + totalNum + " to choose your pokemon:");
        try {
            userPokemon = pokemons.get(new Scanner(System.in).nextInt() -1);
            System.out.println(userPokemon);
            confirmChoice();
        }
        catch (IndexOutOfBoundsException | InputMismatchException e) {
            choosePokemon();
        }
    }
    private void confirmChoice(){
        System.out.println("--> ENTER Y to confirm or N to choose other Pokemon");
        char userInput = new Scanner(System.in).nextLine().strip().toLowerCase().charAt(0);
        if (userInput == 'n') choosePokemon(); //choose other
        else if (userInput != 'y') confirmChoice();  //wrong input
    }


    private void setAttacksFromCSV () {
        try {
            readWithScanner("2023-04-03-Attacks.csv")  // List<String>
                    .stream()       //every string
                    .skip(1L)      //except first one
                    .forEach(arrayFromString -> {
                        attacks.add(
                                new Attack(
                                        Integer.parseInt(arrayFromString[0]),
                                        arrayFromString[1],
                                        arrayFromString[2],
                                        arrayFromString[3],
                                        arrayFromString[4],
                                        Integer.parseInt(arrayFromString[5]),
                                        arrayFromString[6],
                                        Integer.parseInt(arrayFromString[7])
                                )
                        );
                    });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPokemonsFromCSV() {
        try {
            readWithScanner("2023-03-13-Pokemon.csv")  // List<String>
                    .stream()       //every string
                    .skip(1L)      //except first one
                    .forEach(arrayFromString -> {
                        pokemons.add(
                                new Pokemon(
                                        Integer.parseInt(arrayFromString[0]),
                                        arrayFromString[1],
                                        arrayFromString[2],
                                        arrayFromString[3],
                                        Integer.parseInt(arrayFromString[4]),
                                        Double.parseDouble(arrayFromString[5]),
                                        Integer.parseInt(arrayFromString[6]),
                                        Integer.parseInt(arrayFromString[7]),
                                        Integer.parseInt(arrayFromString[8]),
                                        Integer.parseInt(arrayFromString[9]),
                                        Integer.parseInt(arrayFromString[10])
                                )
                        );
                    });
            totalNum = pokemons.size();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setRandomAttacksToPokemon() {
        pokemons.forEach(pokemon -> {
            int r1 = new Random().nextInt(attacks.size());
            int r2;
            do {
                r2 = new Random().nextInt(attacks.size());
            } while (r2 == r1);
            pokemon.setAttacks(attacks.get(r1), attacks.get(r2));
        });
    }


    // CSV to String[] LIST
    private List<String[]> readWithScanner(String url) throws FileNotFoundException {
        List<String[]> stringList = new ArrayList<>();

        File libraryFile = new File(url);

        // Using BufferedReader to handle BOM
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(libraryFile), StandardCharsets.UTF_8))) {
            // Skip BOM if present
            reader.mark(1);     // Mark the first character
            //done TODO: Kommentar, so dass du dich auch in 1 Jahr noch auskennst :)

            // Check the first character to see if it's a BOM
            if (reader.read() != 0xFEFF) {
                reader.reset();  // Reset to the start if it's not a BOM
            }

            // Using Scanner with BufferedReader to read each line
            Scanner fileScanner = new Scanner(reader);
            while (fileScanner.hasNextLine()) {
                stringList.add(fileScanner.nextLine().split(";"));
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}

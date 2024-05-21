package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Game {
    private int totalNum;
    private List<Pokemon> pokemons;
    private Pokemon userPokemon, enemyPokemon;
    public Game () {
        this.pokemons = new ArrayList<>();
        createPokemonsFromCSV();
        startGame();
    }

    private void startGame() {
        choosePokemon();
        //enemyPokemon = pokemons.get(new Random().nextInt(0, totalNum)).getClone();
        enemyPokemon = pokemons.get(0).getClone();
        Figthing figthing = new Figthing(userPokemon, enemyPokemon);
    }
    private void choosePokemon() {
        System.out.println("Enter number from 1 to " + totalNum + " to choose your pokemon:");
        try {
            userPokemon = pokemons.get(new Scanner(System.in).nextInt() -1);
            System.out.println(userPokemon);
            confirmChoise();
        }
        catch (IndexOutOfBoundsException | InputMismatchException e) {
            choosePokemon();
        }
    }
    private void confirmChoise (){
        System.out.println("Enter Y to confirm or N to choose other Pokemon");
        char userInput = new Scanner(System.in).nextLine().strip().toLowerCase().charAt(0);
        if (userInput == 'n') choosePokemon();
        else if (userInput != 'y') confirmChoise();
    }

    private void addPokemon (int id, String name, String type1, String type2, int total, double hp, int attack, int defence, int spAttack, int spDefence, int speed) {
        pokemons.add(new Pokemon(id, name, type1, type2, total, hp, attack, defence, spAttack, spDefence, speed));
    }
    private void createPokemonsFromCSV() {
        try {
            List<String> strings = readWithScanner("2023-03-13-Pokemon.csv");
            strings.stream().skip(1L).forEach(pokemon -> {
                    String[] newPokemon = pokemon.split(";");

                    addPokemon(
                            Integer.parseInt(newPokemon[0]),
                            newPokemon[1],
                            newPokemon[2],
                            newPokemon[3],
                            Integer.parseInt(newPokemon[4]),
                            Double.parseDouble(newPokemon[5]),
                            Integer.parseInt(newPokemon[6]),
                            Integer.parseInt(newPokemon[7]),
                            Integer.parseInt(newPokemon[8]),
                            Integer.parseInt(newPokemon[9]),
                            Integer.parseInt(newPokemon[10])
                    );
            });
            totalNum = pokemons.size();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private List<String> readWithScanner(String url) throws FileNotFoundException {
        List<String> stringList = new ArrayList<>();

        File libraryFile = new File(url);

        // Using BufferedReader to handle BOM
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(libraryFile), StandardCharsets.UTF_8))) {
            // Skip BOM if present
            reader.mark(1);
            if (reader.read() != 0xFEFF) {
                reader.reset();
            }

            // Using Scanner with BufferedReader
            Scanner fileScanner = new Scanner(reader);
            while (fileScanner.hasNextLine()) {
                stringList.add(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}

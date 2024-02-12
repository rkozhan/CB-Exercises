package a3_Methoden;

import java.util.Random;

public class A1_GameOfLife {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 10,
                generation = 0;
        boolean[][] field = new boolean[size][size];
        boolean anyChanges;

        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field.length; k++) {
                //field[k][i] = r.nextInt(5) == 0 ? true : false;   //density
            }
        }
        // ------------------------------------------map GLIDER
        boolean[][] glider = {
                {false,false,true},{true,false,true},{false,true,true}
        };
        for (int i = 0; i < glider.length; i++) {
            for (int j = 0; j < glider.length; j++) {
                field[j][i] = glider[j][i];
            }
        }

        do {
            anyChanges = false;
            System.out.println("generation: " + generation);

            boolean[][] previousState = field.clone();
            for (int i = 0; i < previousState.length; i++) {
                previousState[i] = field[i].clone();
            }

            for (int i = 0; i < size; i++) {
                String row = "";
                for (int k = 0; k < size; k++) {
                    int hoods = 0;                                          //neigborhoods
                    /*  // Begrenztes Feld
                    int minI = i == 0 ?  0 : i -1,
                        maxI = i == size-1 ? size -1 : i + 1,
                        minK = k == 0 ? 0 : k -1,
                        maxK = k == size-1 ? size -1 : k + 1;

                    for (int y = minI; y <= maxI ; y++) {
                        for (int x = minK; x <= maxK; x++) {
                            if (previousState[x][y] && !(y == i && x == k )) hoods++;
                        }
                    }
                    */ //Ende von Begrenztem Feld
                    // endloses Feld
                    int minI = i == 0 ?  size-1 : i -1,
                            maxI = i == size-1 ? 0 : i + 1,
                            minK = k == 0 ? size-1 : k -1,
                            maxK = k == size-1 ? 0 : k + 1;
                    if (previousState[minK][minI]) hoods++;
                    if (previousState[k][minI]) hoods++;
                    if (previousState[maxK][minI]) hoods++;
                    if (previousState[minK][i]) hoods++;
                    if (previousState[maxK][i]) hoods++;
                    if (previousState[minK][maxI]) hoods++;
                    if (previousState[k][maxI]) hoods++;
                    if (previousState[maxK][maxI]) hoods++;
                    //Ende von Endlosem Feld

                    if (generation == 0) {
                        anyChanges = true;
                    } else {
                        if (hoods == 3 || (hoods == 2 && field[k][i])) field[k][i] = true;
                        else field[k][i] = false;
                        if (previousState[k][i] != field[k][i]) anyChanges = true;
                    }

                    if (field[k][i]) {
                        row += " # ";
                    } else  row += " . ";
                }
                System.out.println(row);

            }
            generation++;

        } while (generation <= 1000 && anyChanges);
    }
}



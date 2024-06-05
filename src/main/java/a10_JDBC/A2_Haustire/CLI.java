package main.java.a10_JDBC.A2_Haustire;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface CLI { // command-line interface

    Scanner scanner = new Scanner(System.in);
    //final HouseHoldManager management = setManagement();
/*
    static HouseHoldManager setManagement() {
        try {
            return new HouseHoldManager();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

 */


    static void controlFor(List list) {
        if (!list.isEmpty()) {
            for (int i = 1; i <= list.size(); ) {
                //System.out.printf(">> Enter %d to select %s %s%n",  );
            }
        }


    }

}

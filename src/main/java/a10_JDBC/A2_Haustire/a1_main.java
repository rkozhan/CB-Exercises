package main.java.a10_JDBC.A2_Haustire;

import main.java.a10_JDBC.A2_Haustire.model.Household;
import main.java.a10_JDBC.A2_Haustire.model.Person;
import main.java.a10_JDBC.A2_Haustire.model.Pet;

import java.sql.SQLException;

public class a1_main {
    public static void main(String[] args) {

        //TODO: 1 MVC -> model view controller ... (view = UI .. main?, model package mit Household, Person, Pet; Controller -> Logik bzw. DAOImplementations)
        // https://www.digitalocean.com/community/tutorials/dao-design-pattern

        //TODO: 2 Singleton pattern -> eigene Klasse für Connection
        // https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples#4-thread-safe-singleton
        // https://www.geeksforgeeks.org/singleton-design-pattern/

        try {
            var hhManagement = new HouseHoldManager();

            //hhManagement.add(new Household("newwww1"));
            //hhManagement.delete(45);
            //hhManagement.update(new Household("updated1000", 54));

            var hh = hhManagement.get(54);
            System.out.println(hh);
            var result = hhManagement.getList();
            System.out.println(result);

            //hh.add(new Person("joe48"));
            //hh.delete(10);
            //hh.update(new Person(11, "newName"));
            System.out.println(hh.getList());
            Person person = hh.get(11);
            System.out.println(person);

            //person.add(new Pet("lucky"));
            //person.update(new Pet(5, "newLucky"));
            person.delete(4);
            System.out.println(person.get(5));
            System.out.println(person.getList());


            //Close the connection when done
            //DBConnector.closeConnection();
        } catch ( RuntimeException  e) {
            System.out.println(e.getMessage());
        }




    }
}

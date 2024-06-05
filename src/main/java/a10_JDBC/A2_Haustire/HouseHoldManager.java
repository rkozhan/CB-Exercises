package main.java.a10_JDBC.A2_Haustire;
import main.java.a10_JDBC.A2_Haustire.dao.HouseHoldDAOMySQL;
import main.java.a10_JDBC.A2_Haustire.model.Household;
import java.util.List;

public class HouseHoldManager {
    static HouseHoldDAOMySQL sql = new HouseHoldDAOMySQL();
    private List<Household> householdList = sql.getAllHouseHolds();

    public void add (Household household) {
        try {
            sql.create(household);
            householdList.add(household);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public Household get (int id) { // HouseHold By Id
        Household household = null;
        try {
        household = householdList.stream()
                .filter(h -> h.getId() == id)
                .findFirst()
                .orElse(null);
            //household = sql.read(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return household;
    }

    public void delete(int id) {  // HouseHold By Id
        try {
            sql.delete(id);
            householdList.removeIf( household -> household.getId() == id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public void update(Household household) {
        try {
            sql.update( household);
            int index = householdList.indexOf(
                    get(household.getId())
            );
            if (index >= 0) householdList.set( index, household);

        } catch (RuntimeException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public List<Household> getList () {
        return householdList;
    }
}


package main.java.a9_file_IO_and_Exceptions.A2_file_I_O;
import java.text.MessageFormat;

/**
 * @param id done TODO: final
 */
public record Attack(int id, String name, String effect, String type, String kind, int power, String accuracy, int pp) {
    //System.out.println(this.type + ", kind: " + this.kind + " , power: " + this.power + ", pp: " + this.pp);

    @Override
    public String toString() {
        return MessageFormat.format("Attack {0} (power {1}, accuracy {2})",
                name, power, accuracy);
    }
}

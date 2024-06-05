package main.java.a10_JDBC.A2_Haustire.dao;
import main.java.a10_JDBC.A2_Haustire.model.Household;

public interface HouseholdDAO {
    void create(Household household);
    Household read(int id);
    void delete(int id);
    void update(Household household);
}




/* INTERFACE METHODS
    //void someMethod(); // Method declaration without a body. Classes that implement these interfaces must provide the implementation for these methods.
    // Default method with a body
    default void someDefaultMethod() {
        System.out.println("Default implementation of someDefaultMethod");
    } //These methods can be overridden by classes that implement the interface, but they provide a default behavior that can be used if not overridden
    static void someStaticMethod() {
        System.out.println("Static method in Interface");
    } //Static methods in interfaces are similar to static methods in classes. They have a body and can be called directly on the interface without the need for an instance of a class that implements the interface.
*/


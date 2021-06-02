import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Cadet person = new Cadet("Andy Guo", "password", "WO2", "Flight commander");
        System.out.println(person);
        System.out.println(person.getEmail());
        System.out.println(person.getPassword());

        person.addSummerCourse("Survival instructor");
        System.out.println(Arrays.toString(person.getSummerTraining()));

        Officer officer = new Officer("Paul Yu", "password", "Maj", "CO", 50000);
        System.out.println(officer);
        System.out.println(officer.getSalary());

        Cadet person2 = new Cadet("Bob smith", "pw", "Cdt", "Cadet");
        Cadet person3 = new Cadet("Lucas Guo", "pw", "Sgt", "Cadet");
        Cadet person4 = new Cadet("Billy Bob", "pw", "Cpl", "Cadet");
        Cadet person5 = new Cadet("Vincent Guo", "pw", "LAC", "Cadet");

        Flight flight = new Flight("Falcon", new Cadet[]{person2, person3, person4}, person);
        flight.addCadet(person5);
        flight.removeCadet(2);
        System.out.println(flight);
    }
}
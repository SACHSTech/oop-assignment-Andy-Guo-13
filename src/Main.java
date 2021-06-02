import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Cadet person = new Cadet("Andy Guo", "password", "WO2");
        System.out.println(person);
        System.out.println(person.getEmail());
        System.out.println(person.getPassword());

        person.addSummerCourse("Survival instructor");
        System.out.println(Arrays.toString(person.getSummerTraining()));

        Officer officer = new Officer("Paul Yu", "password", "Maj", 50000);
        System.out.println(officer);
        System.out.println(officer.getSalary());

        Cadet person2 = new Cadet("Bob Smith", "pw", "Cdt");
        Cadet person3 = new Cadet("Lucas Guo", "pw", "Sgt");
        Cadet person4 = new Cadet("Billy Bob", "pw", "Cpl");
        Cadet person5 = new Cadet("Vincent Guo", "pw", "LAC");

        Flight flight = new Flight("Falcon", new Cadet[]{person2, person3, person4}, person);
        flight.addCadet(person5);
        flight.removeCadet(2);

        Cadet fcomm = new Cadet("Bobby Joe", "pw", "FSgt");
        Cadet cadet = new Cadet("Bill Smith", "pw", "Cdt");
        Flight flight2 = new Flight("Polaris", new Cadet[]{cadet}, fcomm);

        Cadet chief = new Cadet("Hanshu Pu", "pw", "WO1");
        Officer officer2 = new Officer("Gilda Kato", "pw", "CI", 25000);

        Squadron globemaster = new Squadron(8, "Globemaster", new Flight[]{flight}, chief, new Officer[]{officer2}, officer);
        flight2.addCadet(person4);
        globemaster.addOfficer(new Officer("Alexander Leung", "pw", "CI", 25000));
        globemaster.addFlight(flight2);
        System.out.println("\n \n" + globemaster);

        System.out.println(flight.findID(1000003));

        System.out.println(Arrays.toString(globemaster.findID(1000011)));

        System.out.println(globemaster.getCommandingOfficer().getEmail());
        System.out.println(globemaster.getCommandingOfficer().getRole());

        System.out.println(globemaster.getChief().getEmail());
        System.out.println(globemaster.getChief().getRole());

        System.out.println(globemaster.getFlights()[0].getFlightCommander().getRole());

        globemaster.moveCadet(1000002, 2);
    }
}
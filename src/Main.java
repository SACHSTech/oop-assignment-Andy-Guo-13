import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Cadet person = new Cadet("Andy Guo", "password", "WO2", "Level WO");
        System.out.println(person);
        System.out.println(person.getEmail());
        System.out.println(person.getPassword());

        person.addSummerCourse("Survival instructor");
        System.out.println(Arrays.toString(person.getSummerTraining()));

        Officer officer = new Officer("Paul Yu", "password", "Maj", "CO", 50000);
        System.out.println(officer);
        System.out.println(officer.getSalary());
    }
}
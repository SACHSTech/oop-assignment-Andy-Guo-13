import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Cadet person = new Cadet("Andy Guo", "password", "WO2", "Cadet");
        System.out.println(person);
        System.out.println(person.getEmail());
        System.out.println(person.getPassword());

        //person.addSummerCourse("Survival instructor");
        System.out.println(Arrays.toString(person.getSummerTraining()));
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Squadron ics4u = initialSquadron();
        
        System.out.println(ics4u.getChief().evaluationsToString());
    }

    /*
    * A method that creates a squadron in order to demonstrate the ability of the code
    * 
    * @return A squadron consisting of the students within the quadmester 4 ICS4U course
    */
    private static Squadron initialSquadron() {

        // If anyone is reading this, please note I'm not discriminating against any students by making them lower rank
        // I literally went through the class list, so if you weren't a flight commander, tough luck

        // Flight for last names from A to G
        Cadet amaan = new Cadet("Amaan Ali", "pw", "Fsgt");
        Cadet chloe = new Cadet("Chloe Cheung", "pw", "Cpl");
        Cadet jackson = new Cadet("Jackson Cheung", "pw", "Cpl");
        Cadet ashley = new Cadet("Ashley Fong", "pw", "Cdt");
        Cadet natalia = new Cadet("Natalia Garcia-Arias", "pw", "Cdt");
        Flight aToG = new Flight("A To G", new Cadet[]{chloe, jackson, ashley, natalia}, amaan);

        // Flight for last names from H to S
        Cadet justin = new Cadet("Justin Ho Shue", "pw", "Fsgt");
        Cadet douglas = new Cadet("Douglas Lau", "pw", "Cpl");
        Cadet tiffany = new Cadet("Tiffany Lee", "pw", "Cpl");
        Cadet lucy = new Cadet("Lucy Mao", "pw", "Cdt");
        Cadet ziming = new Cadet("Ziming Qu", "pw", "Cdt");
        Cadet alyanna = new Cadet("Alyanna Santos", "pw", "Cdt");
        Flight hToS = new Flight("H To S", new Cadet[]{douglas, tiffany, lucy, ziming, alyanna}, justin);

        // Flight for last names S to Y
        Cadet xinan = new Cadet("Xinan Shan", "pw", "Fsgt");
        Cadet joshua = new Cadet("Joshua Shuttleworth", "pw", "Cpl");
        Cadet benjamin = new Cadet("Benjamin Teh", "pw", "Cpl");
        Cadet paul = new Cadet("Paul Tran", "pw", "Cdt");
        Cadet adrian = new Cadet("Adrian Wong", "pw", "Cdt");
        Cadet anson = new Cadet("Anson Yang", "pw", "Cdt");
        Flight sToY = new Flight("S to Y", new Cadet[]{joshua, benjamin, paul, adrian, anson}, xinan);

        // Officers
        Officer fabroa = new Officer("Eric Fabroa", "pw", "LCol", 150000);
        Officer jeffrey = new Officer("Jeffrey Lin", "pw", "Capt", 75000);
        Officer sam = new Officer("Sam Liu", "pw", "Lt", 50000);

        // Chief
        Cadet andy = new Cadet("Andy Guo", "pw", "WO1");

        // Creating the squadron
        Squadron ics4u = new Squadron(21, "ICS4U", new Flight[]{aToG, hToS, sToY}, andy, new Officer[]{jeffrey, sam}, fabroa);
        return ics4u;
    }
}
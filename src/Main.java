import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Squadron ics4u = initialSquadron();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // char test = Character.toLowerCase(br.readLine().charAt(0)); // This will be useful later

        // Printing instructions
        System.out.println("Welcome Mr. Fabroa.");
        System.out.println("Here are the instructions to how this program works.");
        System.out.println("You have been made CO of " + Integer.toString(ics4u.getSqnNum()) + " " + ics4u.getSqnName() + " RCAC squadron.");
        System.out.println("This is a system that allows you to keep track of your cadets and their evaluations.");
        System.out.println("You can either login as yourself or as someone else, but keep in mind:");
        System.out.println("If you are logged in as a regular cadet, you do not have as many privileges as if you are logged in as the CO.");
        System.out.println("");
        System.out.println("Here is your login information:");
        System.out.println("ID number: " + ics4u.getCommandingOfficer().getIdNum());
        System.out.println("Password: " + ics4u.getCommandingOfficer().getPassword());
        System.out.println("You can change your password later, but not your ID number");
        System.out.println("Enter anything to continue:");
        br.readLine();
        
        // Username and password system

        int[] personIndex = new int[]{-1, -1};

        // Until a valid ID is entered, keep asking the user for an ID number
        while (personIndex[0] == -1) {
            System.out.print("Enter your ID number: ");
            int idInput = Integer.parseInt(br.readLine());

            // Figuring out who this ID belongs to
            personIndex = ics4u.findID(idInput);
            
            if (personIndex[0] == -1) {
                System.out.println("ID does not exist. Please try again.");
            }
        }

        // Given the ID, user object is loaded with the person with that ID
        Person user;
        if (personIndex[0] == -4) {
            user = ics4u.getCommandingOfficer();
        }

        else if (personIndex[0] == -3) {
            user = ics4u.getChief();
        }

        else if (personIndex[0] == -2) {
            user = ics4u.getOfficers()[personIndex[1]];
        }

        else if (personIndex[1] == -2) {
            user = ics4u.getFlights()[personIndex[0]].getFlightCommander();
        }

        else {
            user = ics4u.getFlights()[personIndex[0]].getCadets()[personIndex[1]];
        }

        // Greets the user with their rank and their name
        System.out.println("Welcome " + user.getRank() + " " + user.getName() + "!");

        // Asks the user for their password, and keeps looping until their password is correct
        boolean isPwCorrect = false;
        while (!isPwCorrect) {
            System.out.print("Enter your password: ");
            String pwInput = br.readLine();
            isPwCorrect = user.checkPassword(pwInput);
            if (!isPwCorrect) {
                System.out.println("Incorrect password. Try again.");
            }
        }

        boolean isLogin = true;
        int choice = 0;
        // While the user is logged in, keep looping
        while (isLogin) {
            // Stuff for officers to do:
            if (personIndex[0] < 0) {
                // Officer duties (temporary)
                isLogin = false;
            }

            // Stuff for flight commanders to do
            else if (personIndex[1] < 0) {
                // Fcomm duties
                isLogin = false;
            }

            // Stuff for cadets to do
            else {
                choice = cadetChoice(br);

                // If the cadet chooses to logout, it logs them out
                if (choice == -1) {
                    isLogin = false;
                }
            }


        }

        System.out.println("Goodbye " +  user.getRank() + " " + user.getName() + "!");
        /*
        *   Delete this later
        * 
        *   Cadet priviliges:
        *       Print the entire squadron
        *       See their own evaluation and summer training courses
        *       Reset password
        *       Logout
        *   Flight commander priviliges:
        *       Cadet priviliges plus:
        *       Adding and removing cadets from their flight
        *       Adding summer training courses to cadets in their flight
        *       Editing evaluations for cadets in their flight
        *       See evaluations and summer training for cadets within their flight
        *   Officer priviliges:
        *       Flight commander priviliges (but throughout the entire sqn) plus:
        *       Moving cadets between flights
        *       Adding and deleting flights
        */
    }

    /*
    * A function that asks cadets for their choice and returns a number based on what they choose
    * 
    * @param br  To use the same BufferedReader already declared in the main method
    * 
    * @return an integer based on the decision the cadet made
    */
    private static int cadetChoice(BufferedReader br) throws IOException{

        // Prints out options
        System.out.println("Please enter a number to pick what you want to do from the options below:");
        System.out.println("1. Print my squadron");
        System.out.println("2. See my summer training courses");
        System.out.println("3. Change password");
        System.out.println("4. Logout");

        // If they choose to change password, return -2
        int choice = Integer.parseInt(br.readLine());
        if (choice == 3) {
            return -2;
        }

        // If they choose to change
        else if (choice == 4) {
            return -1;
        }

        return choice;
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
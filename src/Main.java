/*
* Main class file, runs to showcase other classes
* 
* @author: Andy Guo
*/

import java.util.*;
import java.io.*;

public class Main {

    /*
    * Main method that runs when the program starts
    */
    public static void main(String[] args) throws IOException{
        Squadron ics4u = initialSquadron();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        // Keeps looping until the user stops the program
        boolean isProgramRunning = true;
        while (isProgramRunning) {
            
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
            String newPw;
            // While the user is logged in, keep looping
            while (isLogin) {
                // Stuff for officers to do:
                if (personIndex[0] < 0) {
                    choice = officerChoice(br);

                    // If the officer chooses to see their summer training, print summer training if that officer is actually the chief.
                    // If they are a comissioned officer, the program will tell them that this is not an action that can be performed
                    if (choice == 2) {
                        if (personIndex[0] == -3) {
                            System.out.println("\n" + Arrays.toString(ics4u.getChief().getSummerTraining()));
                        }
                        else {
                            System.out.println("Officers don't have summer training.");
                        }
                    }

                    // If the officer chooses to see their evaluations, print their evaluations if that officer is actually the chief.
                    // If they are a comissioned officer, the program will tell them that this is not an action that can be performed
                    if (choice == 3) {
                        if (personIndex[0] == -3) {
                            System.out.println("\n" + ics4u.getChief().evaluationsToString());
                        }
                        else {
                            System.out.println("Officers don't have summer training.");
                        }
                    }

                    // If the officer chooses to change their password, run the change pw method
                    if (choice == -2) {
                        newPw = newPassword(br);
                        if (personIndex[0] == -4) {
                            ics4u.getCommandingOfficer().setPassword(newPw);
                        }

                        else if (personIndex[0] == -3) {
                            ics4u.getChief().setPassword(newPw);
                        }

                        else {
                            ics4u.getOfficers()[personIndex[1]].setPassword(newPw);
                        }
                    }

                    // If the officer wishes to view their cadets' summer training, the program prints that information
                    if (choice == 4) {

                        // Iterate through every flight in the squadron
                        for (int j = 0; j < ics4u.getFlights().length; j++) {
                            System.out.println("");
                            System.out.println(ics4u.getFlights()[j].getName() + " flight cadets:");

                            // Iterate through every cadet in the flight
                            System.out.println(ics4u.getFlights()[j].getFlightCommander().getRank() + " " + ics4u.getFlights()[j].getFlightCommander().getName() + ": " + Arrays.toString(ics4u.getFlights()[j].getFlightCommander().getSummerTraining()));
                            for (Cadet i : ics4u.getFlights()[j].getCadets()) {
                                System.out.println(i.getRank() + " " + i.getName() + ": " + Arrays.toString(i.getSummerTraining()));
                            }
                        }
                    }

                    // If the officer wishes to view their cadets' evaluations, the program prints that information
                    if (choice == 5) {
                        
                        // Iterate through every flight in the squadron
                        for (int j = 0; j < ics4u.getFlights().length; j++) {
                            System.out.println("");
                            System.out.println(ics4u.getFlights()[j].getName() + " flight cadets:");
                            
                            // Iterate through every cadet in the flight
                            System.out.println(ics4u.getFlights()[j].getFlightCommander().evaluationsToString());
                            for (Cadet i : ics4u.getFlights()[j].getCadets()) {
                                System.out.println(i.evaluationsToString());
                            }
                        }
                    }

                    // If the officer wishes to add a summer training to a cadet, the programs does that
                    if (choice == 6) {

                        // Prints out a list of flights and asks which flight they wish to edit
                        System.out.println("");
                        for (int i = 0; i < ics4u.getFlights().length; i++) {
                            System.out.println("Flight #" + Integer.toString(i + 1) + ": " + ics4u.getFlights()[i].getName());
                        }
                        System.out.println("Which flight would you like to edit? Enter the flight number.");
                        int flightSummerTrainingIndex = Integer.parseInt(br.readLine()) - 1;

                        // Prints the list of cadets and asks which cadet they wish to add a summer training to
                        System.out.println(ics4u.getFlights()[flightSummerTrainingIndex]);
                        System.out.println("Which cadet would you like to add a summer training to?");
                        System.out.println("Enter the cadet number (Not their ID). Enter 0 to edit a flight commander. Enter -1 to edit the chief.");
                        
                        // Takes the index number of the cadet and the name of the course, and adds it to that cadet
                        int cadetSummerTrainingIndex = Integer.parseInt(br.readLine()) - 1;
                        System.out.println("What course would you like to add?");
                        String summerCourse = br.readLine();

                        // If 0 is entered, the officer is adding a course for the flight commander
                        if (cadetSummerTrainingIndex == -1) {
                            ics4u.getFlights()[flightSummerTrainingIndex].getFlightCommander().addSummerCourse(summerCourse);
                        }

                        // If -1 is entered, the officer is adding a course for the chief
                        else if (cadetSummerTrainingIndex < -1) {
                            ics4u.getChief().addSummerCourse(summerCourse);
                        }

                        // If the number entered is not 0, then a course is added for a cadet in the flight
                        else {
                            ics4u.getFlights()[flightSummerTrainingIndex].getCadets()[cadetSummerTrainingIndex].addSummerCourse(summerCourse);
                        }
                    }

                    // If the officer wishes to edit an evaluation for a cadet, the programs does that
                    if (choice == 7) {

                        // Prints out a list of flights and asks which flight they wish to edit
                        System.out.println("");
                        for (int i = 0; i < ics4u.getFlights().length; i++) {
                            System.out.println("Flight #" + Integer.toString(i + 1) + ": " + ics4u.getFlights()[i].getName());
                        }
                        System.out.println("Which flight would you like to edit? Enter the flight number.");
                        int flightEvaluationIndex = Integer.parseInt(br.readLine()) - 1;

                        // Prints the list of cadets and asks which cadet they wish to add a summer training to
                        System.out.println(ics4u.getFlights()[flightEvaluationIndex]);
                        System.out.println("Which cadet would you like to edit evaluations for?");
                        System.out.println("Enter the cadet number (Not their ID). Enter 0 to the flight commander. Enter 1 to edit the chief.");
                        
                        // Takes the index number of the cadet and the name of the course, and adds it to that cadet
                        int cadetEvaluationIndex = Integer.parseInt(br.readLine()) - 1;

                        // Takes the index number of the evaluation
                        System.out.println("Which evaluation would you like to edit?");
                        System.out.println("Enter 1 for leadership");
                        System.out.println("Enter 2 for drill");
                        System.out.println("Enter 3 for teaching");
                        System.out.println("Enter 4 for aviation");
                        int evalIndex = Integer.parseInt(br.readLine());

                        // Takes a char input for the mark the cadet is receiving
                        System.out.println("What mark is this cadet receiving?");
                        System.out.println("Enter I for incomplete");
                        System.out.println("Enter D for completed with difficulty");
                        System.out.println("Enter C for completed without difficulty");
                        System.out.println("Enter E for exceeded standard");
                        char evalMark = Character.toLowerCase(br.readLine().charAt(0));;

                        // If 0 is entered, the officer is editing an evaluation for flight commander
                        if(cadetEvaluationIndex == -1) {
                            ics4u.getFlights()[flightEvaluationIndex].getFlightCommander().modifyEvaluations(evalMark, evalIndex);
                        }

                        // If -1 is entered, the officer is editing an evaluation for the chief
                        else if (cadetEvaluationIndex < -1) {
                            ics4u.getChief().modifyEvaluations(evalMark, evalIndex);
                        }

                        // If the number entered is not 0, then an evaluation is edited for a cadet in the flight
                        else {
                            ics4u.getFlights()[flightEvaluationIndex].getCadets()[cadetEvaluationIndex].modifyEvaluations(evalMark, evalIndex);
                        }
                    }

                    // If the officer wishes to add a cadet to a flight, the program allows them to do so
                    if (choice == 8) {

                        // Prints out a list of flights and asks which flight they wish to edit
                        System.out.println("");
                        for (int i = 0; i < ics4u.getFlights().length; i++) {
                            System.out.println("Flight #" + Integer.toString(i + 1) + ": " + ics4u.getFlights()[i].getName());
                        }
                        System.out.println("Which flight would you like to add a cadet to? Enter the flight number.");
                        int flightIndex = Integer.parseInt(br.readLine()) - 1;
                        
                        // Asks for the cadet's name and rank
                        System.out.println("\nEnter the name of the cadet you will be adding.");
                        String newCadetName = br.readLine();
                        System.out.println("Enter the rank of this cadet.");
                        String newCadetRank = br.readLine();

                        // Creates a temporary cadet object, which is added to the flight.
                        Cadet newCadet = new Cadet(newCadetName, "pw", newCadetRank);
                        System.out.println("This cadet has been added to your flight. By default, their password is \"pw\". They can change this once they login.");
                        ics4u.getFlights()[flightIndex].addCadet(newCadet);
                    }

                    // If the officer wishes to remove a cadet from a flight, the program allows them to do so
                    if (choice == 9) {

                        // Prints out a list of flights and asks which flight they wish to edit
                        System.out.println("");
                        for (int i = 0; i < ics4u.getFlights().length; i++) {
                            System.out.println("Flight #" + Integer.toString(i + 1) + ": " + ics4u.getFlights()[i].getName());
                        }
                        System.out.println("Which flight would you like to edit? Enter the flight number.");
                        int flightIndex = Integer.parseInt(br.readLine()) - 1;
                        
                        // Prints the list of cadets and asks which cadet they wish to remove
                        System.out.println(ics4u.getFlights()[flightIndex]);
                        System.out.println("Select the index number (Not the ID) of the cadet you wish to remove.");

                        // Takes input and removes the cadet from the flight
                        int cadetRemoveIndex = Integer.parseInt(br.readLine()) - 1;
                        ics4u.getFlights()[flightIndex].removeCadet(cadetRemoveIndex);
                    }

                    // If the officer wishes to move the cadet from one flight to another, the following allows them to do so
                    if (choice == 10) {

                        // Prints the list of cadets and asks which cadet they wish to remove
                        System.out.println("\n" + ics4u);
                        System.out.println("\nSelect the ID number of the cadet you wish to move");
                        int cadetMoveId = Integer.parseInt(br.readLine());

                        // Prints out a list of flights and asks which flight they wish to edit
                        System.out.println("");
                        for (int i = 0; i < ics4u.getFlights().length; i++) {
                            System.out.println("Flight #" + Integer.toString(i + 1) + ": " + ics4u.getFlights()[i].getName());
                        }
                        System.out.println("Which flight would you like the cadet to be moved to? Enter the flight number.");
                        int newflightIndex = Integer.parseInt(br.readLine());

                        // Moves cadet from one flight to another
                        ics4u.moveCadet(cadetMoveId, newflightIndex);
                    }  
                    
                    // If the officer wishes to add a flight to the squadron, the following allows them to do that
                    if (choice == 11) {

                        // Asks the user for the name of the flight
                        System.out.println("\nEnter the name of the flight:");
                        String newFlightName = br.readLine();

                        // Asks the user for information about the flight commander
                        System.out.println("Enter the name of the flight commander:");
                        String newFlightCommanderName = br.readLine();
                        System.out.println("Enter the rank of the new flight commander:");
                        String newFlightCommanderRank = br.readLine();
                        System.out.println("By default, their password is \"pw\", which can be changed once they've logged in.");

                        // Creating a temporary cadet object
                        Cadet newFlightCommander = new Cadet(newFlightCommanderName, "pw", newFlightCommanderRank);

                        // Creating a temporary flight object
                        Flight newFlight = new Flight(newFlightName, new Cadet[0], newFlightCommander);

                        // Adding the flight to the squadron
                        ics4u.addFlight(newFlight);
                    }

                    // If the officer wishes to remove a flight, the following allows the to do that
                    if (choice == 12) {

                        // Prints out a list of flights and asks which flight they wish to remove
                        System.out.println("");
                        for (int i = 0; i < ics4u.getFlights().length; i++) {
                            System.out.println("Flight #" + Integer.toString(i + 1) + ": " + ics4u.getFlights()[i].getName());
                        }
                        System.out.println("Which flight would you like to remove? Enter the flight number.");
                        int removeflightIndex = Integer.parseInt(br.readLine());

                        // Removes the flight from the squadron
                        ics4u.removeFlight(removeflightIndex);
                    }

                    // If the officer wishes to add an officer to the squadron, they can do so here
                    if (choice == 13) {

                        // Asks for the officer's name rank and salary
                        System.out.println("\nEnter the name of the officer you will be adding.");
                        String newOfficerName = br.readLine();
                        System.out.println("Enter the rank of this officer.");
                        String newOfficerRank = br.readLine();
                        System.out.println("Enter the salary of this officer.");
                        int newOfficerSalary = Integer.parseInt(br.readLine());

                        // Creates a temporary officer object, which is added to the squadron.
                        Officer newOfficer = new Officer(newOfficerName, "pw", newOfficerRank, newOfficerSalary);
                        System.out.println("This officer has been added to your squadron. By default, their password is \"pw\". They can change this once they login.");
                        ics4u.addOfficer(newOfficer);;
                    }

                    // If the officer wishes to remove an officer from the squadron, they can do so here
                    if (choice == 14) {

                        System.out.println("");
                        // Prints the list of cadets and asks which cadet they wish to remove
                        for (int i = 0; i < ics4u.getOfficers().length; i++) {
                            System.out.println("Officer #" + Integer.toString(i + 1) + ": " + ics4u.getOfficers()[i].toString());
                        }
                        System.out.println("Select the index number (Not the ID) of the officer you wish to remove.");

                        // Takes input and removes the officer from the squadron
                        int officerRemoveIndex = Integer.parseInt(br.readLine()) - 1;
                        ics4u.removeOfficer(officerRemoveIndex);
                    }
                }

                // Stuff for flight commanders to do
                else if (personIndex[1] < 0) {
                    choice = flightCommanderChoice(br);

                    // If the flight commander chooses to see their summer training, print summer training
                    if (choice == 2) {
                        System.out.println("\n" + Arrays.toString(ics4u.getFlights()[personIndex[0]].getFlightCommander().getSummerTraining()));
                    }

                    // If the flight commander chooses to see their evaluations, print their evaluations
                    if (choice == 3) {
                        System.out.println("\n" + ics4u.getFlights()[personIndex[0]].getFlightCommander().evaluationsToString());
                    }

                    // If the flight commander chooses to change their password, run the change pw method
                    if (choice == -2) {
                        newPw = newPassword(br);
                        ics4u.getFlights()[personIndex[0]].getFlightCommander().setPassword(newPw);
                    }

                    // If the flight commander wishes to view their cadets' summer training, the program prints that information
                    if (choice == 4) {
                        System.out.println("");
                        for (Cadet i : ics4u.getFlights()[personIndex[0]].getCadets()) {
                            System.out.println(i.getRank() + " " + i.getName() + ": " + Arrays.toString(i.getSummerTraining()));
                        }
                    }

                    // If the flight commander wishes to view their cadets' evaluations, the program prints that information
                    if (choice == 5) {
                        System.out.println("");
                        for (Cadet i : ics4u.getFlights()[personIndex[0]].getCadets()) {
                            System.out.println(i.evaluationsToString() + "\n");
                        }
                    }

                    // If the flight commander wishes to add a summer training to a cadet, the programs does that
                    if (choice == 6) {

                        // Prints the list of cadets and asks which cadet they wish to add a summer training to
                        System.out.println(ics4u.getFlights()[personIndex[0]]);
                        System.out.println("Which cadet would you like to add a summer training to? Enter the cadet number (Not their ID). Enter 0 to edit yourself.");
                        
                        // Takes the index number of the cadet and the name of the course, and adds it to that cadet
                        int cadetSummerTrainingIndex = Integer.parseInt(br.readLine()) - 1;
                        System.out.println("What course would you like to add?");
                        String summerCourse = br.readLine();

                        // If 0 is entered, the Flight commander is adding a course for themself
                        if (cadetSummerTrainingIndex < 0) {
                            ics4u.getFlights()[personIndex[0]].getFlightCommander().addSummerCourse(summerCourse);
                        }

                        // If the number entered is not 0, then a course is added for a cadet in the flight
                        else {
                            ics4u.getFlights()[personIndex[0]].getCadets()[cadetSummerTrainingIndex].addSummerCourse(summerCourse);
                        }
                    }

                    // If the flight commander wishes to edit an evaluation for a cadet, the programs does that
                    if (choice == 7) {

                        // Prints the list of cadets and asks which cadet they wish to add a summer training to
                        System.out.println(ics4u.getFlights()[personIndex[0]]);
                        System.out.println("Which cadet would you like to edit evaluations for? Enter the cadet number (Not their ID). Enter 0 to edit yourself.");
                        
                        // Takes the index number of the cadet and the name of the course, and adds it to that cadet
                        int cadetEvaluationIndex = Integer.parseInt(br.readLine()) - 1;

                        // Takes the index number of the evaluation
                        System.out.println("Which evaluation would you like to edit?");
                        System.out.println("Enter 1 for leadership");
                        System.out.println("Enter 2 for drill");
                        System.out.println("Enter 3 for teaching");
                        System.out.println("Enter 4 for aviation");
                        int evalIndex = Integer.parseInt(br.readLine());

                        // Takes a char input for the mark the cadet is receiving
                        System.out.println("What mark is this cadet receiving?");
                        System.out.println("Enter I for incomplete");
                        System.out.println("Enter D for completed with difficulty");
                        System.out.println("Enter C for completed without difficulty");
                        System.out.println("Enter E for exceeded standard");
                        char evalMark = Character.toLowerCase(br.readLine().charAt(0));;

                        // If 0 is entered, the Flight commander is editing an evaluation for themself
                        if (cadetEvaluationIndex < 0) {
                            ics4u.getFlights()[personIndex[0]].getFlightCommander().modifyEvaluations(evalMark, evalIndex);
                        }

                        // If the number entered is not 0, then an evaluation is editied for a cadet in the flight
                        else {
                            ics4u.getFlights()[personIndex[0]].getCadets()[cadetEvaluationIndex].modifyEvaluations(evalMark, evalIndex);
                        }
                    }

                    // If the flight commander wishes to add a cadet to the flight, the program allows them to do so
                    if (choice == 8) {
                        
                        // Asks for the cadet's name and rank
                        System.out.println("\nEnter the name of the cadet you will be adding.");
                        String newCadetName = br.readLine();
                        System.out.println("Enter the rank of this cadet.");
                        String newCadetRank = br.readLine();

                        // Creates a temporary cadet object, which is added to the flight.
                        Cadet newCadet = new Cadet(newCadetName, "pw", newCadetRank);
                        System.out.println("This cadet has been added to your flight. By default, their password is \"pw\". They can change this once they login.");
                        ics4u.getFlights()[personIndex[0]].addCadet(newCadet);
                    }

                    // If the flight commander wishes to remove a cadet from their flight, the program allows them to do so
                    if (choice == 9) {

                        // Prints the list of cadets and asks which cadet they wish to remove
                        System.out.println(ics4u.getFlights()[personIndex[0]]);
                        System.out.println("Select the index number (Not the ID) of the cadet you wish to remove.");

                        // Takes input and removes the cadet from the flight
                        int cadetRemoveIndex = Integer.parseInt(br.readLine()) - 1;
                        ics4u.getFlights()[personIndex[0]].removeCadet(cadetRemoveIndex);
                    }
                }

                // Stuff for cadets to do
                else {
                    choice = cadetChoice(br);

                    // If the cadet chooses to see their summer training, print summer training
                    if (choice == 2) {
                        System.out.println("\n" + Arrays.toString(ics4u.getFlights()[personIndex[0]].getCadets()[personIndex[1]].getSummerTraining()));
                    }

                    // If the cadet chooses to see their evaluations, print their evaluations
                    if (choice == 3) {
                        System.out.println("\n" + ics4u.getFlights()[personIndex[0]].getCadets()[personIndex[1]].evaluationsToString());
                    }

                    // If the cadet chooses to change their password, run the change pw method
                    if (choice == -2) {
                        newPw = newPassword(br);
                        ics4u.getFlights()[personIndex[0]].getCadets()[personIndex[1]].setPassword(newPw);
                    }

                    // 
                }
                
                // If the person chooses to print the squadron, print the squadron
                if (choice == 1) {
                    System.out.println("\n" + ics4u);
                }

                // If the person chooses to logout, it logs them out
                if (choice == -1) {
                    isLogin = false;
                }
                
                System.out.println("Enter anything to continue");
                br.readLine();
            }

            System.out.println("Goodbye " +  user.getRank() + " " + user.getName() + "!");
            System.out.println("\nDo you want to keep running the program? Y or N");
            String yesOrNo = br.readLine();

            // If the user choses to stop the program, it exits the loop
            if (yesOrNo.equalsIgnoreCase("n")) {
                isProgramRunning = false;
            }
        }

        System.out.println("Shutting down...");
    }
    
    /*
    * A method that asks an officer for their choice and returns a number based on what they choose
    * 
    * @param br  To use the same BufferedReader already declared in the main method
    * 
    * @return an integer based on the decision the officer made
    */
    private static int officerChoice(BufferedReader br) throws IOException {

        // Prints out options
        System.out.println("\nPlease enter a number to pick what you want to do from the options below:");
        System.out.println("1. Print my squadron");
        System.out.println("2. See my summer training courses");
        System.out.println("3. View my evaluations");
        System.out.println("4. See squadron summer training courses");
        System.out.println("5. View squadron evaluations");
        System.out.println("6. Add summer training courses for a cadet");
        System.out.println("7. Edit evaluations for a cadet");
        System.out.println("8. Adding a cadet to a flight");
        System.out.println("9. Removing a cadet from a flight");
        System.out.println("10. Move a cadet from one flight to another");
        System.out.println("11. Add a flight");
        System.out.println("12. Remove a flight");
        System.out.println("13. Add an officer to the squadron");
        System.out.println("14. Remove an officer from the squadron");
        System.out.println("15. Change password");
        System.out.println("16. Logout");

        int choice = Integer.parseInt(br.readLine());

        // If they choose to change password, return -2
        if (choice == 15) {
            return -2;
        }

        // If they choose to logout, return -1
        else if (choice == 16) {
            return -1;
        }

        // Otherwise, return their choice
        return choice;
    }

    /*
    * A method that asks flight commaders for their choice and returns a number based on what they choose
    * 
    * @param br  To use the same BufferedReader already declared in the main method
    * 
    * @return an integer based on the decision the flight commander made
    */
    private static int flightCommanderChoice(BufferedReader br) throws IOException {

        // Prints out options
        System.out.println("\nPlease enter a number to pick what you want to do from the options below:");
        System.out.println("1. Print my squadron");
        System.out.println("2. See my summer training courses");
        System.out.println("3. View my evaluations");
        System.out.println("4. See flight summer training courses");
        System.out.println("5. View flight evaluations");
        System.out.println("6. Add summer training courses for a cadet in my flight");
        System.out.println("7. Edit evaluations for a cadet in my flight");
        System.out.println("8. Adding a cadet to my flight");
        System.out.println("9. Removing a cadet from my flight");
        System.out.println("10. Change password");
        System.out.println("11. Logout");

        int choice = Integer.parseInt(br.readLine());

        // If they choose to change password, return -2
        if (choice == 10) {
            return -2;
        }

        // If they choose to logout, return -1
        else if (choice == 11) {
            return -1;
        }

        // Otherwise, return their choice
        return choice;
    }

    /*
    * A method that asks cadets for their choice and returns a number based on what they choose
    * 
    * @param br  To use the same BufferedReader already declared in the main method
    * 
    * @return an integer based on the decision the cadet made
    */
    private static int cadetChoice(BufferedReader br) throws IOException{

        // Prints out options
        System.out.println("\nPlease enter a number to pick what you want to do from the options below:");
        System.out.println("1. Print my squadron");
        System.out.println("2. See my summer training courses");
        System.out.println("3. View my evaluations");
        System.out.println("4. Change password");
        System.out.println("5. Logout");

        int choice = Integer.parseInt(br.readLine());

        // If they choose to change password, return -2
        if (choice == 4) {
            return -2;
        }

        // If they choose to logout, return -1
        else if (choice == 5) {
            return -1;
        }

        // Otherwise, return their choice
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

    /*
    * A method that asks the user for a new password, and stops looping once the old and new password match
    *
    * @param br  To use the same BufferedReader already declared in the main method
    * @return the new password
    */
    private static String newPassword(BufferedReader br) throws IOException{
        String newPw = "b";
        String newPwConfirm = "a";

        // While the new password and confirmation password don't match, keep looping
        while (!newPw.equals(newPwConfirm)) {

            // Asks the user for their new password and confirmation password
            System.out.print("\n" + "Enter your new password: ");
            newPw = br.readLine();
            System.out.print("Confirm your new password: ");
            newPwConfirm = br.readLine();

            // If the new password and confirmation password don't match, tell the user
            if (!newPw.equals(newPwConfirm)) {
                System.out.println("Your passwords don't match. Try again.");
            }
        }

        // Tell the user their password has been chnaged, and return the new password
        System.out.println("Password changed!");
        return newPw;
    }
}
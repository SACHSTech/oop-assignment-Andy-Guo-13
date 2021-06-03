/*
* Squadron class that contains an array of flights, array of officers, a chief and CO
* 
* @author: Andy Guo
*/

public class Squadron {
    
    // Declaring variables
    private int sqnNum;
    private String sqnName;
    private Flight[] flights;
    private Cadet chief;
    private Officer[] officers;
    private Officer commandingOfficer;

    /*
    * Constructor - creates new instance of a Squadron object
    * 
    * @param sqnNum  The number of the squadron
    * @param sqnName  The name of the squadron
    * @param flights[]  An array containing all the flights
    * @param chief  A cadet object that represents the CWO of the squadron
    * @param officers[]  An array containing all the officers
    * @param commandingOfficer  An officer object representing the CO of the squadron
    */
    public Squadron(int sqnNum, String sqnName, Flight[] flights, Cadet chief, Officer[] officers, Officer commandingOfficer) {
        this.setSqnNum(sqnNum);
        this.setSqnName(sqnName);
        this.setFlights(flights);
        this.chief = chief;
        this.setOfficers(officers);
        this.commandingOfficer = commandingOfficer;

        // Changing the role for the chief and CO respectively
        this.chief.setRole("Chielf Warrant Officer");
        this.commandingOfficer.setRole("Commanding Officer");

        // Giving the chief and CO special emails (role.squadronname@cadetmail.com)
        this.chief.setEmail("cwo." + Integer.toString(this.sqnNum) + this.sqnName.toLowerCase() + "@cadetmail.com");
        this.commandingOfficer.setEmail("co." + Integer.toString(this.sqnNum) + this.sqnName.toLowerCase() + "@cadetmail.com");
    }

    /*
    * Returns the value of the integer sqnNum
    *
    * @return the value of sqnNum
    */
    public int getSqnNum() {
        return sqnNum;
    }

    /*
    * Sets the value of sqnNum
    * 
    * @param sqnNum  The value that this.sqnNum will be set to
    */
    public void setSqnNum(int sqnNum) {
        this.sqnNum = sqnNum;
    }

    /*
    * Returns the value of the string sqnName
    *
    * @return the value of sqnName
    */
    public String getSqnName() {
        return sqnName;
    }

    /*
    * Sets the value of sqnName
    * 
    * @param sqnName  The value that this.sqnName will be set to
    */
    public void setSqnName(String sqnName) {
        this.sqnName = sqnName;
    }

    /*
    * Returns the Officer object commandingOfficer
    *
    * @return the Officer object commandingOfficer
    */
    public Officer getCommandingOfficer() {
        return commandingOfficer;
    }

    /*
    * Sets the value of commandingOfficer
    * In addition, the role and email of the old commanding officer is changed
    * The new commanding officer also gets their email and role modified
    * 
    * @param commandingOfficer  The value that this.commandingOfficer will be set to
    */
    public void setCommandingOfficer(Officer commandingOfficer) {
        this.commandingOfficer.setEmail(Integer.toString(this.commandingOfficer.getIdNum()) + "@cadetmail.com");
        this.commandingOfficer.setRole("Officer");

        this.commandingOfficer = commandingOfficer;

        this.commandingOfficer.setEmail("co." + Integer.toString(this.sqnNum) + this.sqnName.toLowerCase() + "@cadetmail.com");
        this.commandingOfficer.setRole("Commanding Officer");
    }

    /*
    * Returns the array of Officers contained within officers[]
    *
    * @return the Officer array officers[]
    */
    public Officer[] getOfficers() {
        return officers;
    }

    /*
    * Sets the value of officers
    * 
    * @param officers  The value that this.officers will be set to
    */
    public void setOfficers(Officer[] officers) {
        this.officers = officers;
    }

    /*
    * Returns the Cadet object chief
    *
    * @return the Cadet object chief
    */
    public Cadet getChief() {
        return chief;
    }

    /*
    * Sets the value of chief
    * In addition, the role and email of the old chief is changed
    * The new chief also gets their email and role modified
    * 
    * @param chief  The value that this.chief will be set to
    */
    public void setChief(Cadet chief) {
        this.chief.setEmail(Integer.toString(this.chief.getIdNum()) + "@cadetmail.com");
        this.chief.setRole("Cadet");

        this.chief = chief;

        this.chief.setEmail("cwo." + Integer.toString(this.sqnNum) + this.sqnName.toLowerCase() + "@cadetmail.com");
        this.chief.setRole("Commanding Officer");
    }

    /*
    * Returns the array of Flight contained within flights[]
    *
    * @return the Flight array flights[]
    */
    public Flight[] getFlights() {
        return flights;
    }

    /*
    * Sets the value of flights
    * 
    * @param flights  The value that this.flights will be set to
    */
    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    /*
    * String representation of the entire squadron that can be used to print
    *
    * @return a string representation of the squadron object
    */
    public String toString() {
        // Adding the name of the squadron to the string
        String toPrint = Integer.toString(this.sqnNum) + " " + this.sqnName;

        // Adding the name of the CO and Chief to the string
        toPrint += "\n" + "Commanding officer: " + commandingOfficer.toString();
        toPrint += "\n" + "Chief Warrant Officer: " + chief.toString();

        // Adding the officers to the string
        toPrint += "\n";
        toPrint += "\n" + "Squadron staff";
        for (int i = 0; i < officers.length; i++) {
            toPrint += "\n" + "Officer #" + Integer.toString(i + 1) + ": " + officers[i].toString();
        }

        // Adding the flights to the string
        for (int i = 0; i < flights.length; i++) {
            toPrint += "\n";
            toPrint += "\n" + "Flight #" + Integer.toString(i + 1) + ": " + flights[i].getName() + " flight";
            toPrint += "\n" + flights[i].toString();
        }

        // Returning the string
        return toPrint;
    }

    /*
    * A method that extends the flights array by 1 and adds a flight object
    *
    * @param newFlight  The value to be added to flight
    */
    public void addFlight(Flight newFlight) {
        // Taking the length of the flights array
        int length = this.flights.length;

        // Declaring a string array 1 longer than the cadets array
        Flight[] tempArray = new Flight[length + 1];

        // Counter variable
        int counter = 0;

        // Loading the flgiths array into the temporary array
        for (Flight i : this.flights) {
            tempArray[counter] = i;
            counter++;
        }

        // Adding the new cadet into the last index of the array
        tempArray[counter] = newFlight;

        // Changing the cadets array to the temporary array
        this.setFlights(tempArray);
    }

    /*
    * A method that removes an object from the flights array
    *
    * @param index  The index in the array to be removed
    */
    public void removeFlight(int index) {

        // Arrays start from 0, so decement index
        index--;

        // If the flight is not empty, don't allow the user to remove that flight
        if (this.flights[index].getCadets().length != 0) {
            System.out.println("There are still cadets in this flight. This action can only be completed if the flight is empty");
        }
        
        // Otherwise, the flight is empty, and so the flight can be removed
        else {
            // Taking the length of the flight array
            int length = this.flights.length;

            // Declaring a string array 1 shorter than the flight array
            Flight[] tempArray = new Flight[length - 1];

            // Declaring an adder variable which will be set to 1 once the index is reached
            int adder = 0;

            // Looping for each index of the temp array
            for (int i = 0; i < length - 1; i++) {

                // If the index of the flight is reached, adder is set to 1
                if (i == index) {
                    adder++;
                }

                // Loading flight into the temp array. If the index is reached, the index of the cadet array is incremented by 1
                tempArray[i] = this.flights[i + adder];
            }

            // Setting the flight array to the temporary array
            this.setFlights(tempArray);
        }
    }
    
    /*
    * A method that extends the officers array by 1 and adds an officer object
    *
    * @param newOfficer  The value to be added to officers
    */
    public void addOfficer(Officer newOfficer) {
        // Taking the length of the officers array
        int length = this.officers.length;

        // Declaring a string array 1 longer than the officers array
        Officer[] tempArray = new Officer[length + 1];

        // Counter variable
        int counter = 0;

        // Loading the officers array into the temporary array
        for (Officer i : this.officers) {
            tempArray[counter] = i;
            counter++;
        }

        // Adding the new officer into the last index of the array
        tempArray[counter] = newOfficer;

        // Changing the officer array to the temporary array
        this.setOfficers(tempArray);
    }

    /*
    * A method that removes an object from the officers array
    *
    * @param index  The index in the array to be removed
    */
    public void removeOfficer(int index) {
        // Taking the length of the officers array
        int length = this.officers.length;

        // Declaring a string array 1 shorter than the officers array
        Officer[] tempArray = new Officer[length - 1];

        // Declaring an adder variable which will be set to 1 once the index is reached
        int adder = 0;

        // Looping for each index of the temp array
        for (int i = 0; i < length - 1; i++) {

            // If the index of the officer is reached, adder is set to 1
            if (i == index) {
                adder++;
            }

            // Loading officers into the temp array. If the index is reached, the index of the cadet array is incremented by 1
            tempArray[i] = this.officers[i + adder];
        }

        // Setting the officers array to the temporary array
        this.setOfficers(tempArray);
    }
    
    /*
    * Does a linear search to finds the indices of the cadet/officer who has a given ID number
    *
    * @param idFind  The ID number to find
    *
    * @return The indicies of the cadet/officer with the given ID. The first number represents the flight index, and the second number represents the index of the cadet in the flight
    * If the flight commander is the cadet with the ID number, the second number will be -2
    * If an officer (not the CO) is the person with the ID number, the first number will be -2
    * If the chief is the person with the ID number, the first number will be -3
    * If the CO is the person with the ID number, the first number will be -4
    * If no one is found, it will return [-1, -1]
    */
    public int[] findID(int idFind) {

        // If the CO has that ID, return [-4, 0]
        if (idFind == commandingOfficer.getIdNum()) {
            return new int[]{-4, 0};
        }

        // If the chief has that ID, return [-3, 0]
        if (idFind == chief.getIdNum()) {
            return new int[]{-3, 0};
        }

        // Iterate through the officer array
        for (int i = 0; i < this.officers.length; i++) {
            if (officers[i].getIdNum() == idFind) {
                return new int[]{-2, i};
            }
        }

        // Iterate through the flights
        for (int i = 0; i < this.flights.length; i++) {
            // Setting an integer variable to the index of the ID found within a flight
            int cadetIndex = flights[i].findID(idFind);
            
            // If the index is -1, go back to the beginning of the loop
            if (cadetIndex == -1) {
                continue;
            } else { // Redundant else to be safe
                // Return [index of the flight in the squadron, index of the cadet within that flight]
                return new int[]{i, cadetIndex};
            }
        }

        // If no one has that ID, return [-1, -1]
        return new int[]{-1, -1};
    }

    /*
    * Moves a cadet from one flight to another
    * 
    * @param cadetId  The ID number of the cadet that is to be moved
    * @param flightNum  The flight number that the cadet will be moved into
    */
    public void moveCadet(int cadetId, int flightNum) {

        // Arrays start at 0, so flightNum is decremented
        flightNum--;
        
        // Seeing if the ID exists and loading the relevant information into a 2D array
        int[] cadetIndex = this.findID(cadetId);

        // If both numbers in the cadet index is greater than or equal to 0, that means that this cadet can be moved
        if (cadetIndex[0] >= 0 && cadetIndex[1] >= 0) {
            
            // Creates a temporary cadet object to store information about cadet being removed
            Cadet tempCadet = this.getFlights()[cadetIndex[0]].getCadets()[cadetIndex[1]];

            // Removes the cadet from their current flight
            this.flights[cadetIndex[0]].removeCadet(cadetIndex[1]);

            // Adds the cadet into their new flight
            this.flights[flightNum].addCadet(tempCadet);

            // Prints what has happened
            System.out.println(tempCadet.getRank() + " " + tempCadet.getName() + " has been moved to " + this.getFlights()[flightNum].getName() + " flight.");
        }

        // If both numbers are not >= 0, it means the person is either a flight commander, the chief, or officer, or does not exist
        else {
            System.out.println("The ID belongs to a person who is either a flight commander, the chief, or officer, or does not exist.");
            System.out.println("The move cannot be completed.");
        }
    }
}

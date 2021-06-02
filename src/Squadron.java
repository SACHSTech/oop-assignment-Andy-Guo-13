public class Squadron {
    
    // Declaring variables
    private int sqnNum;
    private String sqnName;
    private Flight[] flights;
    private Cadet chief;
    private Officer[] officers;
    private Officer commandingOfficer;

    // Constructor
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

    // Getters and setters
    public int getSqnNum() {
        return sqnNum;
    }

    public void setSqnNum(int sqnNum) {
        this.sqnNum = sqnNum;
    }

    public String getSqnName() {
        return sqnName;
    }

    public void setSqnName(String sqnName) {
        this.sqnName = sqnName;
    }

    public Officer getCommandingOfficer() {
        return commandingOfficer;
    }

    // Made modifications
    public void setCommandingOfficer(Officer commandingOfficer) {
        this.commandingOfficer.setEmail(Integer.toString(this.commandingOfficer.getIdNum()) + "@cadetmail.com");
        this.commandingOfficer.setRole("Officer");

        this.commandingOfficer = commandingOfficer;

        this.commandingOfficer.setEmail("co." + Integer.toString(this.sqnNum) + this.sqnName.toLowerCase() + "@cadetmail.com");
        this.commandingOfficer.setRole("Commanding Officer");
    }

    public Officer[] getOfficers() {
        return officers;
    }

    public void setOfficers(Officer[] officers) {
        this.officers = officers;
    }

    public Cadet getChief() {
        return chief;
    }

    // Made modifications
    public void setChief(Cadet chief) {
        this.chief.setEmail(Integer.toString(this.chief.getIdNum()) + "@cadetmail.com");
        this.chief.setRole("Cadet");

        this.chief = chief;

        this.chief.setEmail("cwo." + Integer.toString(this.sqnNum) + this.sqnName.toLowerCase() + "@cadetmail.com");
        this.chief.setRole("Commanding Officer");
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    // ToString method
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

    // Adding a flight to the squadron
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

    // Removing a flight from the squadron
    public void removeFlight(int index) {
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
    
    // Adding an officer to the squadron
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

    // Removing an officer from the squadron
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

}

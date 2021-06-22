package chain_of_command;

/*
* Flight class that contains an array of cadets and a flight commander
* 
* @author: Andy Guo
*/

import chain_of_command.*;

public class Flight {

    // Declaring variables
    private Cadet[] cadets;
    private Cadet flightCommander;
    private String name;

    /*
    * Constructor - creates new instance of a Flight object
    * 
    * @param name  The name of the flight
    * @param cadets[]  An array containing all the cadets
    * @param flightCommander  An officer object representing the flight commander of the flight
    */
    public Flight(String name, Cadet[] cadets, Cadet flightCommander) {
        this.setCadets(cadets);
        this.flightCommander = flightCommander;
        this.setName(name);

        // Setting the flight commander's role
        this.flightCommander.setRole("Flight Commander");
    }

    /*
    * Returns the value of the string name
    *
    * @return the value of name
    */
    public String getName() {
        return name;
    }

    /*
    * Sets the value of name
    * 
    * @param name  The value that this.name will be set to
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    * Returns the Cadet object flightCommander
    *
    * @return the Cadet object flightCommander
    */
    public Cadet getFlightCommander() {
        return flightCommander;
    }

    /*
    * Sets the value of flightCommander
    * In addition, the role and email of the old flight commander is changed
    * The new flight commander also gets their email and role modified
    * 
    * @param flightCommander  The value that this.flightCommander will be set to
    */
    public void setFlightCommander(Cadet flightCommander) {
        this.flightCommander.setRole("Cadet");
        
        this.flightCommander = flightCommander;

        this.flightCommander.setRole("Flight Commander");
    }

    /*
    * Returns the array of Cadet contained within cadets[]
    *
    * @return the Cadet array cadets[]
    */
    public Cadet[] getCadets() {
        return cadets;
    }

    /*
    * Sets the value of cadets
    * 
    * @param cadets  The value that this.cadets will be set to
    */
    public void setCadets(Cadet[] cadets) {
        this.cadets = cadets;
    }

    /*
    * String representation of a flight object that can be used to print
    *
    * @return a string representation of the flight object
    */
    public String toString() {

        // Adding the flight commander toString to the string
        String toPrint = this.name + " flight Commander: " + flightCommander.toString();

        // Adding the individual cadets to the toString
        for (int i = 0; i < cadets.length; i++) {
            toPrint += "\n" + "Cadet #" + Integer.toString(i + 1) + ": " + cadets[i].toString();
        }

        // Returning the string
        return toPrint;
    }

    /*
    * A method that extends the cadets array by 1 and adds a cadet object
    *
    * @param newCadet  The object to be added to cadets
    */
    public void addCadet(Cadet newCadet) {
        // Taking the length of the cadets array
        int length = this.cadets.length;

        // Declaring a string array 1 longer than the cadets array
        Cadet[] tempArray = new Cadet[length + 1];

        // Counter variable
        int counter = 0;

        // Loading the cadets array into the temporary array
        for (Cadet i : this.cadets) {
            tempArray[counter] = i;
            counter++;
        }

        // Adding the new cadet into the last index of the array
        tempArray[counter] = newCadet;

        // Changing the cadets array to the temporary array
        this.setCadets(tempArray);
    }

    /*
    * A method that removes an object from the cadets array
    *
    * @param index  The index in the array to be removed
    */
    public void removeCadet(int index) {
        // Taking the length of the cadets array
        int length = this.cadets.length;

        // Declaring a string array 1 shorter than the cadets array
        Cadet[] tempArray = new Cadet[length - 1];

        // Declaring an adder variable which will be set to 1 once the index is reached
        int adder = 0;

        // Looping for each index of the temp array
        for (int i = 0; i < length - 1; i++) {

            // If the index of the cadet is reached, adder is set to 1
            if (i == index) {
                adder++;
            }

            // Loading cadets into the temp array. If the index is reached, the index of the cadet array is incremented by 1
            tempArray[i] = this.cadets[i + adder];
        }

        // Setting the cadets array to the temporary array
        this.setCadets(tempArray);
    }

    /*
    * Does a linear search to find the index number of the cadet with that ID number
    * 
    * @param idFind  The ID number in question to find
    *
    * @return The index of the ID number. If no such cadet is found, return -1. If the index is of the flight commander, return -2
    */
    public int findID(int idFind) {
        
        // If the ID is that of the flight commander, return -2
        if (idFind == flightCommander.getIdNum()) {
            return -2;
        }

        // Iterate through each ID of the cadet array. If one is found, return the index number
        for (int i = 0; i < this.cadets.length; i++) {
            if (cadets[i].getIdNum() == idFind) {
                return i;
            }
        }

        // Return -1 if there is no match
        return -1;
    }

}

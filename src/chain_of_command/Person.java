package chain_of_command;

/*
* Person class that is a parent class to Officer and Cadet classes.
* Every Person has a name, ID number, password, email and rank
* 
* @author: Andy Guo
*/

import chain_of_command.*;

public class Person {

    // Declaring variables
    private String name;
    private int idNum;
    private String password;
    private String email;
    private String rank;

    // For assigning identification numbers
    private static int idIncrement = 1000000;

    /*
    * Constructor - creates new instance of a Flight object
    * 
    * @param name  The name of the person
    * @param password  The password of this person
    * @param rank  The rank of the person
    */
    public Person(String name, String password, String rank) {
        this.setName(name);
        this.setPassword(password);
        this.setRank(rank);
        this.idNum = idIncrement;

        // Increments the ID number by 1 to ensure no one has the same ID
        idIncrement++;

        // Assigning an email to each cadet (idnumber@cadetmail.com)
        this.setEmail(Integer.toString(idNum) + "@cadetmail.com");
    }

    /*
    * Returns the value of the int idNum
    *
    * @return the value of idNum
    */
    public int getIdNum() {
        return idNum;
    }

    /*
    * Sets the value of idNum
    * 
    * @param idNum  The value that this.idNum will be set to
    */
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /*
    * Returns the value of the string rank
    *
    * @return the value of rank
    */
    public String getRank() {
        return rank;
    }

    /*
    * Sets the value of rank
    * 
    * @param rank  The value that this.rank will be set to
    */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /*
    * Returns the value of the string email
    *
    * @return the value of email
    */
    public String getEmail() {
        return email;
    }

    /*
    * Sets the value of email
    * 
    * @param email  The value that this.email will be set to
    */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
    * Returns the value of the string password
    *
    * @return the value of password
    */
    public String getPassword() {
        return password;
    }

    /*
    * Sets the value of password
    * 
    * @param password  The value that this.password will be set to
    */
    public void setPassword(String password) {
        this.password = password;
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
    * String representation of the person object that can be used to print
    *
    * @return a string representation of the person object
    */
    public String toString() {
        return Integer.toString(idNum) + " " + this.rank + " " + this.name;
    }

    /*
    * Returns true or false based on whether the input password matches the person's password
    * 
    * @param inputPw  The input password to be macthed to the person's password
    *
    * @return a boolean variable that is true if the passwords matches and false otherwise
    */
    public boolean checkPassword(String inputPw) {

        // If the password is correct, return true
        if (inputPw.equals(this.password)) {
            return true;
        }

        // If the password is incorrect, return false
        return false;
    }
}

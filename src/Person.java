/*
* Person class that is a parent class to Officer and Cadet classes.
* Every Person has a name, ID number, password, email and rank
* 
* @author: Andy Guo
*/

public class Person {

    // Declaring variables
    private String name;
    private int idNum;
    private String password;
    private String email;
    private String rank;

    // For assigning identification numbers
    private static int idIncrement = 1000000;

    // Constructor
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

    // Getters and setters

    /*
    * Returns the value of the int idNum
    *
    * @return the value of idNum
    */
    public int getIdNum() {
        return idNum;
    }

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

    public void setName(String name) {

        this.name = name;
    }

    // ToString method
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

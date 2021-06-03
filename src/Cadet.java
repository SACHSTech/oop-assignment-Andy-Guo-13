/*
* Cadet class that extends the person class.
* In addition to being a person, cadets have an array of summer training and evaluations, as well has having a role
* 
* @author: Andy Guo
*/

public class Cadet extends Person{

    // Delcaring variables
    private String[] summerTraining = new String[0];
    private String role;
    private char[] evaluations;

    /*
    * Constructor - creates new instance of a Flight object
    * 
    * @param name  The name of the cadet
    * @param password  The password of this cadet
    * @param rank  The rank of the cadet
    */
    public Cadet(String name, String password, String rank) {
        super(name, password, rank);

        // Assigning a role for each cadet
        this.setRole("Cadet");

        // By default, cadets fail all their evaluations
        this.setEvaluations(new char[]{'i', 'i', 'i', 'i'});
        // Evaluations are as follows: Leadership, drill, teaching, aviation
    }

    // Getters and setters

    /*
    * Returns the array of char contained within evaluations[]
    *
    * @return the char array evaluations[]
    */
    public char[] getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(char[] evaluations) {
        this.evaluations = evaluations;
    }

    /*
    * Returns the value of the string role
    *
    * @return the value of role
    */
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /*
    * Returns the array of string contained within summerTraining[]
    *
    * @return the string array summerTraining[]
    */
    public String[] getSummerTraining() {
        return summerTraining;
    }

    public void setSummerTraining(String[] summerTraining) {
        this.summerTraining = summerTraining;
    }
    
    // Adding a course for summer training
    public void addSummerCourse(String course) {
        // Taking the length of the summer training array
        int length = this.summerTraining.length;

        // Declaring a string array 1 longer than the summer training array
        String[] tempArray = new String[length + 1];

        // Counter variable
        int counter = 0;

        // Loading the summer training array into the string array
        for (String i : this.summerTraining) {
            tempArray[counter] = i;
            counter++;
        }

        // Adding the new course into the last index of the array
        tempArray[counter] = course;

        // Changing the summer training array to the temporary array
        this.setSummerTraining(tempArray);
    }

    /*
    * A method that converts the evaluation into a printable string
    * 
    * @return A string with a decription for each index of the evaluations array
    */
    public String evaluationsToString() {

        // Adding relevant information to the evalString variable
        String evalString = this.getRank() + " " + this.getName() + "'s evaluations:";
        evalString += "\n" + "1. Leadership evaluation: " + evalMarkToString(this.getEvaluations()[0]);
        evalString += "\n" + "2. Drill evaluation: " + evalMarkToString(this.getEvaluations()[1]);
        evalString += "\n" + "3. Teaching evaluation: " + evalMarkToString(this.getEvaluations()[2]);
        evalString += "\n" + "4. Aviation evaluation: " + evalMarkToString(this.getEvaluations()[3]);

        // Return evalString
        return evalString;
    }

    /*
    * A method that converts the char into the long form of what it represents
    *
    * @param evalChar  The mark the cadet received as a letter
    *
    * @return The mark the cadet received as a word
    */
    private static String evalMarkToString(char evalChar) {
        if (evalChar == 'i') {
            return "Incomplete";
        }
        else if (evalChar == 'd') {
            return "Completed with difficulty";
        }
        else if (evalChar == 'c') {
            return "Completed without difficulty";
        }
        return "Exceeded standard";
    }

    /*
    * A method to modify certain evaluations
    * 
    * @param evalMark  The mark that is being changed to
    * @param index  The index of the mark that is being changed
    */
    public void modifyEvaluations(char evalMark, int index) {

        // Decrement index because arrays start at 0
        index--;

        // Changing that index in evaluations array
        this.evaluations[index] = evalMark;
    }
}

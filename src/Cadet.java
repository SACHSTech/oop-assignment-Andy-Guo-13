public class Cadet extends Person{

    // Delcaring variables
    private String[] summerTraining = new String[0];
    private String role;

    // Constructor
    public Cadet(String name, String password, String rank) {
        super(name, password, rank);

        // Assigning a role for each cadet
        this.setRole("Cadet");
    }

    // Getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
}

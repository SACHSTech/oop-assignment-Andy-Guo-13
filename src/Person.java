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
        this.setEmail(Integer.toString(idNum) + "@cadetmail.com");
    }

    // Getters and setters
    public int getIdNum() {
        return idNum;
    }
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
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

}

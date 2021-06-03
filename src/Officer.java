/*
* Officer class that extends the person class. In addition to being a person, officers have a salary and a role
*
* @author: Andy Guo
*/

public class Officer extends Person {

    // Declaring variables
    private String role;
    private int salary;

    // Constructors
    public Officer(String name, String password, String rank, int salary) {
        super(name, password, rank);
        this.setSalary(salary);

        // Assigning a special role for officers
        this.setRole("Officer");
    }

    // Getters and setters

    /*
    * Returns the value of the int salary
    *
    * @return the value of salary
    */
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

}

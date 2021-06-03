/*
* Officer class that extends the person class. In addition to being a person, officers have a salary and a role
*
* @author: Andy Guo
*/

public class Officer extends Person {

    // Declaring variables
    private String role;
    private int salary;

    /*
    * Constructor - creates new instance of a Flight object
    * 
    * @param name  The name of the cadet
    * @param password  The password of this cadet
    * @param rank  The rank of the cadet
    * @param salary  The salary of the officer
    */
    public Officer(String name, String password, String rank, int salary) {
        super(name, password, rank);
        this.setSalary(salary);

        // Assigning a special role for officers
        this.setRole("Officer");
    }

    /*
    * Returns the value of the int salary
    *
    * @return the value of salary
    */
    public int getSalary() {
        return salary;
    }

    /*
    * Sets the value of salary
    * 
    * @param salary  The value that this.salary will be set to
    */
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

    /*
    * Sets the value of role
    * 
    * @param role  The value that this.role will be set to
    */
    public void setRole(String role) {
        this.role = role;
    }

}

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
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

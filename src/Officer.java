public class Officer extends Person {

    // Declaring variables
    private String role;
    private int salary;

    // Constructors
    public Officer(String name, String password, String rank, String role, int salary) {
        super(name, password, rank);
        this.setRole(role);
        this.setSalary(salary);
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

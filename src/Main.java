public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Person person = new Person("Andy Guo", "password", "WO2");
        System.out.println(person);
        System.out.println(person.getEmail());
        System.out.println(person.getPassword());
    }
}
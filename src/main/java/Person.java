public class Person {

    public final String name;
    public final int age;
    public final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Methode zur Vorstellung
    public void introduce() {
        System.out.println("Hallo, ich bin " + name + " und " + age + " Jahre alt.");
    }
}
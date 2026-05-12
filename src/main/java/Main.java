import java.util.Optional;

public class Main {
    static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        Person personA = new Person("A", "Person A", DayOfWeek.SATURDAY);
        Person personB = new Person("B", "Person B", DayOfWeek.FRIDAY);
        Person personC = new Person("C", "Person C", DayOfWeek.FRIDAY);

        personRepository.addPerson(personA);
        personRepository.addPerson(personB);
        personRepository.addPerson(personC);

        personRepository.getPersonById("O") // ID "O" doesn't exist
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Person not found!")
                );

        // Bonus
        personRepository.getPersonByName("Person D") // Name "Person D" doesn't exist
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Person not found!")
                );
    }
}

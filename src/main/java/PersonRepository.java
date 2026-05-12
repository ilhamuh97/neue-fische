import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {
    private Map<String, Person> people;

    public PersonRepository() {
        this.people = new HashMap<>();
    }

    public Map<String, Person> getPeople() {
        return people;
    }

    public void setPeople(Map<String, Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        people.put(person.ID(), person);
    }

    public Optional<Person> getPersonById(String ID) {
        return Optional.ofNullable(people.get(ID)); //Optional.of doesn't work
    }
}

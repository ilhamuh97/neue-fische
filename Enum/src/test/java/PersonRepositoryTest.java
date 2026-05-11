import enums.DaysOfWeek;
import enums.Gender;
import org.junit.jupiter.api.Test;
import records.Person;
import repositories.PersonRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;


class PersonRepositoryTest {

    @Test
    void getPeople_shouldBeEqualsPeople_whenCalledWithGetPeople() {
        // Adjust
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person(
                "1",
                "A",
                DaysOfWeek.SUNDAY,
                Gender.MALE);
        personRepository.add(person);

        // Action
        HashMap<String, Person> actualPeople = personRepository.getPeople();

        // Assert
        HashMap<String, Person> expectedPeople = new HashMap<>();
        expectedPeople.put(person.ID(), person);
        assertEquals(expectedPeople, actualPeople);
    }

    @Test
    void add_shouldBeSamePerson_whenCalledWithAddedPerson() {
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person(
                "1",
                "A",
                DaysOfWeek.SUNDAY,
                Gender.MALE);

        // Action
        personRepository.add(person);

        // Assert
        assertEquals(person, personRepository.getPeople().get(person.ID()));
    }

    @Test
    void countPeopleByGender_shouldBeSize2_whenCalledByPeopleByGenderMale() {
        PersonRepository personRepository = new PersonRepository();

        Person personA = new Person(
                "1",
                "A",
                DaysOfWeek.SUNDAY,
                Gender.MALE);
        Person personB = new Person(
                "2",
                "B",
                DaysOfWeek.SUNDAY,
                Gender.MALE);
        Person personC = new Person(
                "3",
                "C",
                DaysOfWeek.SUNDAY,
                Gender.FEMALE);

        personRepository.add(personA);
        personRepository.add(personB);
        personRepository.add(personC);

        // Action
        int getNumberOfPeopleByGender = personRepository.countPeopleByGender(Gender.MALE);

        // Assert
        assertEquals(2, getNumberOfPeopleByGender);
    }

    @Test
    void getPeopleByFavoriteDay_shouldBeSize2_whenCalledBySaturdayAsFavoriteDay() {
        PersonRepository personRepository = new PersonRepository();

        Person personA = new Person(
                "1",
                "A",
                DaysOfWeek.SATURDAY,
                Gender.MALE);
        Person personB = new Person(
                "2",
                "B",
                DaysOfWeek.SATURDAY,
                Gender.MALE);
        Person personC = new Person(
                "3",
                "C",
                DaysOfWeek.FRIDAY,
                Gender.FEMALE);

        personRepository.add(personA);
        personRepository.add(personB);
        personRepository.add(personC);

        // Action
        List<Person> peopleByFavoriteDay = personRepository.getPeopleByFavoriteDay(DaysOfWeek.SATURDAY);

        // Assert
        assertEquals(2, peopleByFavoriteDay.size());
    }
}
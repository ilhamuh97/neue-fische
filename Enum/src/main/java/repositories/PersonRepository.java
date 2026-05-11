package repositories;

import enums.DaysOfWeek;
import enums.Gender;
import records.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonRepository {
    private final HashMap<String, Person> people;

    public PersonRepository() {
        people = new HashMap<>();
    }

    public PersonRepository(HashMap<String, Person> people) {
        this.people = people;
    }

    public HashMap<String, Person> getPeople() {
        return people;
    }

    public void add(Person person) {
        Person foundPerson = this.people.get(person.ID());

        if(foundPerson == null) {
            people.put(person.ID(), person);
            return;
        }

        System.out.println("A person with this ID already exists!");
    }

    public int countPeopleByGender(Gender gender){
        int counter = 0;
        for(Person person : people.values()) {
            if(gender.equals(person.gender())) {
                counter++;
            }
        }

        return counter;
    }

    public List<Person> getPeopleByFavoriteDay(DaysOfWeek day){
        List<Person> peopleWithFavoriteDay = new ArrayList<>();
        for(Person person : people.values()) {
            if(day.equals(person.favoriteDay())) {
                peopleWithFavoriteDay.add(person);
            }
        }

        return peopleWithFavoriteDay;
    }
}

import zoo.Animal;
import zoo.Owner;
import zoo.Species;
import zoo.Zoo;

import java.util.Collection;
import java.util.HashMap;

public class Main {
    static void main(String[] args) {
        // Owners
        Owner ownerA = new Owner("Owner A", 57, "Berlin");
        Owner ownerB = new Owner("Owner B", 35, " Paris");

        // Species
        Species speciesA = new Species("Species A", 1500);
        Species speciesB = new Species("Species B", 1300);

        // Animals
        Animal elephantA = new Animal("1", "Elephant A", speciesA, 20, ownerA);
        Animal elephantB = new Animal("2", "Elephant A", speciesA, 15, ownerA);
        Animal crocodileA = new Animal("3", "Crocodile A", speciesB, 17, ownerB);
        System.out.println(elephantA);
        System.out.println(elephantB);
        System.out.println(crocodileA);
        System.out.println(elephantA.equals(elephantB));
        System.out.println();

        // Store Animals
        HashMap<String, Animal> animals = new HashMap<>();
        animals.put(elephantA.id(), elephantA);
        animals.put(elephantB.id(), elephantB);
        animals.put(crocodileA.id(), crocodileA);

        Zoo zoo = new Zoo("Zoo A", animals);
        System.out.println("Bonus");
        printTotalFoodInZoo(zoo);
    }

    public static void printTotalFoodInZoo(Zoo zoo) {
        Collection<Animal> listOfAnimalsInZoo = zoo.animals().values();

        double totalOfGrams = 0;
        for (Animal animal: listOfAnimalsInZoo) {
            totalOfGrams += animal.species().foodInGramsPerDay();
        }

        System.out.printf("Total of Grams in %s is: %s", zoo.name(), totalOfGrams);
    }
}

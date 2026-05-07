package pharmacy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Pharmacy {
    Map<String, Medication> medications;

    public Pharmacy() {
        this.medications = new HashMap<>();
    }

    public Pharmacy(Map<String, Medication> medications) {
        this.medications = medications;
    }

    public void save(Medication medication) {
        medications.put(medication.getName(), medication);
    }

    public void delete(String medicationName) {
        medications.remove(medicationName);
    }

    public Medication find(String medicationName) {
        return medications.get(medicationName);
    }

    public int getCount() {
        int totalNumber = 0;

        for (Medication medication : medications.values()) {
            totalNumber += medication.getAvailability();
        }

        return totalNumber;
    }

    public void printAllMedications() {
        for (Medication medication : medications.values()) {
            System.out.printf("%s, %s Euro, %s\n", medication.getName(), medication.getPrice(), medication.getAvailability());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(medications, pharmacy.medications);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(medications);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "medications=" + medications +
                '}';
    }
}

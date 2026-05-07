package pharmacy;

import java.util.Objects;

public class Medication {
    private final String name;
    private double price;
    private int availability;

    public Medication(String name, double price, int availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(availability, that.availability);
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", availability=" + availability +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, availability);
    }
}

import java.util.Objects;

public class Motorcycle extends Vehicle {
    private MotorcyleType type;

    public Motorcycle(String manufacturer, String model, int yearOfManufacture, MotorcyleType type) {
        super(manufacturer, model, yearOfManufacture);
        this.type = type;
    }

    public MotorcyleType getType() {
        return type;
    }

    public void setType(MotorcyleType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorcycle that = (Motorcycle) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "type='" + type + '\'' +
                '}';
    }
}

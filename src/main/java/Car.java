import java.util.Objects;

public class Car extends Vehicle {
    private final String brand;
    private final String color;
    private int speed;
    private final int MAX_SPEED = 300;
    private boolean isRunning;
    private int numberOfDoors;

    public Car(String manufacturer, String brand, String model, String color, int yearOfManufacture, int numberOfDoors) {
        super(manufacturer, model, yearOfManufacture);
        this.brand = brand;
        this.color = color;
        this.isRunning = false;
        this.numberOfDoors = numberOfDoors;
    }

    public String getBrand() {
        return brand;
    }


    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMAX_SPEED() {
        return MAX_SPEED;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void start() {
        this.speed = 0;
        this.isRunning = true;
        System.out.println("Vroom vroom!!");
    }

    public void stop() {
        this.speed = 0;
        System.out.println("Car stopped.");
    }

    public void accelerate(int amount) {
        int oldSpeed = this.speed;
        this.speed += amount;
        if(this.speed > MAX_SPEED) {
            System.out.println("Speed has reached maximum!");
            this.speed = this.MAX_SPEED;
        }
        System.out.printf("Accelerate from %s km/h to %s km/h\n", oldSpeed, speed);
    }

    public boolean isMotorRunning() {
        return isRunning;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return speed == car.speed && isRunning == car.isRunning && numberOfDoors == car.numberOfDoors && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, color, speed, MAX_SPEED, isRunning, numberOfDoors);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", MAX_SPEED=" + MAX_SPEED +
                ", isRunning=" + isRunning +
                '}';
    }
}

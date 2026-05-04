public class Main {
    static void main(String[] args) {
        Car mercedes = new Car("Mercedes Benz", "Mercedes Benz", "A Class", "Black", 2025, 5);
        Car mazda = new Car("Mazda", "Mazda", "MX-5", "Red", 2024, 2);

        mercedes.start();
        System.out.println(mercedes.isMotorRunning());
        mercedes.accelerate(150);
        mercedes.accelerate(200);
        System.out.println(mercedes);

        mazda.start();
        mazda.accelerate(150);
        System.out.println(mazda.isMotorRunning());

        mercedes.stop();
        mazda.stop();
        System.out.println(mazda.isMotorRunning());
        System.out.println(mercedes.isMotorRunning());

        System.out.println(mazda);
        System.out.println(mercedes);

        Person p1 = new Person("Eva", 25, Gender.FEMALE);
        Person p2 = new Person("Lam", 30, Gender.MALE);

        p1.introduce();
        p2.introduce();

        Vehicle vehicle = new Vehicle("VW", "S1000R", 2014);
        Car bmwCar = new Car("BMW", "BMW", "318i", "Silver", 2020, 4);
        Vehicle motorcycle = new Motorcycle("VW", "S1000R", 2014, MotorcyleType.CHOPPER);

        System.out.println(vehicle);
        System.out.println(bmwCar);
        System.out.println(motorcycle);
    }
}

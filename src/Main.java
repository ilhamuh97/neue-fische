import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main Methods here
        //runBasicExercises(scanner);
        //runMixedDataTypes(scanner);
        //runOperatorExercises();
        //runIfStatementsExercises(scanner);
        runMethodExercises();

        scanner.close();
    }

    // ================= BASIC =================
    private static void runBasicExercises(Scanner scanner) {
        System.out.println("=== Basic Exercises ===");

        System.out.println("Hello World");
        System.out.println("Hello World 2");
        System.out.println("Hello" + " World " + "2");

        int x = 5;
        System.out.println("x + 2 = " + (x + 2));
        System.out.println("x * 2 = " + (x * 2));
        System.out.println("x / 2 = " + (x / 2));

        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        System.out.println("Hi, " + name + "!");

        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.printf("%s %d%n", name, age);

        System.out.print("What is your favorite saying? ");
        String saying = scanner.nextLine();
        System.out.println("'" + saying + "', I like it too :)");

        System.out.print("Give me first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Give me second number: ");
        int num2 = scanner.nextInt();

        System.out.println("The total is: " + (num1 + num2));
        scanner.nextLine(); // cleanup
    }

    // ================= MIXED DATA TYPES =================
    private static void runMixedDataTypes(Scanner scanner) {
        System.out.println("\n=== Mixed Data Types ===");

        String name = "Ilham";
        int age = 30;
        double height = 1.73;

        System.out.println("Mein Name ist " + name + ", ich bin " + age +
                " Jahre alt und " + height + " Meter groß.");

        boolean isAdult = age >= 18;
        System.out.println(isAdult ? "You are an adult" : "You are not an adult");

        int numb = 2;
        System.out.println("sum: " + (age + numb));
        System.out.println("diff: " + (age - numb));
        System.out.println("prod: " + (age * numb));
        System.out.println("quot: " + ((double) age / numb));

        String text = "Hello World!";
        System.out.println("Length: " + text.length());
        System.out.println("First char: " + text.charAt(0));
        System.out.println("Upper Case: " + text.toUpperCase());

        System.out.print("Give me a letter: ");
        String letter = scanner.nextLine().toLowerCase();

        if ("aeiou".contains(letter)) {
            System.out.println("The given letter is a vowel");
        } else {
            System.out.println("The given letter is not a vowel");
        }
    }

    // ================= OPERATORS =================
    private static void runOperatorExercises() {
        System.out.println("\n=== Operator Exercises ===");

        int a = 10;
        int b = 20;

        System.out.println("Sum: " + (a + b));

        if (a == b) {
            System.out.println("Gleich");
        } else {
            System.out.println("Ungleich");
        }

        boolean isBetween = a > 0 && a < 100;
        System.out.println("a between 0 and 100: " + isBetween);

        int remainder = b % a;
        System.out.println("Remainder: " + remainder);

        if(remainder == 0) {
            System.out.println("Rest beträgt 0");
        } else {
            System.out.println("Rest beträgt nicht 0");
        }

        int number = 10;
        int divisor = 5;

        if (number % divisor == 0 && number > 0) {
            System.out.println("The number is divisible and positive.");
        } else {
            System.out.println("Condition not satisfied.");
        }

        double price = 2.00;
        boolean rabatt = true;
        if(rabatt) {
            System.out.println(price * 0.1);
        } else {
            System.out.println(price);
        }
    }

    // ================= IF STATEMENTS =================
    private static void runIfStatementsExercises(Scanner scanner) {
        int score = 12;
        boolean hasTicket = true;
        boolean isVerified = score>= 50 && hasTicket;
        if(isVerified) {
            System.out.println("You can enter!");
        } else {
            System.out.println("You cannot enter!");
        }

        int temperature = 30;
        if(temperature>=10) {
            System.out.println("Kuhl");
        } else if(temperature>=20) {
            System.out.println("Warm");
        } else if (temperature>=30) {
            System.out.println("Heiß");
        } else {
            System.out.println("Kalt");
        }

        int number = 3;
        boolean isEven = number%2 == 0 ? true : false;
        if(isEven) {
            System.out.println("The number is even!");
        } else {
            System.out.println("The number is odd!");
        }

        double x = 0.1 + 0.2;
        double epsilon =0.3;
        if (x < epsilon) {
            System.out.println("Fast 0.3");
        } else {
            System.out.println("Nicht gleich 0.3");
        }

        register("Ilham", 20);

        System.out.println("Enter your name!");
        String name = scanner.nextLine().trim();
        if(name.isEmpty()) {
            System.out.println("Name is not valid!");
        } else {
            System.out.printf("Hi, %s%n", name);
        }
    }
    private static void register(String username, int age) {
        if(username.trim().isEmpty() || age<18) {
            return;
        }

        System.out.println("Registrierung erfolgreich");
    }

    // ================= METHOD =================
    private static void runMethodExercises() {
        double width = 500;
        double height = 200;
        double area = calculateArea(500, 200);
        System.out.printf("The area with width %s and heigh %s is %s\n", width, height, area);

        int a = 200;
        int b = 0;
        System.out.printf("The first number is %s and the second is %s \n", a, b);

        int sum = add(a, b);
        System.out.printf("The sum is %s\n", sum);

        int subtract = subtract(a, b);
        System.out.printf("The subtract is %s\n", subtract);

        int multiply = multiply(a, b);
        System.out.printf("The multiply is %s\n", multiply);

        double divide = divide(a, b);
        System.out.printf("The divide is %s\n", divide);

    }
    private static double calculateArea(double width, double height) {
        return width * height;
    }
    private static int add(int a, int b) {
        return a + b;
    }
    private static int subtract(int a, int b) {
        return a - b;
    }
    private static int multiply(int a, int b) {
        return a * b;
    }
    private static double divide(double a, double b) {
        if(b == 0) {
            System.out.println("Division durch 0 ist nicht erlaubt!");
            return 0;
        }
        return a / b;
    }
}
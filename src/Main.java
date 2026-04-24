void main() {
    Scanner scanner = new Scanner(System.in);

    // Main Methods here
    runBasicExercises(scanner);
    runMixedDataTypes(scanner);
    runOperatorExercises();
    runIfStatementsExercises(scanner);
    runMethodExercises();

    scanner.close();
}

// ================= BASIC =================
private static void runBasicExercises(Scanner scanner) {
    IO.println("=== Basic Exercises ===");

    IO.println("Hello World");
    IO.println("Hello World 2");
    IO.println("Hello" + " World " + "2");

    int x = 5;
    IO.println("x + 2 = " + (x + 2));
    IO.println("x * 2 = " + (x * 2));
    IO.println("x / 2 = " + (x / 2));

    IO.print("What's your name? ");
    String name = scanner.nextLine();
    IO.println("Hi, " + name + "!");

    IO.print("How old are you? ");
    int age = scanner.nextInt();
    scanner.nextLine(); // consume newline

    System.out.printf("%s %d%n", name, age);

    IO.print("What is your favorite saying? ");
    String saying = scanner.nextLine();
    IO.println("'" + saying + "', I like it too :)");

    IO.print("Give me first number: ");
    int num1 = scanner.nextInt();

    IO.print("Give me second number: ");
    int num2 = scanner.nextInt();

    IO.println("The total is: " + (num1 + num2));
    scanner.nextLine(); // cleanup
}

// ================= MIXED DATA TYPES =================
private static void runMixedDataTypes(Scanner scanner) {
    IO.println("\n=== Mixed Data Types ===");

    String name = "Ilham";
    int age = 30;
    double height = 1.73;

    IO.println("Mein Name ist " + name + ", ich bin " + age +
            " Jahre alt und " + height + " Meter groß.");

    boolean isAdult = age >= 18;
    IO.println(isAdult ? "You are an adult" : "You are not an adult");

    int numb = 2;
    IO.println("sum: " + (age + numb));
    IO.println("diff: " + (age - numb));
    IO.println("prod: " + (age * numb));
    IO.println("quot: " + ((double) age / numb));

    String text = "Hello World!";
    IO.println("Length: " + text.length());
    IO.println("First char: " + text.charAt(0));
    IO.println("Upper Case: " + text.toUpperCase());

    IO.print("Give me a letter: ");
    String letter = scanner.nextLine().toLowerCase();

    if ("aeiou".contains(letter)) {
        IO.println("The given letter is a vowel");
    } else {
        IO.println("The given letter is not a vowel");
    }
}

// ================= OPERATORS =================
private static void runOperatorExercises() {
    IO.println("\n=== Operator Exercises ===");

    int a = 10;
    int b = 20;

    IO.println("Sum: " + (a + b));

    if (a == b) {
        IO.println("Gleich");
    } else {
        IO.println("Ungleich");
    }

    boolean isBetween = a > 0 && a < 100;
    IO.println("a between 0 and 100: " + isBetween);

    int remainder = b % a;
    IO.println("Remainder: " + remainder);

    if (remainder == 0) {
        IO.println("Rest beträgt 0");
    } else {
        IO.println("Rest beträgt nicht 0");
    }

    int number = 10;
    int divisor = 5;

    if (number % divisor == 0 && number > 0) {
        IO.println("The number is divisible and positive.");
    } else {
        IO.println("Condition not satisfied.");
    }

    double price = 2.00;
    boolean rabatt = true;
    if (rabatt) {
        IO.println(price * 0.1);
    } else {
        IO.println(price);
    }
}

// ================= IF STATEMENTS =================
private static void runIfStatementsExercises(Scanner scanner) {
    int score = 12;
    boolean hasTicket = true;
    boolean isVerified = score >= 50 && hasTicket;
    if (isVerified) {
        IO.println("You can enter!");
    } else {
        IO.println("You cannot enter!");
    }

    int temperature = 30;
    if (temperature >= 10) {
        IO.println("Kuhl");
    } else if (temperature >= 20) {
        IO.println("Warm");
    } else if (temperature >= 30) {
        IO.println("Heiß");
    } else {
        IO.println("Kalt");
    }

    int number = 3;
    boolean isEven = number % 2 == 0 ? true : false;
    if (isEven) {
        IO.println("The number is even!");
    } else {
        IO.println("The number is odd!");
    }

    double x = 0.1 + 0.2;
    double epsilon = 0.3;
    if (x < epsilon) {
        IO.println("Fast 0.3");
    } else {
        IO.println("Nicht gleich 0.3");
    }

    register("Ilham", 20);

    IO.println("Enter your name!");
    String name = scanner.nextLine().trim();
    if (name.isEmpty()) {
        IO.println("Name is not valid!");
    } else {
        System.out.printf("Hi, %s%n", name);
    }
}

private static void register(String username, int age) {
    if (username.trim().isEmpty() || age < 18) {
        return;
    }

    IO.println("Registrierung erfolgreich");
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
    if (b == 0) {
        IO.println("Division durch 0 ist nicht erlaubt!");
        return 0;
    }
    return a / b;
}
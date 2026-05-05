import calculator.Calculator;

public class Main {
    static void main(String[] args) {
        StaticFinal sf1 = new StaticFinal();
        StaticFinal sf2 = new StaticFinal();
        StaticFinal sf3 = new StaticFinal();
        StaticFinal sf4 = new StaticFinal();

        sf1.incrementInstanceCount();
        sf2.incrementInstanceCount();
        sf3.incrementInstanceCount();
        sf4.incrementInstanceCount();

        // CALL STATIC METHODS THROUGH INSTANCE (OBJECT) REFERENCE (not recommended)
        sf1.incrementTotalCount();
        sf2.incrementTotalCount();
        sf3.incrementTotalCount();
        sf4.incrementTotalCount();

        // CALL STATIC METHOD THROUGH CLASS REFERENCE
        StaticFinal.incrementTotalCount();

        System.out.println(sf1);
        System.out.println(sf2);
        System.out.println(sf3);
        System.out.println(sf4);
        System.out.println();

        // BONUS AUFGABEN
        int a = 1;
        int b = 3;
        int add = Calculator.add(a, b);
        int subtract = Calculator.subtract(a, b);
        double divide = Calculator.divide(a, b);
        int multiply = Calculator.multiply(a, b);

        System.out.printf("CALCULATOR RESULTS BETWEEN %s and %s%n", a, b);
        System.out.println("Addition: " + add);
        System.out.println("Subtraction" + subtract);
        System.out.println("Division: " + divide);
        System.out.println("Multiplication: " + multiply);
    }
}

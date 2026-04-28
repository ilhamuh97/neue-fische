import org.jetbrains.annotations.NotNull;

public class Main {
    static void main() {

    }

    public static boolean isEven(int num){
        return num % 2 == 0;
    }

    public static boolean isEvenTDD(int num) {
        return num % 2 == 0;
    }

    public static int sum(int num_a, int num_b) {
        return num_a + num_b;
    }

    public static double add(double num_a, double num_b){
        if (Double.isNaN(num_a) || Double.isNaN(num_b)) {
            throw new IllegalArgumentException("Inputs must be valid numbers");
        }
        return num_a + num_b;
    }

    public static boolean isPositive(int num) {
       return num >= 0;
    }

    public static int multiply(int num_a, int num_b) {
        return num_a * num_b;
    }

    public static String getFirstLetter(@NotNull String text) {
        if(text.isEmpty()) {
            return null;
        }
        return text.trim().substring(0, 1);
    }

    public static String getFirstLetterTDD(@NotNull String text) {
        if(text.isEmpty()) {
            return null;
        }

        return text.trim().substring(0,1);
    }

    public static double divide(int num_a, int num_b){
        if(num_b == 0) {
            throw new IllegalArgumentException("Cannot divided by 0");
        }
        return (double) num_a /num_b;
    }

    public static String reverseString(@NotNull String text) {
        if(text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder(text).reverse();
        return result.toString();
    }

    public static boolean isPalindrome(String text) {
        String result = new StringBuilder(text)
                .reverse()
                .toString()
                .toLowerCase();

        return text.equalsIgnoreCase(result);
    }

    public static int countVowels(@NotNull String text) {
        if(text.isEmpty()) {
            return 0;
        }

        String vowels = "aiueo";
        int counter = 0;
        for(String letter: text.split("")) {
            if(vowels.contains(letter)) {
                counter++;
            }
        }

        return counter;
    }

    public static int factorial(int num) {
        int result = 1;
        if(num == 0) {
            return result;
        }

        for (int i = 1; i<=num; i++){
            result *= i;
        }

        return result;
    }

    public static int fibonacci(int num) {
        if(num == 0) {
            return 0;
        }

        if(num == 1) {
            return 1;
        }

        int result = 0;
        int lastNumber = 1;
        int lastSecondNumber = 0;
        for(int i = 2; i<=num; i++) {
            // Order is Matter!
            result = lastNumber + lastSecondNumber;
            lastSecondNumber = lastNumber;
            lastNumber = result;
        }

        return result;
    }

    public static int[] mergeArrays(int[] array_a, int[] array_b) {
        int totalLength = array_a.length + array_b.length;
        int[] result = new int[totalLength];

        for(int i = 0; i<totalLength; i++) {
            if(i<array_a.length) {
                result[i] = array_a[i];
            } else {
                result[i] = array_b[i-array_a.length];
            }
        }

        return result;
    }
    /* TODO: isPrime */
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isEven_shouldReturnTrue_whenCalledWithEvenNumber(){
        assertTrue(Main.isEven(2));
    }

    @Test
    void isEven_shouldReturnFalse_whenCalledWithOddNumber(){
        assertFalse(Main.isEven(3));
    }

    @Test
    void add_shouldReturn5_whenCalledWith2and3(){
        assertEquals(5, Main.add(2, 3));
    }

    @Test
    void add_shouldReturnThrow_whenCalledWithNaN() {
        assertThrows(IllegalArgumentException.class, () -> Main.add(Double.NaN, 5.0));
    }

    @Test
    void isPositive_shouldReturnTrue_whenCalledWithPositiveNumber() {
        assertTrue(Main.isPositive(1));
    }

    @Test
    void isPositive_shouldReturnFalse_whenCalledWithNegativeNumber() {
        assertFalse(Main.isPositive(-2));
    }

    @Test
    void multiply_shouldReturn16_whenCalledWith2and8() {
        assertEquals(16, Main.multiply(2, 8));
    }

    @Test
    void multiply_shouldReturn8_whenCalledWith2and4() {
        assertEquals(8, Main.multiply(2, 4));
    }

    @Test
    void getFirstLetter_shouldReturnNull_whenCalledWithEmptyString() {
        assertNull(Main.getFirstLetter(""));
    }

    @Test
    void getFirstLetter_shouldReturnNotNull_whenCalledWithUnemptyString() {
        assertNotNull(Main.getFirstLetter("test"));
    }

    @Test
    void getFirstLetter_shouldReturnH_whenCalledWithHelloWorld() {
        assertEquals("H", Main.getFirstLetter("Hello World"));
    }

    @Test
    void divide_shouldReturn2_whenCalledWith4and2() {
        assertEquals(2, Main.divide(4, 2));
    }

    @Test
    void divide_shouldReturnThrow_whenCalledWith4and0() {
        assertThrows(IllegalArgumentException.class, () -> Main.divide(4, 0));
    }

    @Test
    void sum_shouldReturn3_whenCalledWith1and2() {
        assertEquals(3, Main.sum(1,2));
    }

    @Test
    void isEvenTDD_shouldReturnTrue_whenCalledWith2() {
        assertTrue(Main.isEvenTDD(2));
    }

    @Test
    void isEvenTDD_shouldReturnFalse_whenCalledWith3() {
        assertFalse(Main.isEvenTDD(3));
    }

    @Test
    void getFirstLetterTDD_shouldReturnH_whenCalledWithHallo() {
        assertEquals("H", Main.getFirstLetterTDD("Hallo"));
    }

    @Test
    void getFirstLetterTDD_shouldReturnNull_whenCalledWithEmptyString() {
        assertNull(Main.getFirstLetterTDD(""));
    }

    @ParameterizedTest
    @CsvSource({
            "Hallo, ollaH",
            "Java, avaJ",
    })
    void reverseString_shouldReturnReversedText_whenCalledWithText(String text, String expected) {
        assertEquals(expected, Main.reverseString(text));
    }

    @Test
    void reverseString_shouldReturnEmptyString_whenCalledWithEmptyString() {
        assertEquals("", Main.reverseString(""));
    }

    @ParameterizedTest
    @CsvSource({
            "Otto, true",
            "MaDAm, true",
            "1221, true",
    })
    void isPalindrome_shouldReturnTrue_whenCalledWithPalindromeText(String text, boolean expected) {
        assertTrue(Main.isPalindrome(text));
    }

    @ParameterizedTest
    @CsvSource({
            "Java, false",
            "Hallo, false",
    })
    void isPalindrome_shouldReturnFalse_whenCalledWithNonPalindromeText(String text, boolean expected) {
        assertFalse(Main.isPalindrome(text));
    }

    @ParameterizedTest
    @CsvSource({
            "Hallo, 2",
            "World, 1",
            "Java, 2",
    })
    void countVowels_shouldReturnNumberOfVowels_whenCalledWithText(String text, int expected) {
        assertEquals(expected, Main.countVowels(text));
    }

    @Test
    void countVowels_shouldReturnZero_whenCalledEmptyString() {
        assertEquals(0, Main.countVowels(""));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "0, 1",
            "5, 120",
            "3, 6",
            "6, 720",
    })
    void factorial_shouldReturnFactorial_whenCalledWithNumber(int number, int expected) {
        assertEquals(expected, Main.factorial(number));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "6, 8",
    })
    void fibonacci_shouldReturnFibonacci_whenCalledWithNTenFibonacci(int number, int expected) {
        assertEquals(expected, Main.fibonacci(number));
    }

    @Test
    void mergeArray_shouldReturnMergedArrays_whenCalledWithTwoArrays() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Main.mergeArrays(new int[]{1, 2, 3}, new int[]{4, 5}));
    }
}
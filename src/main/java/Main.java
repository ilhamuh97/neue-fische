import records.Student;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args) {
        List<Integer> numbers = Stream.of(5, 2, 8, 1, 4, 7, 6, 3, 10, 9)
                .peek(System.out::println)
                .filter(n -> n%2 == 0)
                .peek(System.out::println)
                .map(number -> number*2)
                .peek(System.out::println)
                .sorted()
                .toList();

        System.out.println("Processed numbers:");
        numbers.forEach(System.out::println);

        int total = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Total: " + total);


        // ===== BONUS ======
        try (Stream<String> lines = Files.lines(Path.of("src/main/resources/students.csv"))) {
            List<Student> students = lines
                    .skip(1)
                    .peek(System.out::println)
                    .filter(line -> !line.isEmpty())
                    .map(studentString -> studentString.split(","))
                    .map(studentData -> new Student(
                            studentData[0],
                            studentData[1],
                            studentData[2],
                            Integer.parseInt(studentData[3])
                    ))
                    .toList();

            System.out.println(students);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}

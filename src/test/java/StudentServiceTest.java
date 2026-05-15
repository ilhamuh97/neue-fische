import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void shouldFindStudentById() throws StudentNotFoundException {
        // GIVEN
        StudentRecord student1 = new StudentRecord("1", "Max");
        StudentRecord student2 = new StudentRecord("2", "Anna");

        StudentService service = new StudentService(List.of(student1, student2));

        // WHEN
        StudentRecord result = service.findById("1");

        // THEN
        assertEquals(student1, result);
    }

    @Test
    void shouldThrowExceptionWhenStudentDoesNotExist() {

        // GIVEN
        StudentService service = new StudentService(List.of());

        // WHEN + THEN
        assertThrows(
                StudentNotFoundException.class,
                () -> service.findById("999")
        );
    }
}
import java.util.List;

public class StudentService {
    private final List<StudentRecord> students;

    public StudentService(List<StudentRecord> students) {
        this.students = students;
    }

    public StudentRecord findById(String id) throws StudentNotFoundException {

        return students.stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException("Student with id " + id + " not found"));
    }
}

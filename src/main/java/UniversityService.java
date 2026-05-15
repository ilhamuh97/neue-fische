import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class UniversityService {
    Map<String, University> universities;

    public double calculateCourseAverage(Course course) {
        return course.getStudents()
                .values()
                .stream()
                .map(Student::getGrade)
                .mapToDouble(d -> d)// only map doesnt work
                .average()
                .orElse(0.0);
    }

    public double calculateUniversityAverage(String universityID) {
        return this.universities.get(universityID)
                .courses()
                .values()
                .stream()
                .flatMap(course -> course
                        .getStudents()
                        .values()
                        .stream()
                )
                .peek(System.out::println) // Print Courses
                .mapToDouble(Student::getGrade)
                .peek(System.out::println) // Print Grade
                .average()
                .orElse(0.0);
    }
}

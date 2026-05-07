import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String StudentId;
    private final List<Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        StudentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return StudentId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course courseToAdd) {
        courses.add(courseToAdd);
    }

    public void addCoursesPack(List<Course> coursesToAdd) {
        courses.addAll(coursesToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(StudentId, student.StudentId) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, StudentId, courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", courses=" + courses +
                '}';
    }
}

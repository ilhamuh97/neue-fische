import java.util.ArrayList;
import java.util.List;

public class School {
    List<Student> students = new ArrayList<>();

    public School() {
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudents(List<Student> studentsToAdd) {
        students.addAll(studentsToAdd);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printStudents() {
        for(Student student: students) {
            System.out.printf("%s %s with id: %s\n", student.getFirstName(), student.getLastName(), student.getStudentId());
        }
    }

    public Student getStudentWithId(String studentId) {
        for(Student student: students) {
            if(student.getStudentId().equals(studentId)){
                return student;
            }
        }

        return null;
    }

    public void printCourseOfStudentById(String studentId) {
        for(Student student: students) {
            if(student.getStudentId().equals(studentId)){
                System.out.println(student.getCourses());
                break;
            }
        }

    }
}

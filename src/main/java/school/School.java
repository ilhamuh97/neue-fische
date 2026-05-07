package school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {
    Map<String, Student> students = new HashMap<>();

    public School() {
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public void addStudents(List<Student> studentsToAdd) {
        for(Student studentToAdd: studentsToAdd) {
            students.put(studentToAdd.getStudentId(), studentToAdd);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student.getStudentId());
    }

    public void printStudents() {
        students.forEach((studentId, student) -> {
            System.out.printf("%s %s with id: %s\n", student.getFirstName(), student.getLastName(), studentId);
        });
    }

    public Student getStudentWithId(String studentId) {
        return students.get(studentId);
    }

    public void printCourseOfStudentById(String studentId) {
        System.out.println(students.get(studentId).getCourses());
    }
}
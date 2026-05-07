import pharmacy.Medication;
import pharmacy.Pharmacy;
import school.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        schoolExercise();
        pharmacyExercise();
    }

    public static void schoolExercise() {
        System.out.println("School Exercise");
        List<Student> students = new ArrayList<>();

        Student studentA = new Student("vornameA", "nachnameA", "1A");
        Student studentB = new Student("vornameB", "nachnameB", "2B");
        Student studentC = new Student("vornameC", "nachnameC", "3C");
        Student studentD = new Student("vornameD", "nachnameD", "4D");

        students.add(studentA);
        students.add(studentB);
        students.add(studentC);
        students.add(studentD);

        School schoolA = new School();

        schoolA.addStudents(students);
        schoolA.printStudents();
        System.out.println();

        System.out.println(schoolA.getStudentWithId("1A"));
        System.out.println(schoolA.getStudentWithId("4D"));
        System.out.println(schoolA.getStudentWithId("5E"));
        System.out.println();

        schoolA.removeStudent(studentD);
        schoolA.printStudents();
        System.out.println();

        // BONUS COURSE!
        System.out.println("BONUS AUFGABEN COURSE!");
        List<Course> coursesPackA = new ArrayList<>();
        Course math = new Course("Mathematics", "Lecturer A", "room A");
        Course bio = new Course("Biology", "Lecturer B", "room B");
        Course chem = new Course("Chemistry", "Lecturer C", "room C");
        Course econ = new Course("Economics", "Lecturer D ", "room D");
        coursesPackA.add(math);
        coursesPackA.add(bio);
        coursesPackA.add(chem);

        studentA.addCoursesPack(coursesPackA);
        System.out.println(studentA);
        System.out.println();

        studentB.addCourse(econ);
        studentB.addCoursesPack(coursesPackA);
        System.out.println(studentB);
        System.out.println();

        schoolA.printCourseOfStudentById(studentB.getStudentId());
        System.out.println();
    }

    public static void pharmacyExercise() {
        Medication m1 = new Medication("m1", 10.0, 100);
        Medication m2 = new Medication("m2", 5.0, 150);
        Medication m3 = new Medication("m3", 7.50, 200);
        Medication m4 = new Medication("m4", 5.0, 200);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);

        Pharmacy p1 = new Pharmacy();

        p1.save(m1);
        p1.save(m2);
        p1.save(m3);
        p1.save(m4);
        p1.printAllMedications();
        System.out.println();

        int totalNumber = p1.getCount();
        System.out.println(totalNumber);
        System.out.println();

        p1.delete(m2.getName());
        p1.printAllMedications();
        System.out.println();

        System.out.println(p1.find(m1.getName()));
    }
}
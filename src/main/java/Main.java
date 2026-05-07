import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
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

        // BONUS!
        System.out.println("BONUS AUFGABEN BAG!");
        Bag bag1 = new Bag();

        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        System.out.println(bag1);
        System.out.println();

        Bag bag2 = new Bag(new int[]{1, 2, 3, 4});
        bag2.add(5);
        System.out.println(bag2);
        System.out.println();

        bag2.removeLast();
        System.out.println(bag2);
        System.out.println(bag2.get(bag2.size()-1));
        System.out.println();

        bag2.remove(2);
        System.out.println(bag2);
    }
}

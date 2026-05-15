import java.util.HashMap;

public class Main {
    static void main(String[] args) {
        Student s1 = new Student("1s", "Student One", "Address. 1", "VI");
        Student s2 = new Student("2s", "Student Two", "Address. 2", "VI");
        Student s3 = new Student("3s", "Student Three", "Address. 3", "VII");
        Student s4 = new Student("4s", "Student Four", "Address. 4", "VII");

        Teacher t1 = new Teacher("1t", "Teacher One", "Subject One");
        Teacher t2 = new Teacher("2t", "Teacher Two", "Subject Two");

        Course c1 = new Course("1c", "Course One", t1, new HashMap<>());
        Course c2 = new Course("2c", "Course Two", t2, new HashMap<>());

        c1.getStudent().put(s1.getName(), s1);
        c1.getStudent().put(s2.getName(), s2);

        c2.getStudent().put(s3.getName(), s3);
        c2.getStudent().put(s4.getName(), s4);

        System.out.println(c1);
        System.out.println(c2);
    }
}

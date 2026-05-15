import java.util.HashMap;

public class Main {
    static void main(String[] args) {
        Student s1 = new Student("1s", "Student One", "Address. 1", 5.0);
        Student s2 = new Student("2s", "Student Two", "Address. 2", 7.2);
        Student s3 = new Student("3s", "Student Three", "Address. 3", 7.5);
        Student s4 = new Student("4s", "Student Four", "Address. 4", 8.3);
        Student s5 = Student.builder()
                .ID("5s")
                .name("Student Five")
                .address("Address. 5")
                .grade(8.5)
                .build();

        Teacher t1 = new Teacher("1t", "Teacher One", "Subject One");
        Teacher t2 = new Teacher("2t", "Teacher Two", "Subject Two");

        Course c1 = new Course("1c", "Course One", t1, new HashMap<>());
        Course c2 = new Course("2c", "Course Two", t2, new HashMap<>());

        c1.getStudents().put(s1.getName(), s1);
        c1.getStudents().put(s2.getName(), s2);
        System.out.println("C1: " + c1);
        System.out.println();

        s1 = s1.withGrade(8.8); // Update Grade
        s2.setGrade(9.0);  // Update Grade
        c2.getStudents().put(s1.getName(), s1);
        c2.getStudents().put(s2.getName(), s2);
        c2.getStudents().put(s3.getName(), s3);
        c2.getStudents().put(s4.getName(), s4);
        c2.getStudents().put(s5.getName(), s5);

        System.out.println("OLD C2: " + c2);
        c2 = c2.withName("New Course Two");
        System.out.println("NEW C2: " + c2);
        System.out.println();

        University university = new University("1u", "University", new HashMap<>());

        university.courses().put(c1.getID(), c1);
        university.courses().put(c2.getID(), c2);

        university = university.withName("New University");

        UniversityService universityService = new UniversityService(new HashMap<>());

        universityService.universities.put(university.ID(), university);

        System.out.println("Average c1: " + universityService.calculateCourseAverage(c1));
        System.out.println("Average c2: " + universityService.calculateCourseAverage(c2));
        System.out.println();

        System.out.println("Average University: " + universityService.calculateUniversityAverage(university.ID()));

    }
}

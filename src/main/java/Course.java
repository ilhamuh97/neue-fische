import java.util.Objects;

public class Course {
    private String courseName;
    private String lecturer;
    private String room;

    public Course(String courseName, String lecturer, String room) {
        this.courseName = courseName;
        this.lecturer = lecturer;
        this.room = room;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) && Objects.equals(lecturer, course.lecturer) && Objects.equals(room, course.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, lecturer, room);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}

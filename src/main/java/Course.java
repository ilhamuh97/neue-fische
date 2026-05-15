import lombok.*;

import java.util.Map;

@Data
@Value
@With
public class Course {
    String ID;
    String Name;
    Teacher teacher;
    Map<String, Student> students;
}

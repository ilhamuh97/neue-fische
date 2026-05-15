import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Course {
    private final String ID;
    private String Name;
    private Teacher teacher;
    private Map<String, Student> student;
}

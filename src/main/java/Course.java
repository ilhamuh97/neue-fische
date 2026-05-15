import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.util.Map;

@Data
@Builder
public class Course {
    @With private final String ID;
    @With private String Name;
    @With private Teacher teacher;
    @With private Map<String, Student> student;
}

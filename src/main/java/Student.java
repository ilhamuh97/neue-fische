import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data // Erzeugt Getter, Setter, equals(), hashCode() und toString()
@Builder
public class Student {
    private final String ID;
    private String name;
    private String address;
    private String grade;
}
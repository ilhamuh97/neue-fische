import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
public class Student {
    private String ID;
    private String name;
    private String address;
    @With private double grade;
}
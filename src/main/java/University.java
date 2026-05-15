import lombok.With;

import java.util.HashMap;

@With
public record University(String ID, String name, HashMap<String, Course> courses) {

}

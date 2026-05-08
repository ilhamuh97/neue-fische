package zoo;

import java.util.HashMap;

public record Zoo(String name, HashMap<String, Animal> animals) {
}

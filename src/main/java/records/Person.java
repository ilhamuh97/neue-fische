package records;

import enums.DaysOfWeek;
import enums.Gender;

public record Person(String ID, String name, DaysOfWeek favoriteDay, Gender gender) {
}

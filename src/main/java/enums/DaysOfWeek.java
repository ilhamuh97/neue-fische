package enums;

public enum DaysOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String label;

    DaysOfWeek(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDayOrWeekend() {
        if (this == SATURDAY || this == SUNDAY) {
            return "Weekend";
        }

        return label;
    }
}

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

record Animal(String name, LocalDate birthDay) {

    public long daysUntilNextBirthDay() {
        LocalDate now = LocalDate.now();
        LocalDate nextBirthDay = getNextBirthDay(now);

        return ChronoUnit.DAYS.between(now, nextBirthDay);
    }

    private LocalDate getNextBirthDay(LocalDate now) {
        LocalDate nextBirthDay = LocalDate.of(
                now.getYear(),
                birthDay.getMonth(),
                birthDay.getDayOfMonth()
        );
        if (nextBirthDay.isBefore(now) || nextBirthDay.equals(now)) {
            nextBirthDay = nextBirthDay.plusYears(1);
        }

        return nextBirthDay;
    }
}
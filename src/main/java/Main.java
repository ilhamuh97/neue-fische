import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDateTime jetzt = LocalDateTime.now();
        System.out.println("Aktuelles Datum und Uhrzeit:");
        System.out.println(jetzt);
        System.out.println();

        LocalDate aktuellesDatum = LocalDate.now();
        LocalDate neuesDatum = aktuellesDatum.plusWeeks(2);
        System.out.println("Aktuelles Datum:");
        System.out.println(aktuellesDatum);

        System.out.println("Datum in 2 Wochen:");
        System.out.println(neuesDatum);
        System.out.println();

        LocalDate zukunftsDatum = LocalDate.of(2026, 12, 31);
        System.out.println("Datumsvergleich:");

        if (aktuellesDatum.isBefore(zukunftsDatum)) {
            System.out.println("Das aktuelle Datum liegt VOR dem Zukunftsdatum.");
        } else if (aktuellesDatum.isAfter(zukunftsDatum)) {
            System.out.println("Das aktuelle Datum liegt NACH dem Zukunftsdatum.");
        } else {
            System.out.println("Beide Daten sind gleich.");
        }
        System.out.println();

        LocalDate datum1 = LocalDate.of(2026, 1, 1);
        LocalDate datum2 = LocalDate.of(2026, 2, 15);

        long tageDifferenz = ChronoUnit.DAYS.between(datum1, datum2);
        System.out.println("Differenz zwischen zwei Daten:");
        System.out.println("Datum 1: " + datum1);
        System.out.println("Datum 2: " + datum2);
        System.out.println("Differenz in Tagen: " + tageDifferenz);

        // BONUS
        Animal tier = new Animal(
                "Luna",
                LocalDate.of(2020, 8, 15)
        );

        System.out.println("Name des Tieres: " + tier.name());
        System.out.println("Geburtstag: " + tier.birthDay());

        long tage = tier.daysUntilNextBirthDay();

        System.out.println(
                "Tage bis zum nächsten Geburtstag: " + tage
        );
    }
}
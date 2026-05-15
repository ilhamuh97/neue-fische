import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GuestList {

    private final Path path = Path.of("guests.txt");

    public void setGuests(List<String> guests) throws IOException {
        Files.write(path, guests);
    }

    public List<String> getGuests() throws IOException {
        return Files.readAllLines(path);
    }

    public void addGuest(String guest) throws IOException {
        Files.writeString(
                path,
                guest + System.lineSeparator(),
                java.nio.file.StandardOpenOption.CREATE,
                java.nio.file.StandardOpenOption.APPEND
        );
    }
}

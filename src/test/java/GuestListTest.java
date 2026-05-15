import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GuestListTest {

    private final Path path = Path.of("guests.txt");

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(path);
    }

    @Test
    void shouldBeEmptyInitially() throws IOException {
        // GIVEN
        GuestList guestList = new GuestList();

        // WHEN
        guestList.setGuests(List.of());
        List<String> result = guestList.getGuests();

        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReadSameGuestsAsWrittenBefore() throws IOException {
        // GIVEN
        GuestList guestList = new GuestList();

        // WHEN
        guestList.setGuests(List.of("Karl", "Ute"));
        List<String> result = guestList.getGuests();

        // THEN
        assertEquals(List.of("Karl", "Ute"), result);
    }

    @Test
    void shouldWriteToFileSystem() throws IOException {
        // GIVEN
        GuestList guestList = new GuestList();

        // WHEN
        guestList.setGuests(List.of("Theodor", "Anette"));
        List<String> lines = Files.readAllLines(path);

        // THEN
        assertTrue(Files.exists(path));
        assertEquals(List.of("Theodor", "Anette"), lines);
    }

    @Test
    void shouldReadFromFileSystem() throws IOException {
        // GIVEN
        Files.write(path, List.of("Stephan", "Max"));
        GuestList guestList = new GuestList();

        // WHEN
        List<String> result = guestList.getGuests();

        // THEN
        assertEquals(List.of("Stephan", "Max"), result);
    }

    @Test
    void shouldThrowExceptionWhenFileDoesNotExist() {
        // GIVEN
        GuestList guestList = new GuestList();

        // WHEN & THEN
        assertThrows(IOException.class, guestList::getGuests);
    }

    @Test
    void shouldAddGuest() throws IOException {

        // GIVEN
        GuestList guestList = new GuestList();
        guestList.setGuests(List.of("Karl"));

        // WHEN
        guestList.addGuest("Ute");

        // THEN
        List<String> result = guestList.getGuests();
        assertEquals(List.of("Karl", "Ute"), result);
    }
}
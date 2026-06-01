package de.neuefische.springexceptionhandlingtask;

import de.neuefische.springexceptionhandlingtask.records.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GetMapping("{species}")
    String getAnimalSpecies(@PathVariable String species) {
        if (!species.equals("dog")) {
            throw new IllegalArgumentException("Only 'dog' is allowed");
        }
        return species;
    }

    @GetMapping
    String getAllAnimals() {
        throw new NoSuchElementException("No Animals found");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorMessage handleRuntimeException(IllegalArgumentException e, WebRequest request) {
        return  ErrorMessage
                .builder()
                .apiPath(request.getDescription(false))
                .httpStatus(HttpStatus.BAD_GATEWAY)
                .errorMessage(e.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }
}

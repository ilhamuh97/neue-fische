package de.neuefische.springexceptionhandlingtask;

import de.neuefische.springexceptionhandlingtask.records.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping("{brand}")
    String getCarBrand(@PathVariable String brand) {
        if (!brand.equals("porsche")) {
            throw new IllegalArgumentException("Only 'porsche' allowed");
        }
        return brand;
    }

    @GetMapping
    String getAllCars() {
        throw new NoSuchElementException("No Cars found");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorMessage handleRuntimeException(IllegalArgumentException e, WebRequest request) {
        return ErrorMessage
                .builder()
                .apiPath(request.getDescription(false))
                .httpStatus(HttpStatus.BAD_GATEWAY)
                .errorMessage(e.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
    }
}

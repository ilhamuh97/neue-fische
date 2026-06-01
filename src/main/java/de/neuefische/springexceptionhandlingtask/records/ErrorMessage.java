package de.neuefische.springexceptionhandlingtask.records;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public record ErrorMessage(String errorMessage, HttpStatus httpStatus, LocalDateTime errorTime, String apiPath) {
}

package org.example.neuefische.controller;

import org.example.neuefische.dto.InputAsterixCharacterDTO;
import org.example.neuefische.service.AsterixCharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.neuefische.model.AsterixCharacterRecord;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/api/asterix")
public class AsterixController {
    final AsterixCharacterService asterixCharacterService;

    public AsterixController(AsterixCharacterService asterixCharacterService) {
        this.asterixCharacterService = asterixCharacterService;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<AsterixCharacterRecord>> getCharacters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer maxAge
    ) {
        return ResponseEntity
                .ok()
                .body(asterixCharacterService.getCharacters(name, maxAge));
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<AsterixCharacterRecord> getCharacter(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(asterixCharacterService.getCharacter(id));
    }

    @GetMapping("/character/average-age")
    public ResponseEntity<OptionalDouble> getAverageAge() {
        return ResponseEntity
                .ok()
                .body(asterixCharacterService.getAverageAge());
    }

    @PostMapping("/character")
    public ResponseEntity<AsterixCharacterRecord> save(@RequestBody InputAsterixCharacterDTO characterRecord) {
        return ResponseEntity
                .ok()
                .body(asterixCharacterService.save(characterRecord));
    }

    @PutMapping("/character/{id}")
    public ResponseEntity<AsterixCharacterRecord> update(@PathVariable String id, @RequestBody InputAsterixCharacterDTO characterDTO) {
        return ResponseEntity
                .ok()
                .body(asterixCharacterService.update(id, characterDTO));
    }

    @DeleteMapping("character/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable String id) {
        return ResponseEntity
                .ok()
                .body(asterixCharacterService.deleteCharacter(id));
    }
}

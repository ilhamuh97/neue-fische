package org.example.neuefische.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.neuefische.model.AsterixCharacterRecord;
import org.example.neuefische.repository.AsterixCharacterRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/api/asterix")
public class AsterixController {
    final AsterixCharacterRepository characterRepository;

    public AsterixController(AsterixCharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<AsterixCharacterRecord>> getCharacters(@RequestParam(required = false) String name) {
        if(name == null) {
            return ResponseEntity.ok(characterRepository.findAll());
        }

        return ResponseEntity.ok(characterRepository.findByNameLike(name));
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<AsterixCharacterRecord> getCharacter(@PathVariable String id) {
        return ResponseEntity.ok(characterRepository
                            .findAsterixCharacterRecordById(id)
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Character not found!"))
        );
    }

    @GetMapping("/character/average-age")
    public ResponseEntity<OptionalDouble> getAverageAge() {

        return ResponseEntity.ok(characterRepository
                .findAll()
                .stream()
                .mapToDouble(AsterixCharacterRecord::age).average()
        );
    }

    @PostMapping("/character")
    public ResponseEntity<AsterixCharacterRecord> save(@RequestBody AsterixCharacterRecord characterRecord) {
        return ResponseEntity.ok(characterRepository
                .save(characterRecord)
        );
    }

    @PutMapping("/character/{id}")
    public ResponseEntity<AsterixCharacterRecord> update(@PathVariable String id, @RequestBody AsterixCharacterRecord characterRecord) {
        characterRepository
                .findAsterixCharacterRecordById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Character not found!"));

        return ResponseEntity.ok(characterRepository.save(characterRecord));
    }

    @DeleteMapping("character/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable String id) {
        characterRepository
                .findAsterixCharacterRecordById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Character not found!"
                ));

        characterRepository.deleteById(id);

        return ResponseEntity.ok("Character with ID: " + id + " is deleted successfully");
    }
}

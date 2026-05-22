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
    public ResponseEntity<List<AsterixCharacterRecord>> getCharacters(@RequestParam(required = false) String name) {
        return asterixCharacterService.getCharacters(name);
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<AsterixCharacterRecord> getCharacter(@PathVariable String id) {
        return asterixCharacterService.getCharacter(id);
    }

    @GetMapping("/character/average-age")
    public ResponseEntity<OptionalDouble> getAverageAge() {
        return asterixCharacterService.getAverageAge();
    }

    @PostMapping("/character")
    public ResponseEntity<AsterixCharacterRecord> save(@RequestBody InputAsterixCharacterDTO characterRecord) {
        return asterixCharacterService.save(characterRecord);
    }

    @PutMapping("/character/{id}")
    public ResponseEntity<AsterixCharacterRecord> update(@PathVariable String id, @RequestBody InputAsterixCharacterDTO characterDTO) {
        return asterixCharacterService.update(id, characterDTO);
    }

    @DeleteMapping("character/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable String id) {
        return asterixCharacterService.deleteCharacter(id);
    }
}

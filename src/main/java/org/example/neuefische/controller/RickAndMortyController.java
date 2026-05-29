package org.example.neuefische.controller;

import lombok.AllArgsConstructor;
import org.example.neuefische.service.RickAndMortyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.neuefische.model.CharacterRecord;

import java.util.List;

@RestController
@RequestMapping("/api/rick-and-morty")
@AllArgsConstructor
public class RickAndMortyController {
    final RickAndMortyService rickAndMortyService;

    @GetMapping("/characters")
    public ResponseEntity<List<CharacterRecord>> getRickAndMortyCharacters(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String species
    ) {
        return  ResponseEntity.ok(rickAndMortyService.getRickAndMortyCharacters(status, species));
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<CharacterRecord> getRickAndMortyCharacterById(@PathVariable String id) {
        return ResponseEntity.ok(rickAndMortyService.getRickAndMortyCharacterById(id));
    }

    @GetMapping("/species-statistic")
    public ResponseEntity<Integer> getRickAndMortySpeciesStatistic(@RequestParam(required = false) String species) {
        return ResponseEntity.ok(rickAndMortyService.getRickAndMortySpeciesStatistic(species));
    }
}

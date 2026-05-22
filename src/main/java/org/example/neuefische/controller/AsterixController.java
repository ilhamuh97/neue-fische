package org.example.neuefische.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.neuefische.model.Character;
import org.example.neuefische.repository.CharacterRepository;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
public class AsterixController {
    CharacterRepository characterRepository;

    public AsterixController() {
        characterRepository = new CharacterRepository();
    }

    @GetMapping("/characters")
    public List<Character> getCharacter() {
        return characterRepository.getCharacters();
    }
}

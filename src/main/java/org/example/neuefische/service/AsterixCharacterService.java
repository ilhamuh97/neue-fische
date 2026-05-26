package org.example.neuefische.service;

import org.example.neuefische.dto.InputAsterixCharacterDTO;
import org.example.neuefische.model.AsterixCharacterRecord;
import org.example.neuefische.repository.AsterixCharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class AsterixCharacterService {

    private final AsterixCharacterRepository asterixCharacterRepository;
    private final IdService idService;

    public AsterixCharacterService(IdService idService, AsterixCharacterRepository asterixCharacterRepository) {
        this.idService = idService;
        this.asterixCharacterRepository = asterixCharacterRepository;
    }

    public List<AsterixCharacterRecord> getCharacters(String name, Integer maxAge) {
        if (name == null && maxAge == null) {
            return asterixCharacterRepository.findAll();
        }

        if (name == null) {
            return asterixCharacterRepository.findByAgeIsLessThanEqual(maxAge);
        }

        if (maxAge == null) {
            return asterixCharacterRepository.findByNameLike(name);
        }

        return asterixCharacterRepository.findByNameLikeAndAgeIsLessThanEqual(name, maxAge);
    }


    public AsterixCharacterRecord getCharacter(String id) {
        return asterixCharacterRepository
                .findAsterixCharacterRecordById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Character not found!")
                );
    }

    public OptionalDouble getAverageAge() {
        return asterixCharacterRepository
                .findAll()
                .stream()
                .mapToDouble(AsterixCharacterRecord::age).average();
    }

    public AsterixCharacterRecord save(InputAsterixCharacterDTO characterDTO) {
        AsterixCharacterRecord newAsterixCharacter = new AsterixCharacterRecord(
                idService.randomId(),
                characterDTO.name(),
                characterDTO.age(),
                characterDTO.profession()
        );

        return asterixCharacterRepository.save(newAsterixCharacter);
    }

    public AsterixCharacterRecord update(String id, InputAsterixCharacterDTO characterDTO) {
        asterixCharacterRepository
                .findAsterixCharacterRecordById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Character not found!"));

        AsterixCharacterRecord newAsterixCharacter = new AsterixCharacterRecord(
                id,
                characterDTO.name(),
                characterDTO.age(),
                characterDTO.profession()
        );

        return asterixCharacterRepository.save(newAsterixCharacter);
    }

    public String deleteCharacter(String id) {
        asterixCharacterRepository
                .findAsterixCharacterRecordById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Character not found!"
                ));

        asterixCharacterRepository.deleteById(id);
        return "Character with ID: " + id + " is deleted successfully";
    }
}

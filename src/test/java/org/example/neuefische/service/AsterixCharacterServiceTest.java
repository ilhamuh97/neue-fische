package org.example.neuefische.service;

import org.example.neuefische.dto.InputAsterixCharacterDTO;
import org.example.neuefische.model.AsterixCharacterRecord;
import org.example.neuefische.repository.AsterixCharacterRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixCharacterServiceTest {
    private final String ID_123 = "123";
    private final String NAME_JOHN = "John";
    private final String PROFESSION_TEACHER = "Teacher";
    private final int AGE_20 = 20;
    private final AsterixCharacterRepository asterixCharacterRepository = mock(AsterixCharacterRepository.class);
    private final IdService idService = mock(IdService.class);

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithNameAndAge() {
        // GIVEN
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        when(asterixCharacterRepository.findByNameLikeAndAgeIsLessThanEqual(NAME_JOHN, AGE_20)).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(NAME_JOHN, AGE_20);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository).findByNameLikeAndAgeIsLessThanEqual(NAME_JOHN, AGE_20);
    }

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithName() {
        // GIVEN
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        when(asterixCharacterRepository.findByNameLike(NAME_JOHN)).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(NAME_JOHN, null);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository).findByNameLike(NAME_JOHN);
    }

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithAge() {
        // GIVEN
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        when(asterixCharacterRepository.findByAgeIsLessThanEqual(AGE_20)).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(null, AGE_20);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository).findByAgeIsLessThanEqual(AGE_20);
    }

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithoutNameAndAge() {
        // GIVEN
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        when(asterixCharacterRepository.findAll()).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(null, null);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository).findAll();
    }

    @Test
    void getCharacter_shouldReturnCharacter_whenCalledWithValidData() {
        // GIVEN
        AsterixCharacterRecord asterixCharacterRecordExpected = AsterixCharacterRecord.builder()
                .id(ID_123)
                .age(AGE_20)
                .name(NAME_JOHN)
                .profession(PROFESSION_TEACHER)
                .build();

        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        Optional<AsterixCharacterRecord> response = Optional.of(asterixCharacterRecordExpected);
        when(asterixCharacterRepository.findAsterixCharacterRecordById(ID_123)).thenReturn(response);

        // WHEN
        AsterixCharacterRecord asterixCharacterRecord = asterixCharacterService.getCharacter(ID_123);

        // THEN
        assertEquals(asterixCharacterRecordExpected, asterixCharacterRecord);
        verify(asterixCharacterRepository).findAsterixCharacterRecordById(ID_123);
    }

    @Test
    void update() {
        // GIVEN
        final String  NEW_NAME_ALEX = "Alex";
        final int NEW_AGE_21 = 21;
        final String NEW_PROFESSION_BUTCHER = "Butcher";
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        AsterixCharacterRecord asterixCharacterRecordFound = AsterixCharacterRecord.builder()
                .id(ID_123)
                .name(NAME_JOHN)
                .age(AGE_20)
                .profession(PROFESSION_TEACHER)
                .build();
        InputAsterixCharacterDTO asterixCharacterInputDTO = InputAsterixCharacterDTO.builder()
                .name(NEW_NAME_ALEX)
                .age(NEW_AGE_21)
                .profession(NEW_PROFESSION_BUTCHER)
                .build();
        AsterixCharacterRecord asterixCharacterExpected = asterixCharacterRecordFound
                .withName(asterixCharacterInputDTO.name())
                .withAge(asterixCharacterInputDTO.age())
                .withProfession(asterixCharacterInputDTO.profession());
        Optional<AsterixCharacterRecord> response = Optional.of(asterixCharacterRecordFound);
        when(asterixCharacterRepository.findAsterixCharacterRecordById(ID_123)).thenReturn(response);
        when(asterixCharacterRepository.save(asterixCharacterExpected)).thenReturn(asterixCharacterExpected);

        // WHEN
        AsterixCharacterRecord asterixCharacterRecordActual = asterixCharacterService.update(ID_123, asterixCharacterInputDTO);

        // THEN
        assertEquals(asterixCharacterExpected, asterixCharacterRecordActual);
        verify(asterixCharacterRepository).findAsterixCharacterRecordById(ID_123);
        verify(asterixCharacterRepository).save(asterixCharacterExpected);
    }

    @Test
    void deleteCharacter() {
        // GIVEN
        String expectedResponseMessage = "Character with ID: " + ID_123 + " is deleted successfully";
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        AsterixCharacterRecord asterixCharacterRecordFound = AsterixCharacterRecord.builder()
                .id(ID_123)
                .name(NAME_JOHN)
                .age(AGE_20)
                .profession(PROFESSION_TEACHER)
                .build();
        Optional<AsterixCharacterRecord> response = Optional.of(asterixCharacterRecordFound);
        when(asterixCharacterRepository.findAsterixCharacterRecordById(ID_123)).thenReturn(response);

        // WHEN
        String responseMessage = asterixCharacterService.deleteCharacter(ID_123);

        // THEN
        assertEquals(expectedResponseMessage, responseMessage);
        verify(asterixCharacterRepository).findAsterixCharacterRecordById(ID_123);
        verify(asterixCharacterRepository).deleteById(ID_123);
    }

    @Test
    void save() {
        // GIVEN
        final String NEW_ID_1234 = "1234";
        AsterixCharacterService asterixCharacterService = new AsterixCharacterService(idService, asterixCharacterRepository);
        InputAsterixCharacterDTO asterixCharacterInputDTO = InputAsterixCharacterDTO.builder()
                .name(NAME_JOHN)
                .age(AGE_20)
                .profession(PROFESSION_TEACHER)
                .build();
        AsterixCharacterRecord asterixCharacterExpected = AsterixCharacterRecord.builder()
                .id(NEW_ID_1234)
                .name(asterixCharacterInputDTO.name())
                .age(asterixCharacterInputDTO.age())
                .profession(asterixCharacterInputDTO.profession())
                .build();
        when(idService.randomId()).thenReturn(NEW_ID_1234);
        when(asterixCharacterRepository.save(asterixCharacterExpected)).thenReturn(asterixCharacterExpected);

        // WHEN
        AsterixCharacterRecord asterixCharacterRecord = asterixCharacterService.save(asterixCharacterInputDTO);

        // THEN
        assertEquals(asterixCharacterExpected, asterixCharacterRecord);
        verify(asterixCharacterRepository).save(asterixCharacterExpected.withAge(20));
    }
}
package org.example.neuefische.service;

import org.example.neuefische.dto.InputAsterixCharacterDTO;
import org.example.neuefische.model.AsterixCharacterRecord;
import org.example.neuefische.repository.AsterixCharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AsterixCharacterServiceTest {
    private final String ID_123 = "123";
    private final String NAME_JOHN = "John";
    private final String PROFESSION_TEACHER = "Teacher";
    private final int AGE_20 = 20;

    @Mock AsterixCharacterRepository asterixCharacterRepository;
    @Mock IdService idService;
    @InjectMocks AsterixCharacterService asterixCharacterService;

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithNameAndAge() {
        // GIVEN
        when(asterixCharacterRepository.findByNameLikeAndAgeIsLessThanEqual(NAME_JOHN, AGE_20)).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(NAME_JOHN, AGE_20);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository, times(1)).findByNameLikeAndAgeIsLessThanEqual(NAME_JOHN, AGE_20);
        verifyNoMoreInteractions(asterixCharacterRepository);
    }

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithName() {
        // GIVEN
        when(asterixCharacterRepository.findByNameLike(NAME_JOHN)).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(NAME_JOHN, null);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository, times(1)).findByNameLike(NAME_JOHN);
        verifyNoMoreInteractions(asterixCharacterRepository);
    }

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithAge() {
        // GIVEN
        when(asterixCharacterRepository.findByAgeIsLessThanEqual(AGE_20)).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(null, AGE_20);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository, times(1)).findByAgeIsLessThanEqual(AGE_20);
        verifyNoMoreInteractions(asterixCharacterRepository);
    }

    @Test
    void getCharacters_shouldReturnStudent_whenCalledWithoutNameAndAge() {
        // GIVEN
        when(asterixCharacterRepository.findAll()).thenReturn(List.of());

        // WHEN
        List<AsterixCharacterRecord> asterixCharacters = asterixCharacterService.getCharacters(null, null);

        // THEN
        assertEquals(asterixCharacters, List.of());
        verify(asterixCharacterRepository, times(1)).findAll();
        verifyNoMoreInteractions(asterixCharacterRepository);
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
        Optional<AsterixCharacterRecord> response = Optional.of(asterixCharacterRecordExpected);
        when(asterixCharacterRepository.findAsterixCharacterRecordById(ID_123)).thenReturn(response);

        // WHEN
        AsterixCharacterRecord asterixCharacterRecord = asterixCharacterService.getCharacter(ID_123);

        // THEN
        assertEquals(asterixCharacterRecordExpected, asterixCharacterRecord);
        verify(asterixCharacterRepository, times(1)).findAsterixCharacterRecordById(ID_123);
        verifyNoMoreInteractions(asterixCharacterRepository);
    }

    @Test
    void update_shouldReturnCharacter_whenCalledWithValidData() {
        // GIVEN
        final String  NEW_NAME_ALEX = "Alex";
        final int NEW_AGE_21 = 21;
        final String NEW_PROFESSION_BUTCHER = "Butcher";
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
        verify(asterixCharacterRepository, times(1)).findAsterixCharacterRecordById(ID_123);
        verify(asterixCharacterRepository, times(1)).save(asterixCharacterExpected);
        verifyNoMoreInteractions(asterixCharacterRepository);
    }

    @Test
    void deleteCharacter_shouldReturnSuccessMessage_whenCalledWithValidID() {
        // GIVEN
        String expectedResponseMessage = "Character with ID: " + ID_123 + " is deleted successfully";
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
        verify(asterixCharacterRepository, times(1)).findAsterixCharacterRecordById(ID_123);
        verify(asterixCharacterRepository, times(1)).deleteById(ID_123);
        verifyNoMoreInteractions(asterixCharacterRepository);
    }

    @Test
    void save_shouldReturnCharacter_whenCalledWithValidDAta() {
        // GIVEN
        final String NEW_ID_1234 = "1234";
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
        verifyNoMoreInteractions(asterixCharacterRepository);

        // WHEN
        AsterixCharacterRecord asterixCharacterRecord = asterixCharacterService.save(asterixCharacterInputDTO);

        // THEN
        assertEquals(asterixCharacterExpected, asterixCharacterRecord);
        verify(asterixCharacterRepository, times(1)).save(asterixCharacterExpected.withAge(20));
        verifyNoMoreInteractions(asterixCharacterRepository);
    }
}
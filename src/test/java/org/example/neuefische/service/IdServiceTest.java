package org.example.neuefische.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IdServiceTest {
    MockedStatic<UUID> uuidStaticMock = mockStatic(UUID.class);
    final String UUID_STRING = "123e4567-e89b-12d3-a456-426614174000";

    @Test
    void randomId() {
        UUID uuidMock = UUID.fromString(UUID_STRING);
        uuidStaticMock.when(UUID::randomUUID).thenReturn(uuidMock);
        IdService idService = new IdService();

        String actualRandomUUID = idService.randomId();

        assertEquals(UUID_STRING, actualRandomUUID);
        uuidStaticMock.verify(UUID::randomUUID);
    }
}
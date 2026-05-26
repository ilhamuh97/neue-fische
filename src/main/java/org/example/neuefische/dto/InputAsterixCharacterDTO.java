package org.example.neuefische.dto;

import lombok.Builder;

@Builder
public record InputAsterixCharacterDTO(String name, int age, String profession) {
}

package org.example.neuefische.model;

import lombok.Builder;
import lombok.With;

@With
@Builder
public record AsterixCharacterRecord(String id, String name, int age, String profession) {
}

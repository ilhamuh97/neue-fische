package org.example.neuefische.model;

import lombok.With;

@With
public record AsterixCharacterRecord(String id, String name, int age, String profession) {
}

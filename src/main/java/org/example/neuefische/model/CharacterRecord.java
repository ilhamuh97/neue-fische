package org.example.neuefische.model;

import lombok.With;

@With
public record CharacterRecord(String id, String name, String species, String status) {
}

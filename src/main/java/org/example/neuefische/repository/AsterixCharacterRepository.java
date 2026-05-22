package org.example.neuefische.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.example.neuefische.model.AsterixCharacterRecord;

import java.util.List;
import java.util.Optional;

@Repository
public interface AsterixCharacterRepository extends MongoRepository<AsterixCharacterRecord,String> {

    Optional<AsterixCharacterRecord> findAsterixCharacterRecordById(String id);

    List<AsterixCharacterRecord> findByNameLike(String name);
}

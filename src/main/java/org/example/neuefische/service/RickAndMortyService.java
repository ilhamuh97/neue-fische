package org.example.neuefische.service;

import org.example.neuefische.model.CharacterRecord;
import org.example.neuefische.model.CharactersRecord;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RickAndMortyService {

    private final RestClient restClient;

    public RickAndMortyService(RestClient.Builder restClient) {
        this.restClient = restClient.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public List<CharacterRecord> getRickAndMortyCharacters(String status, String species) {
        CharactersRecord charactersRecord = restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/character")
                        .queryParamIfPresent("status", Optional.ofNullable(status))
                        .queryParamIfPresent("species", Optional.ofNullable(species)) //?status=alive&species=human
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(CharactersRecord.class);

        return Objects.requireNonNull(charactersRecord).results();
    }

    public CharacterRecord getRickAndMortyCharacterById(String id) {
        return restClient
                .get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(CharacterRecord.class);
    }

    public Integer getRickAndMortySpeciesStatistic(String species) {
        CharactersRecord charactersRecord = restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/character")
                        .queryParamIfPresent("species", Optional.ofNullable(species))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(CharactersRecord.class);


        return Objects.requireNonNull(charactersRecord).info().count();
    }
}

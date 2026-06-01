package de.neuefische.springexceptionhandlingtask;

import de.neuefische.springexceptionhandlingtask.records.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AnimalControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAnimalSpecies_shouldReturnSpecies_whenCalledWithProperPathVariable() throws Exception {
        mockMvc.perform(get("/api/animals/dog"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assert result.getResponse().getContentAsString().equals("dog");
                });
    }

    @Test
    void getAnimalSpecies_shouldReturnError_whenCalledNotWithProperPathVariable() throws Exception {
        mockMvc.perform(get("/api/animals/cat"))
                .andExpect(status().isBadGateway())
                .andExpect(result -> {
                    ErrorMessage errorMessage = objectMapper.readValue(
                            result.getResponse().getContentAsString(),
                            ErrorMessage.class
                    );

                    System.out.println(errorMessage);
                    assert errorMessage.errorMessage().equals("Only 'dog' is allowed");
                });
    }

    @Test
    void getAllAnimals_shouldReturnError_whenCalled() throws Exception {
        mockMvc.perform(get("/api/animals"))
                .andExpect(status().isNotFound())
                .andExpect(result -> {
                    ErrorMessage errorMessage = objectMapper.readValue(
                            result.getResponse().getContentAsString(),
                            ErrorMessage.class
                    );

                    System.out.println(errorMessage);
                    assert errorMessage.errorMessage().equals("No Animals found");
                });
    }

    @Test
    void handleRuntimeException() {
    }
}
package de.neuefische.springexceptionhandlingtask;

import de.neuefische.springexceptionhandlingtask.records.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getCarBrand_shouldReturnNoError_whenCalledWithProperPathVariable() throws Exception {
        mockMvc.perform(get("/api/cars/porsche"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assert result.getResponse().getContentAsString().equals("porsche");
                });
    }

    @Test
    void getCarBrand_shouldReturnError_whenCalledWithNotProperPathVariable() throws Exception {
        mockMvc.perform(get("/api/cars/bmw"))
                .andExpect(status().isBadGateway())
                .andExpect(result -> {
                    ErrorMessage errorMessage = objectMapper.readValue(
                            result.getResponse().getContentAsString(),
                            ErrorMessage.class
                    );

                    System.out.println(errorMessage);
                    assert errorMessage.errorMessage().equals("Only 'porsche' allowed");
                });
    }

    @Test
    void getAllCars_shouldReturnError_whenCalled() throws Exception {
        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isNotFound())
                .andExpect(result -> {
                    ErrorMessage errorMessage = objectMapper.readValue(
                            result.getResponse().getContentAsString(),
                            ErrorMessage.class
                    );

                    System.out.println(errorMessage);
                    assert errorMessage.errorMessage().equals("No Cars found");
                });
    }
}
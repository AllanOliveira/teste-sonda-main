package br.com.elo7.sonda.candidato.v2.planets.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.elo7.sonda.candidato.v2.util.Scenarios.SCENARIOS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void should_list_the_planet_of_id_1() throws Exception {
        mockMvc
            .perform(get("/planets/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect( content().json(SCENARIOS("list_success_planet_of_id_1")));
    }

    @Test
    @Order(2)
    public void should_list_the_planet_of_id_invalid() throws Exception {
        mockMvc
            .perform(get("/planets/{id}", -1L))
            .andExpect(status().is4xxClientError())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect( content().json(SCENARIOS("list_failure_planet_of_id_minus_1")));
    }

    @Test
    @Order(3)
    public void should_list_the_planet_of_id_non_existent() throws Exception {
        mockMvc
            .perform(get("/planets/{id}", 20L))
            .andExpect(status().is4xxClientError())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect( content().json(SCENARIOS("list_failure_planet_of_id_20")));
    }

    @Test
    @Order(4)
    public void should_list_the_all_planets() throws Exception {
        mockMvc
            .perform(get("/planets"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect( content().json(SCENARIOS("list_success_all_planets")));
    }

    @Test
    @Order(5)
    public void should_insert_a_new_planet() throws Exception {
        mockMvc
            .perform(post("/planets")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(SCENARIOS("data_example_to_save_planets"))
            ).andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json(SCENARIOS("save_planet_with_successes")));
    }

    @Test
    @Order(6)
    public void not_should_insert_a_new_planet_with_invalids_attributes() throws Exception {
        mockMvc
            .perform(
                post("/planets")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(SCENARIOS("invalid_data_example_to_save_planet"))
            ).andExpect(status().is4xxClientError())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json(SCENARIOS("messages_error_save_planet")));
    }

    @Test
    @Order(7)
    public void must_not_enter_a_new_planet_without_attributes() throws Exception {
        mockMvc
            .perform(post("/planets").contentType(MediaType.APPLICATION_JSON_VALUE).content(SCENARIOS("empty_data")))
            .andExpect(status().is4xxClientError())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json(SCENARIOS("messages_error_save_planet")));
    }

    @Test
    @Order(8)
    public void should_update_planet_with_id_3() throws Exception {
        String jsonRequest = "{\"id\": 3, \"name\" : \"Mazalar\", \"width\":1200, \"height\":1200}";
        mockMvc
            .perform(
                put("/planets")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(SCENARIOS("data_example_update_planet"))
            ).andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
            .andExpect( content().json(SCENARIOS("data_example_update_planet")));
    }
}

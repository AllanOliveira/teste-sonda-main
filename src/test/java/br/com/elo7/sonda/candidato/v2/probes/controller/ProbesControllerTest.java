package br.com.elo7.sonda.candidato.v2.probes.controller;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProbesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void should_list_the_probe_of_id_1() throws Exception {
        mockMvc.perform(get("/probes/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("list_sucess_probe_id_1")));
    }

    @Test
    @Order(2)
    public void not_should_list_the_probe_of_id_nonexistent() throws Exception {
        mockMvc.perform(get("/probes/{id}", 55L))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("failure_list_probe_id_55")));
    }

    @Test
    @Order(3)
    public void not_should_list_the_probe_of_id_value_negative() throws Exception {
        String jsonExpected = "{\"uri\":\"/probes/-1\",\"errors\":{\"messages\":[{\"message\":\"probe not found\",\"code\":404}]}}";
        mockMvc.perform(get("/probes/{id}", -1L))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(jsonExpected));
    }

    @Test
    @Order(4)
    public void should_insert_the_probe_with_data_valid() throws Exception {
        mockMvc.perform(
                        post("/probes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(SCENARIOS("data_example_to_save_probe"))
                ).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("success_save_probe")));
    }

    @Test
    @Order(5)
    public void not_should_insert_the_probe_with_data_invalid() throws Exception {
        mockMvc.perform(
                        post("/probes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(SCENARIOS("data_invalid_insert_probe"))
                ).andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("success_list_all_probes")));
    }

    @Test
    @Order(6)
    public void should_probe_turn_right_and_move_3_times_and_turn_left_move_one_time() throws Exception {
        mockMvc.perform(
                        post("/probes/{id}/commands", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(SCENARIOS("example_list_of_commands_1")))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("result_execute_list_of_commands_1")));
    }

    @Test
    @Order(7)
    public void should_probe_move_4_times_and_turn_right_and_move_4_times() throws Exception {
        mockMvc.perform(post("/probes/{id}/commands", 2L).contentType(MediaType.APPLICATION_JSON)
                        .content(SCENARIOS("example_list_of_commands_2")))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("result_execute_list_of_commands_2")));
    }

    @Test
    @Order(8)
    public void should_probe_turn_left_move_2_times_and_turn_left_and_move_2_times() throws Exception {
        mockMvc.perform(
                        post("/probes/{id}/commands", 3L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(SCENARIOS("example_list_of_commands_3"))
                ).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("result_execute_list_of_commands_3")));
    }

    @Test
    @Order(8)
    public void not_should_to_move_probe_when_sending_invalid_command() throws Exception {
        mockMvc.perform(
                        post("/probes/{id}/commands", 3L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(SCENARIOS("invalid_example_list_of_commands")))
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(SCENARIOS("result_invalid_example_list_of_commands")));
    }

}

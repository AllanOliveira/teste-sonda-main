package br.com.elo7.sonda.candidato.v2.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scenarios {


    public static String SCENARIOS(String key){
        return Stream.of(new String[][]{
            {"list_success_planet_of_id_1","{\"id\":1,\"name\":\"Tatooine\",\"width\":900,\"height\":900,\"_links\":{\"self\":{\"href\":\"/planets/1\"}}}"},
            {"list_failure_planet_of_id_minus_1","{\"uri\":\"/planets/-1\",\"errors\":{\"messages\":[{\"message\":\"planet not found\",\"code\":404}]}}"},
            {"list_failure_planet_of_id_20","{\"uri\":\"/planets/20\",\"errors\":{\"messages\":[{\"message\":\"planet not found\",\"code\":404}]}}"},
            {"list_success_all_planets","{\"_embedded\":{\"planets\":[{\"id\":1,\"name\":\"Tatooine\",\"width\":900,\"height\":900,\"_links\":{\"self\":{\"href\":\"/planets/1\"}}},{\"id\":2,\"name\":\"Naboo\",\"width\":500,\"height\":800,\"_links\":{\"self\":{\"href\":\"/planets/2\"}}},{\"id\":3,\"name\":\"Endor\",\"width\":750,\"height\":400,\"_links\":{\"self\":{\"href\":\"/planets/3\"}}}]}}"},
            {"data_example_to_save_planets","{\"name\" : \"Mazalar\", \"width\":1200, \"height\":1200}"},
            {"save_planet_with_successes","{\"id\":4,\"name\":\"Mazalar\",\"width\":1200,\"height\":1200,\"_links\":{\"self\":{\"href\":\"/planets/4\"}}}"},
            {"invalid_data_example_to_save_planet","{\"name\" : \"\", \"width\":-100, \"height\":0}"},
            {"messages_error_save_planet","{\"uri\":\"/planets\",\"errors\":{\"messages\":[{\"message\":\"[width must be greater than 0, height must be greater than 0, name is required]\",\"code\":400}]}}"},
            {"empty_data","{}"},
            {"data_example_update_planet","{\"id\": 3, \"name\" : \"Mazalar\", \"width\":1200, \"height\":1200}"},
            {"list_sucess_probe_id_1","{\"id\":1,\"name\":\"R2D2\",\"positionAxisX\":100,\"positionAxisY\":100,\"direction\":\"NORTH\",\"_links\":{\"self\":{\"href\":\"/probes/1\"},\"on-planet\":{\"href\":\"/planets/1\"}}}"},
            {"failure_list_probe_id_55","{\"uri\":\"/probes/55\",\"errors\":{\"messages\":[{\"message\":\"probe not found\",\"code\":404}]}}"},
            {"failure_list_probe_id_minus_1","{\"uri\":\"/probes/-1\",\"errors\":{\"messages\":[{\"message\":\"probe not found\",\"code\":404}]}}"},
            {"data_example_to_save_probe","{\"name\": \"teste\", \"positionAxisX\" : 200, \"positionAxisY\" : 200,\"direction\" : \"SOUTH\",\"_links\": {\"on-planet\": {\"href\":\"/planets/1\"}}}"},
            {"success_save_probe","{\"id\":4,\"name\":\"teste\",\"positionAxisX\":200,\"positionAxisY\":200,\"direction\":\"SOUTH\",\"_links\":{\"self\":{\"href\":\"/probes/4\"},\"on-planet\":{\"href\":\"/planets/4\"}}}"},
            {"data_invalid_insert_probe","{\"name\": \"\", \"positionAxisX\" : -1, \"positionAxisY\" : -1,\"direction\" : \"SOUTHEAST\"}"},
            {"success_list_all_probes","{\"uri\":\"/probes\",\"errors\":{\"messages\":[{\"message\":\"[direction must be NORTH, SOUTH, EAST or WEST, id planet is required, positionAxisY must be greater than 0, positionAxisX must be greater than 0, name is required]\",\"code\":400}]}}"},
            {"example_list_of_commands_1","{\"commands\" : [\"R\",\"M\",\"M\",\"M\",\"L\",\"M\"]}"},
            {"result_execute_list_of_commands_1","{\"id\":1,\"name\":\"R2D2\",\"positionAxisX\":103,\"positionAxisY\":101,\"direction\":\"NORTH\",\"_links\":{\"self\":{\"href\":\"/probes/1\"},\"on-planet\":{\"href\":\"/planets/1\"}}}"},
            {"example_list_of_commands_2","{\"commands\" : [\"M\",\"M\",\"M\",\"M\",\"R\",\"M\",\"M\",\"M\",\"M\"]}"},
            {"result_execute_list_of_commands_2","{\"id\":2,\"name\":\"C3PO\",\"positionAxisX\":4,\"positionAxisY\":4,\"direction\":\"EAST\",\"_links\":{\"self\":{\"href\":\"/probes/2\"},\"on-planet\":{\"href\":\"/planets/2\"}}}"},
            {"example_list_of_commands_3","{\"commands\" : [\"L\",\"M\",\"M\",\"L\",\"M\",\"M\"]}"},
            {"result_execute_list_of_commands_3","{\"id\":3,\"name\":\"BB-88\",\"positionAxisX\":748,\"positionAxisY\":398,\"direction\":\"SOUTH\",\"_links\":{\"self\":{\"href\":\"/probes/3\"},\"on-planet\":{\"href\":\"/planets/3\"}}}"},
            {"invalid_example_list_of_commands","{\"commands\" : [\"L\",\"M\",\"Z\",\"L\",\"M\",\"M\"]}"},
            {"result_invalid_example_list_of_commands","{\"uri\":\"/probes/3/commands\",\"errors\":{\"messages\":[{\"message\":\"[command with input Z not found]\",\"code\":400}]}}"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1])).get(key);
    }

}

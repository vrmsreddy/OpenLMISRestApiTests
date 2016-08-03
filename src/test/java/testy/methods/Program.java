package testy.methods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import static io.restassured.RestAssured.given;

/**
 * Created by user on 8/2/16.
 */
public class Program {

    RequestSpecBuilder builder = new RequestSpecBuilder();
    ObjectMapper mapper = new ObjectMapper();

    public JsonNode createOrEditProgramUsingAllVariables(String serverURL, Integer portNumber, String token, String jsonBody) throws IOException {
        String APIUrl = serverURL + portNumber + "/api/programs" + token;
        builder.setContentType("application/json");
        builder.setBody(jsonBody);
        RequestSpecification requestSpec = builder.build();
        Response response = given().spec(requestSpec).post(APIUrl);
        String responseSting = response.asString();
        return mapper.readTree(responseSting);
    }
}

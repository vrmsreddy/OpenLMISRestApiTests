package org.openlmis.resttest.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openlmis.resttest.AbstractRestHelper;

import java.io.IOException;
import java.net.URI;

import static io.restassured.RestAssured.given;

public class FacilityOperatorHelper extends AbstractRestHelper {

    public FacilityOperatorHelper(String baseUrl) {
        super(baseUrl, "/api/facilityOperators");
    }

    public JsonNode createFacilityOperator(String token, String jsonBody) throws IOException {
        URI apiUrl = uri(token);

        RequestSpecBuilder builder = getRequestSpecBuilder();

        builder.setContentType("application/json");
        builder.setBody(jsonBody);

        RequestSpecification requestSpec = builder.build();

        Response response = given().spec(requestSpec).post(apiUrl);
        String responseSting = response.asString();

        return getObjectMapper().readTree(responseSting);
    }
}
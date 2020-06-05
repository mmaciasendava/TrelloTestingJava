package org.mmaciasendava.board;
import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.net.URI;
import java.util.Map;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseApiBuilder {

    final static String KEY = System.getenv("KEY");
    final static String TOKEN = System.getenv("TOKEN");
    private static RequestSpecification requestSpec;


    public BaseApiBuilder() {
        requestSpec = RestAssured.given(
                new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/")
                .setContentType(ContentType.JSON)
                .addQueryParam("key",KEY)
                .addQueryParam("token", TOKEN)
                .build()
        );
    }

    public Response get(URI uri) {
        return given().spec(requestSpec).get(uri);
    }

    public Response post(URI uri, Object body) {
        return requestSpec
                .body(body)
                .post(uri);
    }

    public Response get(URI uri, Map<String, String> params) {
        return requestSpec.params(params).get(uri);
    }

    public Response delete(String uri, Map<String, String> pathParams) {
        return requestSpec.pathParams(pathParams).delete(uri);
    }

}

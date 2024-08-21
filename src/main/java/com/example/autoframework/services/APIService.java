package com.example.autoframework.services;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIService {

    // Base URI for the API
    private String baseUri;
    private ObjectMapper objectMapper;

    // Constructor to initialize the base URI
    public APIService(String baseUri) {
        this.baseUri = baseUri;        
        RestAssured.baseURI = this.baseUri;
        this.objectMapper = new ObjectMapper();
    }

    // Method for GET requests
    public Response get(String endpoint) {
        return given()
                   .header("Content-Type", "application/json")
               .when()
                   .get(endpoint)
               .then()
                   .extract()
                   .response();
    }

    // Method for POST requests with a request body
    public Response post(String endpoint, Object body) {
        return given()
                   .header("Content-Type", "application/json")
                   .body(body)
               .when()
                   .post(endpoint)
               .then()
                   .extract()
                   .response();
    }


    // Method to get the status code from the response
    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    // Method to get the response body as a string
    public String getResponseBodyAsString(Response response) {
        return response.getBody().asString();
    }

    // Method to get a value from the JSON response using a JSON path
    public String getJsonValue(Response response, String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }
    
 // Method to serialize a Java object to a JSON string
    public String serialize(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to serialize object to JSON");
        }
    }

    // Method to deserialize a JSON string to a Java object
    public <T> T deserialize(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to deserialize JSON to object");
        }
    }

    // Method to deserialize a response body to a Java object
    public <T> T deserializeResponse(Response response, Class<T> clazz) {
        return deserialize(response.getBody().asString(), clazz);
    }
}

package com.example.autoframework;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.autoframework.models.DepartmentsResponse;
import com.example.autoframework.services.APIService;

import io.restassured.response.Response;

public class APITest {

	private APIService apiService;

    @BeforeClass
    public void setUp() {
        // Initialize APIService with the base URI
        apiService = new APIService("https://www.mercadolibre.com.ar");
    }

    @Test(description = "Verify that there are departments")
    public void testDepartments() {
        // Perform a GET request to departments endpoint
        Response response = apiService.get("/menu/departments");

        // Validate that we have a success response
        int statusCode = apiService.getStatusCode(response);
        assertEquals(statusCode, 200, "Expected status code is 200");

        //Deserialize response
        DepartmentsResponse responseGet = apiService.deserializeResponse(response, DepartmentsResponse.class);
        
        assertFalse(responseGet.getDepartments().isEmpty(), "Expected to have departments");
        
    }
    
}

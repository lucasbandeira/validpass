package com.example;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.json.JsonObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/validpass")
                .then()
                .statusCode(200)
                .body(is("Wellcome! validpass API: http://localhost:8080/q/swagger-ui/"));
    }

    @Test
    public void testValidPassword() {
        given().header("Content-type", "application/json")
                .and()
                .body("""
                    {
                        "password":"Lbs1235890*"
                    } 
                """)
                .when()
                .post("/validpass")
                .then()
                .statusCode(200)
                .body(is("true"));
    }

    @Test
    public void testPasswordWithoutNumbers() {
        given().header("Content-type", "application/json")
                .and()
                .body("""
                    {
                        "password":"LbsASDFGHJ*"
                    } 
                """)
                .when()
                .post("/validpass")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

    @Test
    public void testPasswordWithoutUppercase() {
        given().header("Content-type", "application/json")
                .and()
                .body("""
                    {
                        "password":"lbs123fghj*"
                    } 
                """)
                .when()
                .post("/validpass")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

    @Test
    public void testPasswordWithoutLowercase() {
        given().header("Content-type", "application/json")
                .and()
                .body("""
                    {
                        "password":"LBS123FGHJ*"
                    } 
                """)
                .when()
                .post("/validpass")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

    @Test
    public void testPasswordWithoutSpecialCharacters() {
        given().header("Content-type", "application/json")
                .and()
                .body("""
                    {
                        "password":"Lbs123FGH78"
                    } 
                """)
                .when()
                .post("/validpass")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

    @Test
    public void testPasswordDuplicatesCharacters() {
        given().header("Content-type", "application/json")
                .and()
                .body("""
                    {
                        "password":"LLs123FGHJ*"
                    } 
                """)
                .when()
                .post("/validpass")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

}
package com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean passwordValidate(Password password) {
        return password.isValid();
    }
}
package com.example;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/validpass")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PasswordResource {
    @GET
    public String hello() {
        return "Wellcome! validpass API: http://localhost:8080/q/swagger-ui/";
    }

    @POST
    @Operation(summary = "Validates the password.")
    @APIResponse(responseCode = "200",
            description = "return a boolean that validates the password")
    @Parameter
    public boolean passwordValidate(PasswordDTO passwordDTO) {
        ValidPassword validPassword = new ValidPassword(passwordDTO.password);
        return validPassword.isValid();
    }
}
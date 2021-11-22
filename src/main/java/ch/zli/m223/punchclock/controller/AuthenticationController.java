package ch.zli.m223.punchclock.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/auth")
@Tag(name = "Authentication", description = "Handling of user authentication")
public class AuthenticationController{
    @Inject
    AuthenticationService authenticationService;


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Checks if the given user data exists, then returns a JWT Token.", description = "Compares the given user data against existing users in the database. If a match is found a JWT Token is generated and returned. If no matching user is a found a NotAuthorizedException is thrown.")
    public String login(User user){
        if(authenticationService.checkIfUserExists(user)){
            return authenticationService.generateValidJwtToken(user.getUsername());
        }
        else {
            throw new NotAuthorizedException("User " + user.getUsername() + "was not found");
        }
    }
}
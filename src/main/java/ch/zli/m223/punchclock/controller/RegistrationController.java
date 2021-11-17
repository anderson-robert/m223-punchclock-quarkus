package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.RegistrationService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/register")
public class RegistrationController {

    @Inject
    RegistrationService registrationService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets ones user", description = "")
    public User getSingleUser(@PathParam("id") Long id){
        return registrationService.getSingleUser(id);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        registrationService.deleteUser(id);
    }

    @PUT
    public void update(User user){
        registrationService.updateUser(user);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new User", description = "The newly created user is returned. The id may not be passed.")
    public User add(User user) {
        return registrationService.createUser(user);
    }
}

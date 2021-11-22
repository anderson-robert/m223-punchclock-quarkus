package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.RegistrationService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/register")
@Tag(name = "Registration", description = "Handling of registration and users")
public class RegistrationController {

    @Inject
    RegistrationService registrationService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Gets ones user", description = "A single user matching the given ID is returned.")
    public User getSingleUser(@PathParam("id") Long id){
        return registrationService.getSingleUser(id);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete an existing User", description = "The existing user matching the given ID is deleted.")
    public void delete(@PathParam("id") Long id){
        registrationService.deleteUser(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an existing User", description = "An existing user matching the given parameters is updated. The updated user is returned.")
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

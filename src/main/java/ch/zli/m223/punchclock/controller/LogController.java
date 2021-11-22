package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Log;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.LogService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/logs")
@Tag(name = "Logs", description = "Handling of logs")
public class LogController {

    @Inject
    LogService logService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all logs", description = "")
    public List<Log> list() {
        return logService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets one log", description = "")
    public Log getSingleLog(@PathParam("id") Long id){
        return logService.getSingleLog(id);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        logService.deleteLog(id);
    }

    @PUT
    public void update(Log log){
        logService.updateLog(log);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Log", description = "The newly created log is returned. The id may not be passed.")
    public Log add(Log log) {
        return logService.createLog(log);
    }

}

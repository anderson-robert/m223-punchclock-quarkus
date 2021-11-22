package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Log;
import ch.zli.m223.punchclock.service.LogService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/logs")
@Tag(name = "Logs", description = "Handling of logs and logfiles")
public class LogController {

    @Inject
    LogService logService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all logs", description = "All found logs are returned in single List object.")
    public List<Log> list() {
        return logService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Gets one log", description = "A single log matching the given ID is returned.")
    public Log getSingleLog(@PathParam("id") Long id){
        return logService.getSingleLog(id);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete an existing Log", description = "The existing log matching the given ID is deleted.")
    public void delete(@PathParam("id") Long id){
        logService.deleteLog(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an existing Log", description = "An existing log matching the given parameters is updated. The updated log is returned.")
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

    @POST
    @Path("/createLogFile")
    @Operation(summary = "Creates a log file", description = "Creates a new logfile in the /src/main/resources/Logs directory.")
    public void createFile(String logType, Long userID) throws IOException {
        logService.createLogFile(logType,userID);
    }

}

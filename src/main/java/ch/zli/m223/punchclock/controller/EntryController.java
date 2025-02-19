package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Entries", description = "All found entries are returned in single List object.")
    public List<Entry> list() {
        return entryService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Gets ones entry", description = "A single entry matching the given ID is returned.")
    public Entry getSingleEntry(@PathParam("id") Long id){
        return entryService.getSingleEntry(id);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete an existing Entry", description = "The existing entry matching the given ID is deleted.")
    public void delete(@PathParam("id") Long id){
        entryService.deleteEntry(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an existing Entry", description = "An existing entry matching the given parameters is updated. The updated entry is returned.")
    public void update(Entry entry){
        entryService.updateEntry(entry);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

}

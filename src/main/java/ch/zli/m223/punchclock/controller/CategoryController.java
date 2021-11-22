package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.service.CategoryService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Tag(name = "Categories", description = "Handling of categories")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Categories", description = "All found categories are returned in single List object.")
    public List<Category> list() {
        return categoryService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets one category", description = "A single category matching the given ID is returned.")
    public Category getSingleCategory(@PathParam("id") Long id){
        return categoryService.getSingleCategory(id);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Operation(summary = "Delete an existing Category", description = "The existing category matching the given ID is deleted.")
    public void delete(@PathParam("id") Long id){
        categoryService.deleteCategory(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an existing Category", description = "An existing category matching the given parameters is updated. The updated category is returned.")
    public void update(Category category){
        categoryService.updateCategory(category);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Category", description = "The newly created category is returned. The id may not be passed.")
    public Category add(Category category) {
       return categoryService.createCategory(category);
    }

}
package kawahedukasi.controller;

import kawahedukasi.model.Item;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class itemController {

    @GET
    public Response inputPathParameter(@PathParam("name")String name){
        return Response.status(Response.Status.OK).entity(Item.findAll().list()).build();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Response get(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(Item.findById(id)).build();
    }

    @POST
    @Transactional
    public Response post(Map<String, Object> request){
        Item item = new Item();
        item.name = request.get("name").toString();
        item.count = request.get("count").toString();
        item.price = request.get("price").toString();
        item.type = request.get("type").toString();
        item.description = request.get("description").toString();
        item.createdAt = request.get("createdAt").toString();
        item.updatedAt = request.get("updatedAt").toString();

        item.persist();

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();

    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response put(@PathParam("id") Long id, Map<String, Object> request){
        Item item = Item.findById(id);
        if (item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        item.name = request.get("name").toString();
        item.count = request.get("count").toString();
        item.price = request.get("price").toString();
        item.type = request.get("type").toString();
        item.description = request.get("description").toString();
        item.createdAt = request.get("createdAt").toString();
        item.updatedAt = request.get("updatedAt").toString();

        item.persist();

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id, Map<String, Object> request){
        Item item = Item.findById(id);
        if (item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        item.delete();

        return Response.status(Response.Status.OK).entity(new HashMap<>()).build();

    }
}

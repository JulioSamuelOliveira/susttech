package br.com.fiap.resource;

import br.com.fiap.bo.AparelhoBO;
import br.com.fiap.to.AparelhoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/aparelhos")
public class AparelhoResource {
    private AparelhoBO aparelhoBO = new AparelhoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<AparelhoTO> resultado = aparelhoBO.findAll();
        return (resultado != null) ? Response.ok(resultado).build() : Response.status(404).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        AparelhoTO resultado = aparelhoBO.findById(id);
        return (resultado != null) ? Response.ok(resultado).build() : Response.status(404).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid AparelhoTO aparelho) {
        AparelhoTO resultado = aparelhoBO.save(aparelho);
        return (resultado != null) ? Response.status(201).entity(resultado).build() : Response.status(400).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return aparelhoBO.delete(id) ? Response.status(204).build() : Response.status(404).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid AparelhoTO aparelho, @PathParam("id") Long id) {
        aparelho.setId(id);
        AparelhoTO resultado = aparelhoBO.update(aparelho);
        return (resultado != null) ? Response.status(201).entity(resultado).build() : Response.status(400).build();
    }
}

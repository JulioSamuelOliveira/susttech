package br.com.fiap.resource;

import br.com.fiap.bo.EnergiaRenovavelBO;
import br.com.fiap.to.EnergiaRenovavelTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/energia-renovavel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnergiaRenovavelResource {

    private EnergiaRenovavelBO bo = new EnergiaRenovavelBO();

    @POST
    public void save(EnergiaRenovavelTO fonte) {
        bo.save(fonte);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, EnergiaRenovavelTO fonteAtualizada) {
        bo.update(id, fonteAtualizada);
    }

    @GET
    @Path("/{id}")
    public EnergiaRenovavelTO findById(@PathParam("id") int id) {
        return bo.findById(id);
    }

    @GET
    public List<EnergiaRenovavelTO> findAll() {
        return bo.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        bo.delete(id);
    }
}

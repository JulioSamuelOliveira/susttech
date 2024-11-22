package br.com.fiap.resource;

import br.com.fiap.bo.RelatorioAnaliticoBO;
import br.com.fiap.to.RelatorioAnaliticoTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/relatorio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RelatorioAnaliticoResource {

    private RelatorioAnaliticoBO bo = new RelatorioAnaliticoBO();

    @POST
    public void save(RelatorioAnaliticoTO relatorio) {
        bo.save(relatorio);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, RelatorioAnaliticoTO relatorioAtualizado) {
        bo.update(id, relatorioAtualizado);
    }

    @GET
    @Path("/{id}")
    public RelatorioAnaliticoTO findById(@PathParam("id") int id) {
        return bo.findById(id);
    }

    @GET
    public List<RelatorioAnaliticoTO> findAll() {
        return bo.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        bo.delete(id);
    }
}

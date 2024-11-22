package br.com.fiap.resource;

import br.com.fiap.bo.MonitoramentoConsumoBO;
import br.com.fiap.to.MonitoramentoConsumoTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/monitoramento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MonitoramentoConsumoResource {

    private MonitoramentoConsumoBO bo = new MonitoramentoConsumoBO();

    @POST
    public void save(MonitoramentoConsumoTO monitoramento) {
        bo.save(monitoramento);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") int id, MonitoramentoConsumoTO monitoramentoAtualizado) {
        bo.update(id, monitoramentoAtualizado);
    }

    @GET
    @Path("/{id}")
    public MonitoramentoConsumoTO findById(@PathParam("id") int id) {
        return bo.findById(id);
    }

    @GET
    public List<MonitoramentoConsumoTO> findAll() {
        return bo.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        bo.delete(id);
    }
}

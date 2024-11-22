package br.com.fiap.resource;

import br.com.fiap.bo.HistoricoConsumoBO;
import br.com.fiap.to.HistoricoConsumoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/historico-consumo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HistoricoConsumoResource {

    private HistoricoConsumoBO historicoBO = new HistoricoConsumoBO();


    @POST
    public Response save(HistoricoConsumoTO historico) {
        boolean sucesso = historicoBO.registrarConsumo(historico);
        return sucesso
                ? Response.status(Response.Status.CREATED).entity("Histórico registrado com sucesso").build()
                : Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao registrar histórico").build();
    }

    @GET
    public Response findAll() {
        List<HistoricoConsumoTO> historicos = historicoBO.findAll();
        return (historicos != null && !historicos.isEmpty())
                ? Response.ok(historicos).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Nenhum histórico encontrado").build();
    }

    @GET
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") Long id) {
        HistoricoConsumoTO historico = historicoBO.findById(id);
        return (historico != null)
                ? Response.ok(historico).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Histórico não encontrado").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, HistoricoConsumoTO historicoAtualizado) {
        historicoBO.update(id, historicoAtualizado);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        historicoBO.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

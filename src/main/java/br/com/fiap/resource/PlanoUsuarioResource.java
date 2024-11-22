package br.com.fiap.resource;

import br.com.fiap.bo.PlanoUsuarioBO;
import br.com.fiap.to.PlanoUsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/plano-usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlanoUsuarioResource {

    private PlanoUsuarioBO planoBO = new PlanoUsuarioBO();

    // Busca todos os planos
    @GET
    public Response buscarTodos() {
        List<PlanoUsuarioTO> planos = planoBO.buscarTodos();
        return (planos != null && !planos.isEmpty())
                ? Response.ok(planos).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Nenhum plano encontrado.").build();
    }

    // Busca um plano pelo ID
    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        PlanoUsuarioTO plano = planoBO.buscarPorId(id);
        return (plano != null)
                ? Response.ok(plano).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Plano não encontrado.").build();
    }

    // Cria um novo plano
    @POST
    public Response criarPlano(PlanoUsuarioTO plano) {
        boolean sucesso = planoBO.salvarPlano(plano);
        return sucesso
                ? Response.status(Response.Status.CREATED).entity("Plano criado com sucesso.").build()
                : Response.status(Response.Status.BAD_REQUEST).entity("Erro ao criar o plano.").build();
    }

    // Atualiza um plano existente
    @PUT
    @Path("/{id}")
    public Response atualizarPlano(@PathParam("id") Long id, PlanoUsuarioTO plano) {
        planoBO.atualizarPlano(id, plano);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // Remove um plano pelo ID
    @DELETE
    @Path("/{id}")
    public Response deletarPlano(@PathParam("id") Long id) {
        planoBO.deletarPlano(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

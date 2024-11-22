package br.com.fiap.resource;

import br.com.fiap.bo.ServicoNotificacaoBO;
import br.com.fiap.to.ServicoNotificacaoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/notificacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicoNotificacaoResource {

    private ServicoNotificacaoBO notificacaoBO = new ServicoNotificacaoBO();

    @POST
    public Response enviarNotificacao(ServicoNotificacaoTO notificacao) {
        boolean sucesso = notificacaoBO.enviarNotificacao(notificacao);
        return sucesso
                ? Response.status(Response.Status.CREATED).entity("Notificação enviada com sucesso").build()
                : Response.status(Response.Status.BAD_REQUEST).entity("Erro ao enviar a notificação").build();
    }

    @POST
    @Path("/save")
    public Response save(ServicoNotificacaoTO notificacao) {
        boolean sucesso = notificacaoBO.save(notificacao);
        return sucesso
                ? Response.status(Response.Status.CREATED).entity("Notificação salva com sucesso").build()
                : Response.status(Response.Status.BAD_REQUEST).entity("Erro ao salvar a notificação").build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, ServicoNotificacaoTO notificacao) {
        notificacaoBO.update(id, notificacao);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") int id) {
        ServicoNotificacaoTO notificacao = notificacaoBO.findById(id);
        return notificacao != null
                ? Response.ok(notificacao).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Notificação não encontrada").build();
    }

    @GET
    public Response findAll() {
        List<ServicoNotificacaoTO> notificacoes = notificacaoBO.findAll();
        return Response.ok(notificacoes).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        notificacaoBO.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

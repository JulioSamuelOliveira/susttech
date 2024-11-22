package br.com.fiap.resource;

import br.com.fiap.bo.MotorRecomendacaoBO;
import br.com.fiap.to.MotorRecomendacaoTO;
import br.com.fiap.to.AparelhoTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/recomendacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MotorRecomendacaoResource {

    private MotorRecomendacaoBO recomendacaoBO = new MotorRecomendacaoBO();

    @POST
    public Response recomendarTroca(AparelhoTO aparelho) {
        MotorRecomendacaoTO resultado = recomendacaoBO.recomendarTroca(aparelho);
        return (resultado != null) ? Response.status(Response.Status.CREATED).entity(resultado).build()
                : Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/save")
    public Response save(MotorRecomendacaoTO recomendacao) {
        MotorRecomendacaoTO saved = recomendacaoBO.save(recomendacao);
        return (saved != null) ? Response.status(Response.Status.CREATED).entity(saved).build()
                : Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MotorRecomendacaoTO recomendacao) {
        recomendacaoBO.update(id, recomendacao);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        MotorRecomendacaoTO recomendacao = recomendacaoBO.findById(id);
        return (recomendacao != null) ? Response.ok(recomendacao).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public Response findAll() {
        List<MotorRecomendacaoTO> recomendacoes = recomendacaoBO.findAll();
        return Response.ok(recomendacoes).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        recomendacaoBO.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

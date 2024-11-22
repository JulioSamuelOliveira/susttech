package br.com.fiap.resource;

import br.com.fiap.bo.CalculadoraConsumoEnergeticoBO;
import br.com.fiap.to.CalculadoraConsumoEnergeticoTO;
import br.com.fiap.to.AparelhoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/calculo-consumo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CalculadoraConsumoEnergeticoResource {

    private CalculadoraConsumoEnergeticoBO calculadoraBO = new CalculadoraConsumoEnergeticoBO();

    // Calcula e salva o consumo total de uma lista de aparelhos
    @POST
    public Response calcularConsumo(List<AparelhoTO> aparelhos) {
        CalculadoraConsumoEnergeticoTO resultado = calculadoraBO.salvarConsumo(aparelhos);
        return (resultado != null)
                ? Response.status(Response.Status.CREATED).entity(resultado).build()
                : Response.status(Response.Status.BAD_REQUEST).entity("Erro ao calcular e salvar o consumo").build();
    }

    // Salva um cálculo diretamente
    @POST
    @Path("/save")
    public Response save(CalculadoraConsumoEnergeticoTO calculo) {
        CalculadoraConsumoEnergeticoTO saved = calculadoraBO.save(calculo);
        return (saved != null)
                ? Response.status(Response.Status.CREATED).entity(saved).build()
                : Response.status(Response.Status.BAD_REQUEST).entity("Erro ao salvar o cálculo de consumo").build();
    }

    // Atualiza um cálculo existente pelo ID
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CalculadoraConsumoEnergeticoTO calculoAtualizado) {
        calculadoraBO.update(id, calculoAtualizado);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // Retorna um cálculo específico pelo ID
    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        CalculadoraConsumoEnergeticoTO calculo = calculadoraBO.findById(id);
        return (calculo != null)
                ? Response.ok(calculo).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Cálculo de consumo não encontrado").build();
    }

    // Retorna todos os cálculos de consumo registrados
    @GET
    public Response findAll() {
        List<CalculadoraConsumoEnergeticoTO> calculos = calculadoraBO.findAll();
        return (calculos != null && !calculos.isEmpty())
                ? Response.ok(calculos).build()
                : Response.status(Response.Status.NOT_FOUND).entity("Nenhum cálculo de consumo encontrado").build();
    }

    // Remove um cálculo de consumo pelo ID
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        calculadoraBO.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

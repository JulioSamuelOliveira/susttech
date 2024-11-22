package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class HistoricoConsumoTO {

    @NotNull(message = "O ID não pode ser nulo.")
    private Long id;


    @NotNull(message = "O consumo mensal deve ser informado.")
    private double consumoMensal;

    @NotNull(message = "A data de registro não pode ser nula.")
    private LocalDateTime dataRegistro;

    // Construtores
    public HistoricoConsumoTO() {}

    public HistoricoConsumoTO(Long id, Long idAparelho, double consumoMensal, LocalDateTime dataRegistro) {
        this.id = id;

        this.consumoMensal = consumoMensal;
        this.dataRegistro = dataRegistro;
    }

    public HistoricoConsumoTO( double consumoMensal, LocalDateTime dataRegistro) {

        this.consumoMensal = consumoMensal;
        this.dataRegistro = dataRegistro;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public String toString() {
        return "HistoricoConsumoTO{" +
                "id=" + id +
                ", consumoMensal=" + consumoMensal +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}

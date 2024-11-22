package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CalculadoraConsumoEnergeticoTO {

    @NotNull(message = "O ID não pode ser nulo.")
    private Long id;

    @Positive(message = "O consumo total deve ser positivo.")
    private double consumoTotal;

    // Construtores
    public CalculadoraConsumoEnergeticoTO() {}

    public CalculadoraConsumoEnergeticoTO(Long id, double consumoTotal) {
        this.id = id;
        this.consumoTotal = consumoTotal;
    }

    public CalculadoraConsumoEnergeticoTO(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    @Override
    public String toString() {
        return "CalculadoraConsumoEnergeticoTO{" +
                "id=" + id +
                ", consumoTotal=" + consumoTotal +
                '}';
    }
}

package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AparelhoTO {
    private Long id;

    @NotBlank(message = "O tipo do aparelho não pode ser vazio.")
    private String tipo;

    @NotBlank(message = "A marca do aparelho não pode ser vazia.")
    private String marca;

    @Positive(message = "A potência deve ser positiva.")
    private double potencia;

    @Positive(message = "As horas de uso devem ser positivas.")
    private int horasUsoMensal;

    public AparelhoTO() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public double getPotencia() { return potencia; }
    public void setPotencia(double potencia) { this.potencia = potencia; }

    public int getHorasUsoMensal() { return horasUsoMensal; }
    public void setHorasUsoMensal(int horasUsoMensal) { this.horasUsoMensal = horasUsoMensal; }
}

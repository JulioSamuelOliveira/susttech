package br.com.fiap.to;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class PlanoUsuarioTO {

    @NotNull(message = "O ID não pode ser nulo.")
    private Long id;

    @NotBlank(message = "O nome do plano não pode ser vazio.")
    private String nomePlano;

    @Positive(message = "O valor mensal deve ser positivo.")
    private double valorMensal;

    // Construtores
    public PlanoUsuarioTO() {}

    public PlanoUsuarioTO(Long id, String nomePlano, double valorMensal) {
        this.id = id;
        this.nomePlano = nomePlano;
        this.valorMensal = valorMensal;
    }

    public PlanoUsuarioTO(String nomePlano, double valorMensal) {
        this.nomePlano = nomePlano;
        this.valorMensal = valorMensal;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    @Override
    public String toString() {
        return "PlanoUsuarioTO{" +
                "id=" + id +
                ", nomePlano='" + nomePlano + '\'' +
                ", valorMensal=" + valorMensal +
                '}';
    }
}

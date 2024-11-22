package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MotorRecomendacaoTO {

    @NotNull(message = "O ID não pode ser nulo.")
    private Long id;

    @NotBlank(message = "A recomendação não pode ser vazia.")
    private String recomendacao;

    // Construtores
    public MotorRecomendacaoTO() {}

    public MotorRecomendacaoTO(Long id, String recomendacao) {
        this.id = id;
        this.recomendacao = recomendacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    @Override
    public String toString() {
        return "MotorRecomendacaoTO{" +
                "id=" + id +
                ", recomendacao='" + recomendacao + '\'' +
                '}';
    }
}

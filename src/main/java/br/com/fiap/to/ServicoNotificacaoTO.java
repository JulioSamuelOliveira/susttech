package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ServicoNotificacaoTO {

    @NotNull(message = "O ID não pode ser nulo.")
    private Long id;

    @Email(message = "O e-mail deve ser válido.")
    @NotBlank(message = "O e-mail de destino não pode ser vazio.")
    private String emailDestino;

    @NotBlank(message = "A mensagem não pode ser vazia.")
    private String mensagem;

    @NotBlank(message = "O assunto não pode ser vazio.")
    private String assunto;

    // Construtores
    public ServicoNotificacaoTO() {}

    public ServicoNotificacaoTO(Long id, String emailDestino, String mensagem, String assunto) {
        this.id = id;
        this.emailDestino = emailDestino;
        this.mensagem = mensagem;
        this.assunto = assunto;
    }

    public ServicoNotificacaoTO(String emailDestino, String mensagem, String assunto) {
        this.emailDestino = emailDestino;
        this.mensagem = mensagem;
        this.assunto = assunto;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "ServicoNotificacaoTO{" +
                "id=" + id +
                ", emailDestino='" + emailDestino + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", assunto='" + assunto + '\'' +
                '}';
    }
}

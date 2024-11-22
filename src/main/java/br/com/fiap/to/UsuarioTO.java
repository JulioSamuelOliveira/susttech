package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class UsuarioTO {
    private Long id;

    @NotBlank(message = "O nome do usuário não pode ser vazio.")
    private String nome;

    @Email(message = "O e-mail deve ser válido.")
    private String email;

    private List<AparelhoTO> aparelhos;

    public UsuarioTO() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<AparelhoTO> getAparelhos() { return aparelhos; }
    public void setAparelhos(List<AparelhoTO> aparelhos) { this.aparelhos = aparelhos; }
}

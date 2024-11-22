package br.com.fiap.dao;

import br.com.fiap.to.ServicoNotificacaoTO;

import java.util.ArrayList;
import java.util.List;

public class ServicoNotificacaoDAO {

    private List<ServicoNotificacaoTO> notificacoes = new ArrayList<>();

    // Simula o envio de uma notificação
    public boolean enviar(ServicoNotificacaoTO notificacao) {
        System.out.println("Enviando notificação para " + notificacao.getEmailDestino() + ": " + notificacao.getMensagem());
        return true; // Simulação de envio bem-sucedido
    }

    // Salva uma nova notificação
    public boolean save(ServicoNotificacaoTO notificacao) {
        notificacoes.add(notificacao);
        System.out.println("Notificação salva: " + notificacao.getMensagem());
        return true;
    }

    // Atualiza uma notificação existente
    public void update(int id, ServicoNotificacaoTO notificacao) {
        ServicoNotificacaoTO existente = findById(id);
        if (existente != null) {
            notificacoes.set(id, notificacao);
        } else {
            System.out.println("Notificação não encontrada para atualização.");
        }
    }

    // Busca uma notificação pelo ID
    public ServicoNotificacaoTO findById(int id) {
        if (id >= 0 && id < notificacoes.size()) {
            return notificacoes.get(id);
        }
        return null;
    }

    // Retorna todas as notificações
    public List<ServicoNotificacaoTO> findAll() {
        return new ArrayList<>(notificacoes);
    }

    // Remove uma notificação pelo ID
    public void delete(int id) {
        ServicoNotificacaoTO notificacao = findById(id);
        if (notificacao != null) {
            notificacoes.remove(notificacao);
            System.out.println("Notificação deletada: " + notificacao.getMensagem());
        } else {
            System.out.println("Notificação não encontrada para exclusão.");
        }
    }
}

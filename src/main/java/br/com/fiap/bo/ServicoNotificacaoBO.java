package br.com.fiap.bo;

import br.com.fiap.dao.ServicoNotificacaoDAO;
import br.com.fiap.to.ServicoNotificacaoTO;

import java.util.List;

public class ServicoNotificacaoBO {

    private ServicoNotificacaoDAO notificacaoDAO;

    public ServicoNotificacaoBO() {
        notificacaoDAO = new ServicoNotificacaoDAO();
    }

    public boolean enviarNotificacao(ServicoNotificacaoTO notificacao) {
        return notificacaoDAO.enviar(notificacao);
    }

    public boolean save(ServicoNotificacaoTO notificacao) {
        return notificacaoDAO.save(notificacao);
    }

    public void update(int id, ServicoNotificacaoTO notificacao) {
        notificacaoDAO.update(id, notificacao);
    }

    public ServicoNotificacaoTO findById(int id) {
        return notificacaoDAO.findById(id);
    }

    public List<ServicoNotificacaoTO> findAll() {
        return notificacaoDAO.findAll();
    }

    public void delete(int id) {
        notificacaoDAO.delete(id);
    }
}

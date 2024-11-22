package br.com.fiap.bo;

import br.com.fiap.dao.HistoricoConsumoDAO;
import br.com.fiap.to.HistoricoConsumoTO;

import java.util.List;

public class HistoricoConsumoBO {

    private HistoricoConsumoDAO historicoDAO;

    public HistoricoConsumoBO() {
        historicoDAO = new HistoricoConsumoDAO();
    }

    // Registra um novo consumo
    public boolean registrarConsumo(HistoricoConsumoTO historico) {
        return historicoDAO.save(historico);
    }

    // Salva um novo histórico de consumo
    public boolean save(HistoricoConsumoTO historico) {
        return historicoDAO.save(historico);
    }

    // Atualiza um histórico existente pelo ID
    public void update(Long id, HistoricoConsumoTO historicoAtualizado) {
        historicoDAO.update(id, historicoAtualizado);
    }

    // Busca um histórico de consumo específico pelo ID
    public HistoricoConsumoTO findById(Long id) {
        return historicoDAO.findById(id);
    }

    // Retorna todos os históricos de consumo
    public List<HistoricoConsumoTO> findAll() {
        return historicoDAO.findAll();
    }

    // Remove um histórico de consumo pelo ID
    public void delete(Long id) {
        historicoDAO.delete(id);
    }
}

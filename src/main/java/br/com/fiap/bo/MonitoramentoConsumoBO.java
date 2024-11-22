package br.com.fiap.bo;

import br.com.fiap.dao.MonitoramentoConsumoDAO;
import br.com.fiap.to.MonitoramentoConsumoTO;

import java.util.List;

public class MonitoramentoConsumoBO {

    private MonitoramentoConsumoDAO dao = new MonitoramentoConsumoDAO();

    public void save(MonitoramentoConsumoTO monitoramento) {
        dao.save(monitoramento);
    }

    public void update(int id, MonitoramentoConsumoTO monitoramentoAtualizado) {
        dao.update(id, monitoramentoAtualizado);
    }

    public MonitoramentoConsumoTO findById(int id) {
        return dao.findById(id);
    }

    public List<MonitoramentoConsumoTO> findAll() {
        return dao.findAll();
    }

    public void delete(int id) {
        dao.delete(id);
    }
}

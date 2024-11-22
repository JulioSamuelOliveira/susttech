package br.com.fiap.dao;

import br.com.fiap.to.MonitoramentoConsumoTO;

import java.util.ArrayList;
import java.util.List;

public class MonitoramentoConsumoDAO {

    private List<MonitoramentoConsumoTO> monitoramentos = new ArrayList<>();

    public void save(MonitoramentoConsumoTO monitoramento) {
        monitoramentos.add(monitoramento);
    }

    public void update(int id, MonitoramentoConsumoTO monitoramentoAtualizado) {
        MonitoramentoConsumoTO monitoramento = findById(id);
        if (monitoramento != null) {
            monitoramentos.set(id, monitoramentoAtualizado);
        }
    }

    public MonitoramentoConsumoTO findById(int id) {
        if (id >= 0 && id < monitoramentos.size()) {
            return monitoramentos.get(id);
        }
        return null;
    }

    public List<MonitoramentoConsumoTO> findAll() {
        return new ArrayList<>(monitoramentos);
    }

    public void delete(int id) {
        MonitoramentoConsumoTO monitoramento = findById(id);
        if (monitoramento != null) {
            monitoramentos.remove(id);
        }
    }
}

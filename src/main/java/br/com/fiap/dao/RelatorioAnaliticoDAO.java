package br.com.fiap.dao;

import br.com.fiap.to.RelatorioAnaliticoTO;

import java.util.ArrayList;
import java.util.List;

public class RelatorioAnaliticoDAO {

    private List<RelatorioAnaliticoTO> relatorios = new ArrayList<>();

    public void save(RelatorioAnaliticoTO relatorio) {
        relatorios.add(relatorio);
    }

    public void update(int id, RelatorioAnaliticoTO relatorioAtualizado) {
        RelatorioAnaliticoTO relatorio = findById(id);
        if (relatorio != null) {
            relatorios.set(id, relatorioAtualizado);
        }
    }

    public RelatorioAnaliticoTO findById(int id) {
        if (id >= 0 && id < relatorios.size()) {
            return relatorios.get(id);
        }
        return null;
    }

    public List<RelatorioAnaliticoTO> findAll() {
        return new ArrayList<>(relatorios);
    }

    public void delete(int id) {
        RelatorioAnaliticoTO relatorio = findById(id);
        if (relatorio != null) {
            relatorios.remove(id);
        }
    }
}

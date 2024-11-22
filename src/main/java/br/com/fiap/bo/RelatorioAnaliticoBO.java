package br.com.fiap.bo;

import br.com.fiap.dao.RelatorioAnaliticoDAO;
import br.com.fiap.to.RelatorioAnaliticoTO;

import java.util.List;

public class RelatorioAnaliticoBO {

    private RelatorioAnaliticoDAO dao = new RelatorioAnaliticoDAO();

    public void save(RelatorioAnaliticoTO relatorio) {
        dao.save(relatorio);
    }

    public void update(int id, RelatorioAnaliticoTO relatorioAtualizado) {
        dao.update(id, relatorioAtualizado);
    }

    public RelatorioAnaliticoTO findById(int id) {
        return dao.findById(id);
    }

    public List<RelatorioAnaliticoTO> findAll() {
        return dao.findAll();
    }

    public void delete(int id) {
        dao.delete(id);
    }
}

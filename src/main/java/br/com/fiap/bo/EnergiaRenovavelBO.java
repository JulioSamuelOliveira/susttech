package br.com.fiap.bo;

import br.com.fiap.dao.EnergiaRenovavelDAO;
import br.com.fiap.to.EnergiaRenovavelTO;

import java.util.List;

public class EnergiaRenovavelBO {

    private EnergiaRenovavelDAO dao = new EnergiaRenovavelDAO();

    public void save(EnergiaRenovavelTO fonte) {
        dao.save(fonte);
    }

    public void update(int id, EnergiaRenovavelTO fonteAtualizada) {
        dao.update(id, fonteAtualizada);
    }

    public EnergiaRenovavelTO findById(int id) {
        return dao.findById(id);
    }

    public List<EnergiaRenovavelTO> findAll() {
        return dao.findAll();
    }

    public void delete(int id) {
        dao.delete(id);
    }
}

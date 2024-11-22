package br.com.fiap.dao;

import br.com.fiap.to.EnergiaRenovavelTO;

import java.util.ArrayList;
import java.util.List;

public class EnergiaRenovavelDAO {

    private List<EnergiaRenovavelTO> fontes = new ArrayList<>();

    public void save(EnergiaRenovavelTO fonte) {
        fontes.add(fonte);
    }

    public void update(int id, EnergiaRenovavelTO fonteAtualizada) {
        EnergiaRenovavelTO fonte = findById(id);
        if (fonte != null) {
            fontes.set(id, fonteAtualizada);
        }
    }

    public EnergiaRenovavelTO findById(int id) {
        if (id >= 0 && id < fontes.size()) {
            return fontes.get(id);
        }
        return null;
    }

    public List<EnergiaRenovavelTO> findAll() {
        return new ArrayList<>(fontes); // Corrigido o uso da variável correta
    }

    public void delete(int id) {
        EnergiaRenovavelTO fonte = findById(id);
        if (fonte != null) {
            fontes.remove(id);
        }
    }
}

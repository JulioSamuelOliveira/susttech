package br.com.fiap.bo;

import br.com.fiap.dao.PlanoUsuarioDAO;
import br.com.fiap.to.PlanoUsuarioTO;

import java.util.List;

public class PlanoUsuarioBO {

    private PlanoUsuarioDAO planoDAO;

    public PlanoUsuarioBO() {
        planoDAO = new PlanoUsuarioDAO();
    }

    // Busca todos os planos
    public List<PlanoUsuarioTO> buscarTodos() {
        return planoDAO.findAll();
    }

    // Busca um plano pelo ID
    public PlanoUsuarioTO buscarPorId(Long id) {
        return planoDAO.findById(id);
    }

    // Salva um novo plano
    public boolean salvarPlano(PlanoUsuarioTO plano) {
        return planoDAO.save(plano);
    }

    // Atualiza um plano existente
    public void atualizarPlano(Long id, PlanoUsuarioTO planoAtualizado) {
        planoDAO.update(id, planoAtualizado);
    }

    // Deleta um plano pelo ID
    public void deletarPlano(Long id) {
        planoDAO.delete(id);
    }
}

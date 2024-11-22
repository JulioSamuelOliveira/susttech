package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;
import java.util.ArrayList;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO(); // Inicializa o DAO
    }

    public ArrayList<UsuarioTO> findAll() {
        ArrayList<UsuarioTO> usuarios = usuarioDAO.findAll();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        }
        return usuarios;
    }

    public UsuarioTO findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }

        UsuarioTO usuario = usuarioDAO.findById(id);
        if (usuario == null) {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O e-mail do usuário é obrigatório.");
        }

        UsuarioTO usuarioSalvo = usuarioDAO.save(usuario);
        if (usuarioSalvo != null) {
            System.out.println("Usuário salvo com sucesso.");
        } else {
            System.out.println("Erro ao salvar o usuário.");
        }
        return usuarioSalvo;
    }

    public UsuarioTO update(UsuarioTO usuario) {
        if (usuario == null || usuario.getId() == null || usuario.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }

        UsuarioTO usuarioAtualizado = usuarioDAO.update(usuario);
        if (usuarioAtualizado != null) {
            System.out.println("Usuário atualizado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar o usuário.");
        }
        return usuarioAtualizado;
    }


    public boolean delete(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }

        boolean sucesso = usuarioDAO.delete(id);
        if (sucesso) {
            System.out.println("Usuário com ID " + id + " deletado com sucesso.");
        } else {
            System.out.println("Erro ao deletar o usuário com ID " + id + ".");
        }
        return sucesso;
    }
}

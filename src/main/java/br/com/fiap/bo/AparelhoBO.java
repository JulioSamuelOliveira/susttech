package br.com.fiap.bo;

import br.com.fiap.dao.AparelhoDAO;
import br.com.fiap.to.AparelhoTO;
import java.util.ArrayList;

public class AparelhoBO {

    private AparelhoDAO aparelhoDAO;

    public AparelhoBO() {
        this.aparelhoDAO = new AparelhoDAO(); // Inicializa o DAO
    }

    /**
     * Busca todos os aparelhos cadastrados.
     *
     * @return Lista de AparelhoTO
     */
    public ArrayList<AparelhoTO> findAll() {
        ArrayList<AparelhoTO> aparelhos = aparelhoDAO.findAll();
        if (aparelhos.isEmpty()) {
            System.out.println("Nenhum aparelho encontrado.");
        }
        return aparelhos;
    }

    /**
     * Busca um aparelho pelo ID.
     *
     * @param id ID do aparelho
     * @return AparelhoTO se encontrado, null caso contrário
     */
    public AparelhoTO findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }

        AparelhoTO aparelho = aparelhoDAO.findById(id);
        if (aparelho == null) {
            System.out.println("Aparelho com ID " + id + " não encontrado.");
        }
        return aparelho;
    }

    /**
     * Salva um novo aparelho.
     *
     * @param aparelho Objeto AparelhoTO a ser salvo
     * @return AparelhoTO salvo ou null em caso de erro
     */
    public AparelhoTO save(AparelhoTO aparelho) {
        if (aparelho == null) {
            throw new IllegalArgumentException("Aparelho não pode ser nulo.");
        }
        if (aparelho.getTipo() == null || aparelho.getTipo().isEmpty()) {
            throw new IllegalArgumentException("O tipo do aparelho é obrigatório.");
        }
        if (aparelho.getMarca() == null || aparelho.getMarca().isEmpty()) {
            throw new IllegalArgumentException("A marca do aparelho é obrigatória.");
        }

        AparelhoTO aparelhoSalvo = aparelhoDAO.save(aparelho);
        if (aparelhoSalvo != null) {
            System.out.println("Aparelho salvo com sucesso.");
        } else {
            System.out.println("Erro ao salvar o aparelho.");
        }
        return aparelhoSalvo;
    }

    /**
     * Atualiza um aparelho existente.
     *
     * @param aparelho Objeto AparelhoTO com as informações atualizadas
     * @return true se atualizado com sucesso, false caso contrário
     */
    public AparelhoTO update(AparelhoTO aparelho) {
        if (aparelho == null || aparelho.getId() == null || aparelho.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }

        boolean sucesso = aparelhoDAO.update(aparelho);
        if (sucesso) {
            System.out.println("Aparelho atualizado com sucesso.");
            return aparelho; // Retorna o objeto atualizado
        } else {
            System.out.println("Erro ao atualizar o aparelho.");
            return null; // Retorna null em caso de falha
        }
    }


    /**
     * Deleta um aparelho pelo ID.
     *
     * @param id ID do aparelho a ser deletado
     * @return true se deletado com sucesso, false caso contrário
     */
    public boolean delete(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }

        boolean sucesso = aparelhoDAO.delete(id);
        if (sucesso) {
            System.out.println("Aparelho com ID " + id + " deletado com sucesso.");
        } else {
            System.out.println("Erro ao deletar o aparelho com ID " + id + ".");
        }
        return sucesso;
    }
}

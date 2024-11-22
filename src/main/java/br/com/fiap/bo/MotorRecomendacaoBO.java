package br.com.fiap.bo;

import br.com.fiap.dao.MotorRecomendacaoDAO;
import br.com.fiap.to.MotorRecomendacaoTO;
import br.com.fiap.to.AparelhoTO;

import java.util.List;

public class MotorRecomendacaoBO {
    private MotorRecomendacaoDAO recomendacaoDAO;

    public MotorRecomendacaoBO() {
        recomendacaoDAO = new MotorRecomendacaoDAO();
    }

    public MotorRecomendacaoTO recomendarTroca(AparelhoTO aparelho) {
        String mensagem = (aparelho.getPotencia() * aparelho.getHorasUsoMensal() > 100)
                ? "Recomenda-se substituir o " + aparelho.getTipo() + " por um modelo mais eficiente."
                : "O aparelho " + aparelho.getTipo() + " está com um consumo adequado.";

        MotorRecomendacaoTO recomendacao = new MotorRecomendacaoTO();
        recomendacao.setRecomendacao(mensagem);
        return recomendacaoDAO.save(recomendacao);
    }

    public MotorRecomendacaoTO save(MotorRecomendacaoTO recomendacao) {
        return recomendacaoDAO.save(recomendacao);
    }

    public void update(Long id, MotorRecomendacaoTO recomendacao) {
        recomendacaoDAO.update(id, recomendacao);
    }

    public MotorRecomendacaoTO findById(Long id) {
        return recomendacaoDAO.findById(id);
    }

    public List<MotorRecomendacaoTO> findAll() {
        return recomendacaoDAO.findAll();
    }

    public void delete(Long id) {
        recomendacaoDAO.delete(id);
    }
}

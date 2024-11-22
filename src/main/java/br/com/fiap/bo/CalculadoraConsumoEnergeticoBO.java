package br.com.fiap.bo;

import br.com.fiap.dao.CalculadoraConsumoEnergeticoDAO;
import br.com.fiap.to.CalculadoraConsumoEnergeticoTO;
import br.com.fiap.to.AparelhoTO;

import java.util.List;

public class CalculadoraConsumoEnergeticoBO {

    private CalculadoraConsumoEnergeticoDAO calculadoraDAO;

    public CalculadoraConsumoEnergeticoBO() {
        calculadoraDAO = new CalculadoraConsumoEnergeticoDAO();
    }

    // Calcula o consumo total de energia de uma lista de aparelhos
    public double calcularConsumoTotal(List<AparelhoTO> aparelhos) {
        double total = 0;
        for (AparelhoTO aparelho : aparelhos) {
            total += aparelho.getPotencia() * aparelho.getHorasUsoMensal();
        }
        return total;
    }

    // Salva o consumo total calculado
    public CalculadoraConsumoEnergeticoTO salvarConsumo(List<AparelhoTO> aparelhos) {
        double totalConsumo = calcularConsumoTotal(aparelhos);
        CalculadoraConsumoEnergeticoTO calculo = new CalculadoraConsumoEnergeticoTO();
        calculo.setConsumoTotal(totalConsumo);
        return calculadoraDAO.save(calculo);
    }

    // Salva diretamente um cálculo de consumo
    public CalculadoraConsumoEnergeticoTO save(CalculadoraConsumoEnergeticoTO calculo) {
        return calculadoraDAO.save(calculo);
    }

    // Atualiza um cálculo de consumo existente pelo ID
    public void update(Long id, CalculadoraConsumoEnergeticoTO calculoAtualizado) {
        calculadoraDAO.update(id, calculoAtualizado);
    }

    // Busca um cálculo de consumo específico pelo ID
    public CalculadoraConsumoEnergeticoTO findById(Long id) {
        return calculadoraDAO.findById(id);
    }

    // Retorna todos os cálculos de consumo registrados
    public List<CalculadoraConsumoEnergeticoTO> findAll() {
        return calculadoraDAO.findAll();
    }

    // Remove um cálculo de consumo pelo ID
    public void delete(Long id) {
        calculadoraDAO.delete(id);
    }
}

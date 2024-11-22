package br.com.fiap.dao;

import br.com.fiap.to.CalculadoraConsumoEnergeticoTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraConsumoEnergeticoDAO extends Repository {

    public CalculadoraConsumoEnergeticoTO save(CalculadoraConsumoEnergeticoTO calculo) {
        String sql = "INSERT INTO calculo_consumo (consumo_total) VALUES (?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, calculo.getConsumoTotal());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                calculo.setId(rs.getLong(1));
            }
            return calculo;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o cálculo de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public void update(Long id, CalculadoraConsumoEnergeticoTO calculo) {
        String sql = "UPDATE calculo_consumo SET consumo_total = ? WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, calculo.getConsumoTotal());
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o cálculo de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public CalculadoraConsumoEnergeticoTO findById(Long id) {
        String sql = "SELECT * FROM calculo_consumo WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CalculadoraConsumoEnergeticoTO calculo = new CalculadoraConsumoEnergeticoTO();
                calculo.setId(rs.getLong("id"));
                calculo.setConsumoTotal(rs.getDouble("consumo_total"));
                return calculo;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o cálculo de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<CalculadoraConsumoEnergeticoTO> findAll() {
        List<CalculadoraConsumoEnergeticoTO> calculos = new ArrayList<>();
        String sql = "SELECT * FROM calculo_consumo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CalculadoraConsumoEnergeticoTO calculo = new CalculadoraConsumoEnergeticoTO();
                calculo.setId(rs.getLong("id"));
                calculo.setConsumoTotal(rs.getDouble("consumo_total"));
                calculos.add(calculo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os cálculos de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return calculos;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM calculo_consumo WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o cálculo de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
}

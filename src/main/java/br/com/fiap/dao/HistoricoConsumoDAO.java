package br.com.fiap.dao;

import br.com.fiap.to.HistoricoConsumoTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoConsumoDAO extends Repository {

    public boolean save(HistoricoConsumoTO historico) {
        String sql = "INSERT INTO historico_consumo (id_aparelho, consumo_mensal, data_registro) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, historico.getId());
            ps.setDouble(2, historico.getConsumoMensal());
            ps.setTimestamp(3, Timestamp.valueOf(historico.getDataRegistro()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao registrar consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public void update(Long id, HistoricoConsumoTO historico) {
        String sql = "UPDATE historico_consumo SET id_aparelho = ?, consumo_mensal = ?, data_registro = ? WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, historico.getId());
            ps.setDouble(2, historico.getConsumoMensal());
            ps.setTimestamp(3, Timestamp.valueOf(historico.getDataRegistro()));
            ps.setLong(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o histórico de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public HistoricoConsumoTO findById(Long id) {
        String sql = "SELECT * FROM historico_consumo WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HistoricoConsumoTO historico = new HistoricoConsumoTO();
                historico.setId(rs.getLong("id"));
                historico.setId(rs.getLong("id_aparelho"));
                historico.setConsumoMensal(rs.getDouble("consumo_mensal"));
                historico.setDataRegistro(rs.getTimestamp("data_registro").toLocalDateTime());
                return historico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar histórico de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<HistoricoConsumoTO> findAll() {
        List<HistoricoConsumoTO> historicos = new ArrayList<>();
        String sql = "SELECT * FROM historico_consumo ORDER BY data_registro";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HistoricoConsumoTO historico = new HistoricoConsumoTO();
                historico.setId(rs.getLong("id"));
                historico.setId(rs.getLong("id_aparelho"));
                historico.setConsumoMensal(rs.getDouble("consumo_mensal"));
                historico.setDataRegistro(rs.getTimestamp("data_registro").toLocalDateTime());
                historicos.add(historico);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar históricos de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return historicos;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM historico_consumo WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar histórico de consumo: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
}

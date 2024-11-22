package br.com.fiap.dao;

import br.com.fiap.to.PlanoUsuarioTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanoUsuarioDAO extends Repository {

    // Busca todos os planos
    public List<PlanoUsuarioTO> findAll() {
        List<PlanoUsuarioTO> planos = new ArrayList<>();
        String sql = "SELECT * FROM planos ORDER BY nome_plano";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PlanoUsuarioTO plano = new PlanoUsuarioTO();
                plano.setId(rs.getLong("id"));
                plano.setNomePlano(rs.getString("nome_plano"));
                plano.setValorMensal(rs.getDouble("valor_mensal"));
                planos.add(plano);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar planos: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return planos;
    }

    // Busca um plano pelo ID
    public PlanoUsuarioTO findById(Long id) {
        String sql = "SELECT * FROM planos WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PlanoUsuarioTO plano = new PlanoUsuarioTO();
                plano.setId(rs.getLong("id"));
                plano.setNomePlano(rs.getString("nome_plano"));
                plano.setValorMensal(rs.getDouble("valor_mensal"));
                return plano;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar plano por ID: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    // Salva um novo plano
    public boolean save(PlanoUsuarioTO plano) {
        String sql = "INSERT INTO planos (nome_plano, valor_mensal) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, plano.getNomePlano());
            ps.setDouble(2, plano.getValorMensal());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o plano: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    // Atualiza um plano existente
    public void update(Long id, PlanoUsuarioTO plano) {
        String sql = "UPDATE planos SET nome_plano = ?, valor_mensal = ? WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, plano.getNomePlano());
            ps.setDouble(2, plano.getValorMensal());
            ps.setLong(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o plano: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    // Deleta um plano pelo ID
    public void delete(Long id) {
        String sql = "DELETE FROM planos WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o plano: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
}

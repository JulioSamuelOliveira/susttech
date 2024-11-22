package br.com.fiap.dao;

import br.com.fiap.to.MotorRecomendacaoTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorRecomendacaoDAO extends Repository {

    public MotorRecomendacaoTO save(MotorRecomendacaoTO recomendacao) {
        String sql = "INSERT INTO recomendacoes (recomendacao) VALUES (?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, recomendacao.getRecomendacao());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                recomendacao.setId(rs.getLong(1));
            }
            return recomendacao;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar a recomendação: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public void update(Long id, MotorRecomendacaoTO recomendacao) {
        String sql = "UPDATE recomendacoes SET recomendacao = ? WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, recomendacao.getRecomendacao());
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a recomendação: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public MotorRecomendacaoTO findById(Long id) {
        String sql = "SELECT * FROM recomendacoes WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MotorRecomendacaoTO recomendacao = new MotorRecomendacaoTO();
                recomendacao.setId(rs.getLong("id"));
                recomendacao.setRecomendacao(rs.getString("recomendacao"));
                return recomendacao;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a recomendação: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public List<MotorRecomendacaoTO> findAll() {
        List<MotorRecomendacaoTO> recomendacoes = new ArrayList<>();
        String sql = "SELECT * FROM recomendacoes";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MotorRecomendacaoTO recomendacao = new MotorRecomendacaoTO();
                recomendacao.setId(rs.getLong("id"));
                recomendacao.setRecomendacao(rs.getString("recomendacao"));
                recomendacoes.add(recomendacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar recomendações: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return recomendacoes;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM recomendacoes WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar a recomendação: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
}

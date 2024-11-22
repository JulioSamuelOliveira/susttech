package br.com.fiap.dao;

import br.com.fiap.to.AparelhoTO;
import java.sql.*;
import java.util.ArrayList;

public class AparelhoDAO extends Repository {

    public AparelhoTO save(AparelhoTO aparelho) {
        String sql = "INSERT INTO aparelhos (tipo, marca, potencia, horas_uso_mensal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, aparelho.getTipo());
            ps.setString(2, aparelho.getMarca());
            ps.setDouble(3, aparelho.getPotencia());
            ps.setInt(4, aparelho.getHorasUsoMensal());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                aparelho.setId(rs.getLong(1));
            }
            return aparelho;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar aparelho: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public AparelhoTO findById(Long id) {
        AparelhoTO aparelho = null;
        String sql = "SELECT * FROM aparelhos WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                aparelho = new AparelhoTO();
                aparelho.setId(rs.getLong("id"));
                aparelho.setTipo(rs.getString("tipo"));
                aparelho.setMarca(rs.getString("marca"));
                aparelho.setPotencia(rs.getDouble("potencia"));
                aparelho.setHorasUsoMensal(rs.getInt("horas_uso_mensal"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aparelho por ID: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return aparelho;
    }

    public ArrayList<AparelhoTO> findAll() {
        ArrayList<AparelhoTO> aparelhos = new ArrayList<>();
        String sql = "SELECT * FROM aparelhos ORDER BY id";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AparelhoTO aparelho = new AparelhoTO();
                aparelho.setId(rs.getLong("id"));
                aparelho.setTipo(rs.getString("tipo"));
                aparelho.setMarca(rs.getString("marca"));
                aparelho.setPotencia(rs.getDouble("potencia"));
                aparelho.setHorasUsoMensal(rs.getInt("horas_uso_mensal"));
                aparelhos.add(aparelho);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar aparelhos: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return aparelhos;
    }

    public boolean update(AparelhoTO aparelho) {
        String sql = "UPDATE aparelhos SET tipo = ?, marca = ?, potencia = ?, horas_uso_mensal = ? WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, aparelho.getTipo());
            ps.setString(2, aparelho.getMarca());
            ps.setDouble(3, aparelho.getPotencia());
            ps.setInt(4, aparelho.getHorasUsoMensal());
            ps.setLong(5, aparelho.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aparelho: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }


    public boolean delete(Long id) {
        String sql = "DELETE FROM aparelhos WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar aparelho: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }
}

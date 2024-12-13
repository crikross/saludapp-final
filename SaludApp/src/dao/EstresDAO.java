package dao;

import modelo.Estres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstresDAO {

    // Insertar estrés
    public boolean insertarEstres(Estres estres) {
        String sql = "INSERT INTO Estres (usuario_id, nivel_estres, motivo) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estres.getUsuarioId());
            stmt.setInt(2, estres.getNivelEstres());
            stmt.setString(3, estres.getMotivo());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar estrés
    public boolean actualizarEstres(Estres estres) {
        String sql = "UPDATE Estres SET nivel_estres = ?, motivo = ? WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, estres.getNivelEstres());
            stmt.setString(2, estres.getMotivo());
            stmt.setInt(3, estres.getUsuarioId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar estrés
    public boolean eliminarEstres(int usuarioId) {
        String sql = "DELETE FROM Estres WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener estrés por usuario
    public Estres obtenerEstresPorUsuario(int usuarioId) {
        String sql = "SELECT * FROM Estres WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Estres estres = new Estres();
                    estres.setUsuarioId(rs.getInt("usuario_id"));
                    estres.setNivelEstres(rs.getInt("nivel_estres"));
                    estres.setMotivo(rs.getString("motivo"));
                    return estres;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean usuarioExiste(int usuarioId) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

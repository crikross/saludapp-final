package dao;

import modelo.SignosVitales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignosVitalesDAO {
    
    // Insertar signos vitales
    public boolean insertarSignosVitales(SignosVitales signos) {
        String sql = "INSERT INTO SignosVitales (usuario_id, pulsaciones, presion_arterial) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, signos.getUsuarioId());
            stmt.setInt(2, signos.getPulsaciones());
            stmt.setInt(3, signos.getPresionArterial());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar signos vitales
    public boolean actualizarSignosVitales(SignosVitales signos) {
        String sql = "UPDATE SignosVitales SET pulsaciones = ?, presion_arterial = ? WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, signos.getPulsaciones());
            stmt.setInt(2, signos.getPresionArterial());
            stmt.setInt(3, signos.getUsuarioId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar signos vitales
    public boolean eliminarSignosVitales(int usuarioId) {
        String sql = "DELETE FROM SignosVitales WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener signos vitales por usuario
    public SignosVitales obtenerSignosVitalesPorUsuario(int usuarioId) {
        String sql = "SELECT * FROM SignosVitales WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    SignosVitales signos = new SignosVitales();
                    signos.setUsuarioId(rs.getInt("usuario_id"));
                    signos.setPulsaciones(rs.getInt("pulsaciones"));
                    signos.setPresionArterial(rs.getInt("presion_arterial"));
                    return signos;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

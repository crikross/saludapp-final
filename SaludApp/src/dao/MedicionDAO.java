package dao;

import modelo.Medicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MedicionDAO {

    // Insertar medición
    public boolean insertarMedicion(Medicion medicion) {
        String sql = "INSERT INTO mediciones (usuario_id, pulsaciones, pasos, nivel_estres, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medicion.getUsuarioId());
            stmt.setInt(2, medicion.getPulsaciones());
            stmt.setInt(3, medicion.getPasos());
            stmt.setInt(4, medicion.getNivelEstres());
            stmt.setTimestamp(5, medicion.getFechaRegistro());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();  
            return false;
        }
    }

    // Actualizar medición
    public boolean actualizarMedicion(Medicion medicion) {
        String sql = "UPDATE Medicion SET pulsaciones = ?, pasos = ?, nivel_estres = ?, fecha_registro = ? WHERE medicion_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medicion.getPulsaciones());
            stmt.setInt(2, medicion.getPasos());
            stmt.setInt(3, medicion.getNivelEstres());
            stmt.setTimestamp(4, medicion.getFechaRegistro());
            stmt.setInt(5, medicion.getMedicionId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();  
            return false;
        }
    }

    // Eliminar medición
    public boolean eliminarMedicion(int medicionId) {
        String sql = "DELETE FROM Medicion WHERE medicion_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medicionId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();  
            return false;
        }
    }

    public Medicion obtenerMedicionPorUsuario(int usuarioId) {
    String sql = "SELECT * FROM mediciones WHERE usuario_id = ?";
    try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, usuarioId);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Medicion medicion = new Medicion();
                medicion.setMedicionId(rs.getInt("medicion_id"));
                medicion.setUsuarioId(rs.getInt("usuario_id"));
                medicion.setPulsaciones(rs.getInt("pulsaciones"));
                medicion.setPasos(rs.getInt("pasos"));
                medicion.setNivelEstres(rs.getInt("nivel_estres"));
                medicion.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                return medicion;
            }
        }
    } catch (SQLException e) {
        System.err.println("Error SQL: " + e.getMessage());
        e.printStackTrace();
    }
    return null;
}

}

package dao;

import modelo.ActividadFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadFisicaDAO {

    private static final Logger logger = Logger.getLogger(ActividadFisicaDAO.class.getName());

    // Insertar actividad
    public boolean insertarActividad(ActividadFisica actividad) {
        String sql = "INSERT INTO ActividadFisica (usuario_id, pasos, distancia, calorias_quemadas) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actividad.getUsuarioId());
            stmt.setInt(2, actividad.getPasos());
            stmt.setFloat(3, actividad.getDistancia());
            stmt.setFloat(4, actividad.getCaloriasQuemadas());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al insertar actividad", e);
            return false;
        }
    }

    // Actualizar actividad
    public boolean actualizarActividad(ActividadFisica actividad) {
        String sql = "UPDATE ActividadFisica SET pasos = ?, distancia = ?, calorias_quemadas = ? WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actividad.getPasos());
            stmt.setFloat(2, actividad.getDistancia());
            stmt.setFloat(3, actividad.getCaloriasQuemadas());
            stmt.setInt(4, actividad.getUsuarioId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar actividad", e);
            return false;
        }
    }

    // Eliminar actividad
    public boolean eliminarActividad(int usuarioId) {
        String sql = "DELETE FROM ActividadFisica WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar actividad", e);
            return false;
        }
    }

    // Obtener actividad por usuario
    public ActividadFisica obtenerActividadPorUsuario(int usuarioId) {
        String sql = "SELECT usuario_id, pasos, distancia, calorias_quemadas FROM ActividadFisica WHERE usuario_id = ?";
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ActividadFisica actividad = new ActividadFisica();
                    actividad.setUsuarioId(rs.getInt("usuario_id"));
                    actividad.setPasos(rs.getInt("pasos"));
                    actividad.setDistancia(rs.getFloat("distancia"));
                    actividad.setCaloriasQuemadas(rs.getFloat("calorias_quemadas"));
                    return actividad;
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener actividad por usuario", e);
        }
        return null;
    }
}

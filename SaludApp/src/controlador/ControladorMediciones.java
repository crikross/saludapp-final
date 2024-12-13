package controlador;

import dao.MedicionDAO;
import modelo.Medicion;

public class ControladorMediciones {

    // Registrar una medición
    public boolean registrarMedicion(Medicion medicion) {
        MedicionDAO medicionDAO = new MedicionDAO();
        try {
            return medicionDAO.insertarMedicion(medicion);
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
    }
    
    // Actualizar una medición
    public boolean actualizarMedicion(Medicion medicion) {
        MedicionDAO medicionDAO = new MedicionDAO();
        try {
            return medicionDAO.actualizarMedicion(medicion);
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar una medición
    public boolean eliminarMedicion(int medicionId) {
        MedicionDAO medicionDAO = new MedicionDAO();
        try {
            return medicionDAO.eliminarMedicion(medicionId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener medición por usuario
    public Medicion obtenerMedicionPorUsuario(int usuarioId) {
        MedicionDAO medicionDAO = new MedicionDAO();
        try {
            return medicionDAO.obtenerMedicionPorUsuario(usuarioId);
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}


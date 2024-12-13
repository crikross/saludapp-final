package controlador;

import dao.ActividadFisicaDAO;
import modelo.ActividadFisica;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorActividadFisica {

    private static final Logger logger = Logger.getLogger(ControladorActividadFisica.class.getName());
    private final ActividadFisicaDAO actividadDAO;

    // Constructor para inyectar la dependencia del DAO
    public ControladorActividadFisica(ActividadFisicaDAO actividadDAO) {
        this.actividadDAO = actividadDAO;
    }

    // Método para registrar la actividad física
    public boolean registrarActividadFisica(int usuarioId, int pasos, float distancia, float calorias) {
        // Crear un objeto de la clase ActividadFisica
        ActividadFisica actividad = new ActividadFisica();
        actividad.setUsuarioId(usuarioId);
        actividad.setPasos(pasos);
        actividad.setDistancia(distancia);
        actividad.setCaloriasQuemadas(calorias);
        
        
        try {
            return actividadDAO.insertarActividad(actividad);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al registrar actividad física", e);
            return false;
        }
    }

    // Método para actualizar la actividad
    public boolean actualizarActividad(ActividadFisica actividad) {
        try {
            return actividadDAO.actualizarActividad(actividad);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar actividad", e);
            return false;
        }
    }

}

package controlador;

import dao.SignosVitalesDAO;
import modelo.SignosVitales;
import java.sql.Timestamp;

public class ControladorSignosVitales {

    private SignosVitalesDAO signosVitalesDAO;

    public ControladorSignosVitales() {
        this.signosVitalesDAO = new SignosVitalesDAO();
    }

    // Método para registrar los signos vitales
    public boolean registrarSignosVitales(int usuarioId, int pulsaciones, int presionArterial) {
        Timestamp fechaRegistro = new Timestamp(System.currentTimeMillis()); 
        SignosVitales signos = new SignosVitales(0, usuarioId, pulsaciones, presionArterial, fechaRegistro); 
        return signosVitalesDAO.insertarSignosVitales(signos);
    }

// Método para actualizar los signos vitales
    public boolean actualizarSignosVitales(int usuarioId, int pulsaciones, int presionArterial) {
        Timestamp fechaRegistro = new Timestamp(System.currentTimeMillis()); // Fecha actual
        SignosVitales signos = new SignosVitales(0, usuarioId, pulsaciones, presionArterial, fechaRegistro); 
        return signosVitalesDAO.actualizarSignosVitales(signos);
    }

    // Método para obtener los signos vitales
    public SignosVitales obtenerSignosVitales(int usuarioId) {
        return signosVitalesDAO.obtenerSignosVitalesPorUsuario(usuarioId);
    }

    // Método para eliminar los signos vitales
    public boolean eliminarSignosVitales(int usuarioId) {
        return signosVitalesDAO.eliminarSignosVitales(usuarioId);
    }
}

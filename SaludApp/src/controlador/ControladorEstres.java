package controlador;

import dao.EstresDAO;
import modelo.Estres;

public class ControladorEstres {

    private EstresDAO estresDAO;

    public ControladorEstres(EstresDAO estresDAO) {
        this.estresDAO = estresDAO;
    }

    public boolean registrarEstres(Estres estres) {
        // Verificar si el usuario existe
        if (!estresDAO.usuarioExiste(estres.getUsuarioId())) {
            System.out.println("El usuario no existe en la base de datos.");
            return false; 
        }

        return estresDAO.insertarEstres(estres);
    }

    public boolean actualizarEstres(Estres estres) {
        if (!estresDAO.usuarioExiste(estres.getUsuarioId())) {
            System.out.println("El usuario no existe en la base de datos.");
            return false; 
        }

        return estresDAO.actualizarEstres(estres);
    }
    
}

package vista;

import controlador.ControladorActividadFisica;
import dao.ActividadFisicaDAO;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame {

    public MainView() {
        setTitle("Menú Principal - SaludApp");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1)); // Cambiamos a 6 filas para incluir el nuevo botón
        setResizable(false);

        // Creación de botones
        JButton btnRegistroUsuarios = new JButton("Registrar Usuarios");
        JButton btnActividadFisica = new JButton("Registrar Actividad Física");
        JButton btnEstres = new JButton("Registrar Estrés");
        JButton btnSignosVitales = new JButton("Registrar Signos Vitales");
        JButton btnMediciones = new JButton("Registrar Mediciones");
        JButton btnCrearDiagnostico = new JButton("Crear Diagnóstico");

        // Acción para el botón de "Registrar Actividad Física"
        btnActividadFisica.addActionListener(e -> {   
            new RegistroActividadFisica(1).setVisible(true);  
        });

        // Añadir las acciones para los otros botones
        btnRegistroUsuarios.addActionListener(e -> new RegistroUsuarios().setVisible(true));
        btnEstres.addActionListener(e -> new RegistroEstres().setVisible(true));
        btnSignosVitales.addActionListener(e -> new RegistroSignosVitales().setVisible(true));
        btnMediciones.addActionListener(e -> new RegistroMediciones().setVisible(true));
        btnCrearDiagnostico.addActionListener(e -> new CrearDiagnosticoView().setVisible(true));

        // Añadir los botones al JFrame
        add(btnRegistroUsuarios);
        add(btnActividadFisica);
        add(btnEstres);
        add(btnSignosVitales);
        add(btnMediciones);
        add(btnCrearDiagnostico);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}

package vista;

import controlador.ControladorActividadFisica;
import dao.ActividadFisicaDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistroActividadFisica extends JFrame {

    private JTextField txtPasos, txtDistancia, txtCalorias;
    private JButton btnRegistrar;

    public RegistroActividadFisica(int usuarioId) {
        setTitle("Registrar Actividad Física");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));  // Usamos GridLayout para organizar los componentes
        setResizable(false);

        // Etiquetas y campos de texto
        JLabel lblPasos = new JLabel("Pasos:");
        txtPasos = new JTextField();

        JLabel lblDistancia = new JLabel("Distancia (km):");
        txtDistancia = new JTextField();

        JLabel lblCalorias = new JLabel("Calorías Quemadas:");
        txtCalorias = new JTextField();

        // Botón de registro
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarActividadFisica(usuarioId));  // Llamamos al método de registro

        // Añadimos los componentes al frame
        add(lblPasos);
        add(txtPasos);
        add(lblDistancia);
        add(txtDistancia);
        add(lblCalorias);
        add(txtCalorias);
        add(new JLabel());  // Espacio vacío para alineación
        add(btnRegistrar);

        // Centramos la ventana
        setLocationRelativeTo(null);
        setVisible(true);  // Asegúrate de que la ventana se vea
    }

    private void registrarActividadFisica(int usuarioId) {
        try {
            // Obtención de los valores ingresados
            int pasos = Integer.parseInt(txtPasos.getText());
            float distancia = Float.parseFloat(txtDistancia.getText());
            float calorias = Float.parseFloat(txtCalorias.getText());

            // Verificar si los valores son positivos
            if (pasos <= 0 || distancia <= 0 || calorias <= 0) {
                JOptionPane.showMessageDialog(this, "Los valores deben ser positivos.");
                return;
            }

            // Crear una instancia de ActividadFisicaDAO
            ActividadFisicaDAO actividadDAO = new ActividadFisicaDAO();
            
            // Crear el controlador y registrar la actividad
            ControladorActividadFisica controlador = new ControladorActividadFisica(actividadDAO);
            boolean exito = controlador.registrarActividadFisica(usuarioId, pasos, distancia, calorias);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Actividad Física registrada exitosamente.");
                limpiarCampos();  // Limpiar campos después de registro exitoso
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la Actividad Física.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.");
        }
    }

    // Método para limpiar los campos de texto
    private void limpiarCampos() {
        txtPasos.setText("");
        txtDistancia.setText("");
        txtCalorias.setText("");
    }
}

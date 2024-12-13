package vista;

import controlador.ControladorMediciones;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Medicion;

public class RegistroMediciones extends JFrame {

    private JTextField txtUsuarioId, txtPulsaciones, txtPasos, txtNivelEstres;
    private JButton btnRegistrar;

    public RegistroMediciones() {
        setTitle("Registrar Mediciones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel lblUsuarioId = new JLabel("ID Usuario:");
        lblUsuarioId.setBounds(20, 20, 100, 25);
        add(lblUsuarioId);

        txtUsuarioId = new JTextField();
        txtUsuarioId.setBounds(150, 20, 200, 25);
        add(txtUsuarioId);

        JLabel lblPulsaciones = new JLabel("Pulsaciones:");
        lblPulsaciones.setBounds(20, 60, 100, 25);
        add(lblPulsaciones);

        txtPulsaciones = new JTextField();
        txtPulsaciones.setBounds(150, 60, 200, 25);
        add(txtPulsaciones);

        JLabel lblPasos = new JLabel("Pasos:");
        lblPasos.setBounds(20, 100, 100, 25);
        add(lblPasos);

        txtPasos = new JTextField();
        txtPasos.setBounds(150, 100, 200, 25);
        add(txtPasos);

        JLabel lblNivelEstres = new JLabel("Nivel de Estrés:");
        lblNivelEstres.setBounds(20, 140, 100, 25);
        add(lblNivelEstres);

        txtNivelEstres = new JTextField();
        txtNivelEstres.setBounds(150, 140, 200, 25);
        add(txtNivelEstres);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 200, 100, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarMediciones();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarMediciones() {
        try {
            int usuarioId = Integer.parseInt(txtUsuarioId.getText()); 
            int pulsaciones = Integer.parseInt(txtPulsaciones.getText());
            int pasos = Integer.parseInt(txtPasos.getText());
            int nivelEstres = Integer.parseInt(txtNivelEstres.getText());

            if (pulsaciones < 0 || pasos < 0 || nivelEstres < 1 || nivelEstres > 10) {
                JOptionPane.showMessageDialog(this, "Los valores ingresados no son válidos.");
                return;
            }

            // Crear el objeto Medicion con los valores ingresados
            Medicion medicion = new Medicion(usuarioId, pulsaciones, pasos, nivelEstres);

            // Llamar al controlador para registrar la medición
            ControladorMediciones controlador = new ControladorMediciones();
            boolean exito = controlador.registrarMedicion(medicion);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Mediciones registradas exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar las mediciones.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.");
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;

import controlador.ControladorSignosVitales;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroSignosVitales extends JFrame {

    private JTextField txtPulsaciones, txtPresionArterial;
    private JButton btnRegistrar;

    public RegistroSignosVitales() {
        setTitle("Registrar Signos Vitales");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        
        JLabel lblPulsaciones = new JLabel("Pulsaciones:");
        lblPulsaciones.setBounds(20, 60, 100, 25);
        add(lblPulsaciones);

        txtPulsaciones = new JTextField();
        txtPulsaciones.setBounds(150, 60, 200, 25);
        add(txtPulsaciones);

        JLabel lblPresionArterial = new JLabel("Presión Arterial:");
        lblPresionArterial.setBounds(20, 100, 100, 25);
        add(lblPresionArterial);

        txtPresionArterial = new JTextField();
        txtPresionArterial.setBounds(150, 100, 200, 25);
        add(txtPresionArterial);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 150, 100, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarSignosVitales();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarSignosVitales() {
    try {
        // Obtener los valores ingresados
        int pulsaciones = Integer.parseInt(txtPulsaciones.getText());
        int presionArterial = Integer.parseInt(txtPresionArterial.getText());

    
        int usuarioId = 1;

        // Crear el controlador y registrar los signos vitales
        ControladorSignosVitales controlador = new ControladorSignosVitales();
        boolean exito = controlador.registrarSignosVitales(usuarioId, pulsaciones, presionArterial);

        // Mostrar mensaje de éxito o error
        if (exito) {
            JOptionPane.showMessageDialog(this, "Signos vitales registrados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar los signos vitales.");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.");
    }
}

}

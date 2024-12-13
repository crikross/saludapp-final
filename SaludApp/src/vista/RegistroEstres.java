package vista;

import controlador.ControladorEstres;
import dao.EstresDAO; 
import modelo.Estres;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Timestamp;

public class RegistroEstres extends JFrame {

    private JTextField txtNivelEstres, txtMotivo, txtUsuarioId;
    private JButton btnRegistrar;

    public RegistroEstres() {
        setTitle("Registrar Nivel de Estrés");
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Crear la instancia de EstresDAO y ControladorEstres
        EstresDAO estresDAO = new EstresDAO();
        ControladorEstres controlador = new ControladorEstres(estresDAO);

        // Etiquetas y campos de texto
        JLabel lblUsuarioId = new JLabel("Usuario ID:");
        lblUsuarioId.setBounds(20, 20, 100, 25);
        add(lblUsuarioId);

        txtUsuarioId = new JTextField();
        txtUsuarioId.setBounds(150, 20, 200, 25);
        add(txtUsuarioId);

        JLabel lblNivelEstres = new JLabel("Nivel de Estrés:");
        lblNivelEstres.setBounds(20, 60, 100, 25);
        add(lblNivelEstres);

        txtNivelEstres = new JTextField();
        txtNivelEstres.setBounds(150, 60, 200, 25);
        add(txtNivelEstres);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(20, 100, 100, 25);
        add(lblMotivo);

        txtMotivo = new JTextField();
        txtMotivo.setBounds(150, 100, 200, 25);
        add(txtMotivo);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 150, 100, 30);
        add(btnRegistrar);

        // Acción del botón
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEstres(controlador);
            }
        });

        // Centrar la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarEstres(ControladorEstres controlador) {
    try {
        // Validación de nivel de estrés
        int nivelEstres = Integer.parseInt(txtNivelEstres.getText());
        if (nivelEstres < 0 || nivelEstres > 10) { 
            JOptionPane.showMessageDialog(this, "El nivel de estrés debe estar entre 0 y 10.");
            return;
        }

        String motivo = txtMotivo.getText();
        if (motivo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un motivo.");
            return;
        }

        // Obtener el usuarioId desde el campo de texto
        int usuarioId;
        try {
            usuarioId = Integer.parseInt(txtUsuarioId.getText()); // Obtener el valor de usuarioId
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para el ID de usuario.");
            return;
        }

        // Crear un objeto Estres con los datos
        Timestamp fechaRegistro = new Timestamp(System.currentTimeMillis()); 
        Estres estres = new Estres(0, usuarioId, nivelEstres, motivo, fechaRegistro); 

        // Verificar si el usuario existe antes de registrar
        if (!controlador.registrarEstres(estres)) {
            JOptionPane.showMessageDialog(this, "El usuario no existe.");
            return;
        }

        // Llamar al controlador para registrar el estrés
        boolean exito = controlador.registrarEstres(estres);

        // Mostrar el resultado
        if (exito) {
            JOptionPane.showMessageDialog(this, "Nivel de Estrés registrado exitosamente.");
            limpiarCampos();  // Limpiar los campos después de registro exitoso
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el Nivel de Estrés.");
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para el nivel de estrés.");
    }
}

    // Método para limpiar los campos de texto
    private void limpiarCampos() {
        txtNivelEstres.setText("");
        txtMotivo.setText("");
        txtUsuarioId.setText("");
    }

}

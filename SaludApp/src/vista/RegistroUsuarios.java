/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroUsuarios extends JFrame {

    private JTextField txtNombre, txtCorreo, txtContrasena;
    private JButton btnRegistrar;

    public RegistroUsuarios() {
        setTitle("Registrar Usuario");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 200, 25);
        add(txtNombre);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(20, 60, 100, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 60, 200, 25);
        add(txtCorreo);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(20, 100, 100, 25);
        add(lblContrasena);

        txtContrasena = new JTextField();
        txtContrasena.setBounds(150, 100, 200, 25);
        add(txtContrasena);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 150, 100, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarUsuario() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        ControladorRegistro controlador = new ControladorRegistro();
        boolean exito = controlador.registrarUsuario(nombre, correo, contrasena);

        // Mostrar mensaje según el resultado del registro
        if (exito) {
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            this.dispose(); // Cierra la ventana de registro
            new Login().setVisible(true); // Abre la ventana de login
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

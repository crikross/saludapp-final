/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ControladorRegistro;

public class Login extends JFrame {

    private JTextField txtId;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private ControladorRegistro controlador;

    public Login() {
        setTitle("Iniciar Sesión");
        setSize(400, 300); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245)); 
        add(panel);

        controlador = new ControladorRegistro();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel lblId = new JLabel("Usuario o Correo:");
        JLabel lblPassword = new JLabel("Contraseña:");

        txtId = new JTextField(20);
        txtPassword = new JPasswordField(20);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBackground(new Color(30, 144, 255)); 
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setFocusPainted(false); 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lblId, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(txtId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(txtPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnLogin, gbc);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String id = txtId.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (id.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        System.out.println("Intentando login con ID: " + id + " y contraseña: " + password);

        if (controlador.validarCredenciales(id, password)) {
            JOptionPane.showMessageDialog(this, "Login exitoso");
            dispose();
            new MainView().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas. Intente de nuevo.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}

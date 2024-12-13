/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import dao.Conexion;
import dao.UsuariosDAO;
import modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ControladorRegistro {

    public boolean registrarUsuario(String nombre, String correo, String contrasena) {
        if (nombre == null || nombre.isEmpty() || correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            System.out.println("Error: Los datos del usuario no son válidos.");
            return false;
        }

        UsuariosDAO usuariosDAO = new UsuariosDAO();

        if (usuariosDAO.existeCorreo(correo)) {
            System.out.println("Error: El correo ya está registrado.");
            return false;
        }

        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);

        return usuariosDAO.insertarUsuario(usuario);
    }

    public Usuarios obtenerUsuarioPorId(int id) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        Usuarios usuario = usuariosDAO.obtenerUsuarioPorId(id);

        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("ID: " + usuario.getUsuarioId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println("Fecha de registro: " + usuario.getFecha());
        } else {
            System.out.println("Usuario no encontrado.");
        }

        return usuario;
    }

    public boolean validarCredenciales(String id, String password) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        return usuariosDAO.validarCredenciales(id, password);
    }

    //******************************//
    public List<Object[]> obtenerDatosCompletosUsuario(int usuarioId) {
        List<Object[]> datos = new ArrayList<>();

        // Consulta para obtener solo nombre, correo y fecha de registro
        String query = """
        SELECT u.nombre, u.correo, u.fecha_registro
        FROM Usuarios u
        WHERE u.usuario_id = ?
    """;

        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, usuarioId); // Establecer el usuarioId

            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                // Si encontramos datos del usuario
                if (rs.next()) {
                    // Agregar los datos del usuario (nombre, correo y fecha de registro)
                    datos.add(new Object[]{
                        rs.getString("nombre"), // Nombre del usuario
                        rs.getString("correo"), // Correo del usuario
                        rs.getString("fecha_registro") // Fecha de registro
                    });
                } else {
                    System.out.println("No se encontraron datos para el usuario.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datos;
    }
}
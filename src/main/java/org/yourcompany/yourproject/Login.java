package org.yourcompany.yourproject;

import javax.swing.JOptionPane;

public class Login {

    private static final String USUARIO_CORRECTO = "cliente";
    private static final String CONTRASENA_CORRECTA = "prestamo";
    private static final int MAX_INTENTOS = 3;

    public static boolean iniciarSesion() {
        int intentos = 0;

        while (intentos < MAX_INTENTOS) {
            String usuario = JOptionPane.showInputDialog(null, "Por favor ingrese su usuario:", "Inicio de Sesión", JOptionPane.QUESTION_MESSAGE);

            if (usuario == null) {
                int confirmarSalir = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar el inicio de sesión?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirmarSalir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión cancelado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                } else {
                    continue;
                }
            }

            String contrasena = JOptionPane.showInputDialog(null, "Por favor ingrese su contraseña:", "Inicio de Sesión", JOptionPane.QUESTION_MESSAGE);

            if (contrasena == null) {
                int confirmarSalir = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar el inicio de sesión?", "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirmarSalir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión cancelado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                } else {
                    continue;
                }
            }

            if (usuario.equals(USUARIO_CORRECTO) && contrasena.equals(CONTRASENA_CORRECTA)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido al simulador de préstamos bancarios!", "Inicio de Sesión Exitoso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                intentos++;
                String errorMessage = String.format("Usuario o contraseña incorrectos. Intento %d de %d", intentos, MAX_INTENTOS);
                if (intentos == MAX_INTENTOS) {
                    errorMessage += "\nSe han realizado demasiados intentos fallidos. El sistema se cerrará.";
                }
                JOptionPane.showMessageDialog(null, errorMessage, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }
        }

        return false;
    }
}
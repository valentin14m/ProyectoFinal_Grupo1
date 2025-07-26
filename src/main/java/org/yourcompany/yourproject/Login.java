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
            String contrasena = JOptionPane.showInputDialog(null, "Por favor ingrese su contraseña:", "Inicio de Sesión", JOptionPane.QUESTION_MESSAGE);

            if (usuario == null || contrasena == null) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión cancelado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            if (usuario.equals(USUARIO_CORRECTO) && contrasena.equals(CONTRASENA_CORRECTA)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido al simulador de prestamos bancarios!", "Inicio de Sesión Exitoso", JOptionPane.INFORMATION_MESSAGE  );
                return true;
            } else {
                intentos++;
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Intento " + intentos + " de " + MAX_INTENTOS, "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null, "Se han realizado demasiados intentos fallidos. El sistema se cerrará.");
        return false;
    }
}
package org.yourcompany.yourproject;

import javax.swing.JOptionPane;

public class Menu {

    public static void mostrar() {
        String[] opciones = {
            "Iniciar simulación de préstamo.",
            "Información sobre el simulador.",
            "Salir del simulador."
        };

        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (opcion) {
                case 0:
                    mostrarSubmenuSimulador();
                    break;
                case 1:
                    mostrarInformacion();
                    break;
                case 2:
                case JOptionPane.CLOSED_OPTION:
                    int confirmacion = JOptionPane.showConfirmDialog(
                        null, 
                        "¿Está seguro de que desea salir?", 
                        "Confirmación de salida", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE
                    );
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Muchas gracias por usar el simulador de préstamos bancarios. ¡Hasta luego!", "Salir", JOptionPane.INFORMATION_MESSAGE);
                        return; // Salir del programa
                    }
                    break;
            }

        } while (opcion != 2 && opcion != JOptionPane.CLOSED_OPTION);
    }

    private static void mostrarSubmenuSimulador() {
        String[] opciones = {
            "Ingresar datos del préstamo.",
            "Ver resultados del préstamo.",
            "Ver cronograma de pagos.",
            "Volver al menú principal."
        };

        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(
                null,
                "Opciones del simulador:",
                "Simulador de Préstamo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (opcion) {
                case 0:
                    Simulador.ingresarDatos();
                    break;
                case 1:
                    Simulador.mostrarResultados();
                    break;
                case 2:
                    Simulador.mostrarCronograma();
                    break;
                case 3:
                case JOptionPane.CLOSED_OPTION:
                    return;
            }

        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }

    private static void mostrarInformacion() {
        String info = """
         ----Simulador de Préstamo Bancario----
            
        Universidad Fidélitas
        Curso: Introducción a la Programación
        Profesor: Ing. Bryan Cerdas Salas

        Características:
        - Calcula cuotas con fórmula de amortización
        - Muestra cronograma mensual
        - Pensado para facilitar decisiones financieras

        Desarrollado por el Grupo 1 – Julio 2025
        """;

        JOptionPane.showMessageDialog(null, info, "Acerca del simulador", JOptionPane.INFORMATION_MESSAGE);
    }
}
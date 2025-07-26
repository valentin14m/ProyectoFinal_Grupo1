package org.yourcompany.yourproject;

import javax.swing.JOptionPane;

public class Menu {

    public static void mostrar() {
        String[] opciones = {
            "Simular préstamo.",
            "Acerca del simulador.",
            "Salir."
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
                    JOptionPane.showMessageDialog(null, "Gracias por usar el simulador.");
                    break;
            }

        } while (opcion != 2 && opcion != JOptionPane.CLOSED_OPTION);
    }

    // Submenú específico del simulador
    private static void mostrarSubmenuSimulador() {
        String[] opciones = {
            "Ingresar datos del préstamo.",
            "Ver resultados.",
            "Ver cronograma de pagos.",
            "Volver."
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
                    return; // Regresar al menú principal
            }

        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }

    private static void mostrarInformacion() {
        String info = """
        Simulador de Préstamos Bancarios
        
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
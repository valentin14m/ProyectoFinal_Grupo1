package org.yourcompany.yourproject;

import javax.swing.JOptionPane;

public class Simulador {
    private static Prestamo prestamoActual;
    private static double cuotaMensualCache;
    private static double costoTotalCache;

    public static void ingresarDatos() {
        try {
            String tipo = pedirTipoPrestamo();
            if (tipo == null) return;

            double monto = solicitarDouble(
                "Ingrese el monto solicitado (mayor a 0):",
                0.01, 1_000_000_000
            );

            double tasaAnual = solicitarDouble(
                "Ingrese la tasa de interés anual en % (ej. 12.5):",
                0.0001, 100.0
            );

            int plazoMeses = solicitarEntero(
                "Ingrese el plazo en meses (1 a 600):",
                1, 600
            );

            prestamoActual = new Prestamo(monto, tasaAnual, plazoMeses, tipo);
            cuotaMensualCache = prestamoActual.calcularCuotaMensual();
            costoTotalCache  = prestamoActual.calcularCostoTotal();

            String resumen = String.format(
                """
                Datos guardados:

                Tipo: %s
                Monto: %.2f
                Tasa anual: %.2f%%
                Plazo: %d meses

                Cuota estimada: %.2f
                """,
                tipo, monto, tasaAnual, plazoMeses, cuotaMensualCache
            );

            JOptionPane.showMessageDialog(null, resumen, "Datos del préstamo", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al ingresar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void mostrarResultados() {
        if (prestamoActual == null) {
            JOptionPane.showMessageDialog(null, "Primero ingrese los datos del préstamo.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double monto = prestamoActual.getMonto();
        double interesesTotales = costoTotalCache - monto;

        String info = String.format(
            """
            --- Resultados del Préstamo ---

            Tipo: %s
            Monto: %.2f
            Tasa anual: %.2f%%
            Plazo: %d meses

            Cuota mensual: %.2f
            Costo total:  %.2f
            Intereses:    %.2f
            """,
            prestamoActual.getTipoPrestamo(),
            monto,
            prestamoActual.getTasaAnual(),
            prestamoActual.getPlazoMeses(),
            cuotaMensualCache,
            costoTotalCache,
            interesesTotales
        );

        JOptionPane.showMessageDialog(null, info, "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarCronograma() {
        if (prestamoActual == null) {
            JOptionPane.showMessageDialog(null, "Primero ingrese los datos del préstamo.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cronograma = prestamoActual.generarCronogramaPagos();

       
        JOptionPane.showMessageDialog(null, cronograma, "Cronograma de Pagos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String pedirTipoPrestamo() {
        String[] tipos = {"Personal", "Hipotecario", "Vehicular", "Educativo", "Otro"};
        String seleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione el tipo de préstamo:",
            "Tipo de préstamo",
            JOptionPane.QUESTION_MESSAGE,
            null,
            tipos,
            tipos[0]
        );
        return seleccionado;
    }

    private static double solicitarDouble(String mensaje, double min, double max) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje, "Entrada requerida", JOptionPane.QUESTION_MESSAGE);
            if (input == null) return -1;
            input = input.trim().replace(",", ".");

            try {
                double val = Double.parseDouble(input);
                if (val < min || val > max) {
                    JOptionPane.showMessageDialog(null, "Valor fuera de rango (" + min + " a " + max + ").", "Dato inválido", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Dato inválido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static int solicitarEntero(String mensaje, int min, int max) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, mensaje, "Entrada requerida", JOptionPane.QUESTION_MESSAGE);
            if (input == null) return -1;
            input = input.trim();

            try {
                int val = Integer.parseInt(input);
                if (val < min || val > max) {
                    JOptionPane.showMessageDialog(null, "Valor fuera de rango (" + min + " a " + max + ").", "Dato inválido", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido.", "Dato inválido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

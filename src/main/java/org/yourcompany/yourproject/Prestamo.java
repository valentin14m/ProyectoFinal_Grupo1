package org.yourcompany.yourproject;

public class Prestamo {
    private double monto;
    private double tasaAnual;
    private int plazoMeses;
    private String tipoPrestamo;

    public Prestamo(double monto, double tasaAnual, int plazoMeses, String tipoPrestamo) {
        this.monto = monto;
        this.tasaAnual = tasaAnual;
        this.plazoMeses = plazoMeses;
        this.tipoPrestamo = tipoPrestamo;
    }

    // Cálculo manual de potencia (evita Math.pow)
    private double potencia(double base, int exponente) {
        double resultado = 1.0;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    public double calcularCuotaMensual() {
        double tasaMensual = (tasaAnual / 100) / 12;
        double base = 1 + tasaMensual;
        double numerador = monto * tasaMensual * potencia(base, plazoMeses);
        double denominador = potencia(base, plazoMeses) - 1;

        if (denominador == 0) {
            return 0.0;
        }

        return numerador / denominador;
    }

    public double calcularCostoTotal() {
        return calcularCuotaMensual() * plazoMeses;
    }

    public String generarCronogramaPagos() {
        double saldo = monto;
        double tasaMensual = (tasaAnual / 100) / 12;
        double cuota = calcularCuotaMensual();
        String cronograma = "Mes\tInterés\t\tCapital\t\tSaldo pendiente\n";

        for (int mes = 1; mes <= plazoMeses; mes++) {
            double interes = saldo * tasaMensual;
            double abonoCapital = cuota - interes;
            saldo -= abonoCapital;

            interes = (int)(interes * 100) / 100.0;
            abonoCapital = (int)(abonoCapital * 100) / 100.0;
            saldo = (int)(saldo * 100) / 100.0;

            cronograma += mes + "\t" + interes + "\t\t" + abonoCapital + "\t\t" + (saldo < 0 ? 0 : saldo) + "\n";
        }

        return cronograma;
    }

    public double getMonto() { return monto; }
    public double getTasaAnual() { return tasaAnual; }
    public int getPlazoMeses() { return plazoMeses; }
    public String getTipoPrestamo() { return tipoPrestamo; }
}
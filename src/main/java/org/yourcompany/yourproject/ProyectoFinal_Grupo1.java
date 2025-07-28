/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

/**
 *
 * @author vmedrano14
 */

// Proyecto Final
// Grupo 1: José Valentín Medrano Páramo, Jose Javier Acuña Laurent, Keisy Shannon Porras Quintero, Bryanna Yael Marin Salazar
// Curso: Introducción a la Programación
// Universidad Fidélitas
// Profesor: Ing. Bryan Cerdas Salas

public class ProyectoFinal_Grupo1 {

    public static void main(String[] args) {
        
        boolean accesoPermitido = Login.iniciarSesion();

        if (accesoPermitido) {
            Menu.mostrar();
        } else {
            System.out.println("Acceso denegado. Se finalizará el programa.");
        }
    }
}

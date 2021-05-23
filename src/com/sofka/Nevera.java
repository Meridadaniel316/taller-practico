package com.sofka;

public class Nevera extends Electrodomesticos{

    int capacidad;

    public void crearNuevaNevera() {
        consumo = "Desconocido";
        procedencia = "Desconocido";
        sujeto = "la";
        electrodomestico = "Nevera";
        capacidad = 120;
        precioAdiccional = 0;
        valor = 0;
        seleccionarConsumoElectrodomestico();
        seleccionarProcedenciaElectrodomestico();
        precioAdiccionalCapacidad();
    }

    public void precioAdiccionalCapacidad(){
        System.out.printf("¿Cual es la capacidad de %s %s? %n",sujeto,electrodomestico);
        capacidad = entrada.nextInt();

        if (capacidad > 120)
        {
            capacidadNeveraAdiccionar();
        }
    }

    private void capacidadNeveraAdiccionar() {
        int capacidadNevera = capacidad - 120;
        this.precioAdiccional += (int) (valor * 0.05)*capacidadNevera;
    }
}

package com.sofka;

public class Televisor extends Electrodomesticos {

    int tdt;
    String tdtTv;
    int sizeTv;

    public void crearNuevoTelevisor() {
        consumo = "Desconocido";
        procedencia = "Desconocido";
        sujeto = "el";
        electrodomestico = "Televisor";
        sizeTv = 40;
        tdtTv = "Desactivado";
        tdt = 2;
        precioAdiccional = 0;
        valor = 0;
        seleccionarConsumoElectrodomestico();
        seleccionarProcedenciaElectrodomestico();
        precioAdiccionalSizeTV();
        precioAdiccionalTdtTV();
    }

    public void precioAdiccionalSizeTV() {

        System.out.printf("¿Que tamaño tiene %s %s? %n", sujeto, electrodomestico);
        sizeTv = entrada.nextInt();
        if (sizeTv > 40) {
            this.precioAdiccional += (int) (valor * 0.3);
        }

    }

    private void precioAdiccionalTdtTV() {
        System.out.printf("¿%s %s tiene TDT? %n1.Si %n2.No %n", sujeto, electrodomestico);
        tdt = entrada.nextInt();

        if (tdt == 1) {
            this.precioAdiccional += 250000;
            tdtTv = "Activado";
        }
    }

}

package com.sofka;

import java.util.*;

import com.extensions.ExtensionsMessage;

public class Electrodomesticos {

    public final Scanner entrada = new Scanner(System.in);
    public final ExtensionsMessage msg = new ExtensionsMessage();

    double consumoA = 450000;
    double consumoB = 350000;
    double consumoC = 250000;
    double procedenciaNacional = 250000;
    double procedenciaImportada = 350000;
    double precioAdiccional;

    double valor;
    String sujeto;
    String consumo;

    String procedencia;
    String electrodomestico;

    boolean menuConsumo;
    boolean menuProcedencia;

    public Electrodomesticos() {
    }

    public void crearNuevoElectrodomestico() {
        this.consumo = "Desconocido";
        this.procedencia = "Desconocido";
        this.sujeto = "el";
        this.electrodomestico = "Electrodomestico";
        this.precioAdiccional = 0;
        this.valor = 0;
        seleccionarConsumoElectrodomestico();
        seleccionarProcedenciaElectrodomestico();
        valorAdiccionalElectrodomestico();
    }

    public void seleccionarConsumoElectrodomestico() {
        do {
            System.out.println("Por favor seleccione que tipo de consumo va a tener " + sujeto + " " + electrodomestico + "(A/B/C):");
            consumo = entrada.nextLine();
            extraerConsumo();
        } while (menuConsumo);
    }

    public void seleccionarProcedenciaElectrodomestico() {
        do {
            System.out.printf("¿Cual es la procedencia de " + sujeto + " " + electrodomestico + "? %n1.Nacional %n2.Importado%n");
            procedencia = entrada.nextLine();
            extraerProcedencia();
        } while (menuProcedencia);
    }

    public void valorAdiccionalElectrodomestico() {
        System.out.printf("¿Desea agregar un valor adiccional en %s %s? %nEl precio total del electrodomestico actualmente es $%s %n", sujeto,electrodomestico,valor);
        String adiccionPrecioElectrodomestico = entrada.nextLine();

        int adiccionPrecio = Integer.parseInt(adiccionPrecioElectrodomestico);

        precioAdiccional += adiccionPrecio;
    }

    private void extraerConsumo() {
        switch (consumo) {
            case "A":
            case "a": {
                this.valor += consumoA;
                menuConsumo = false;
                break;
            }
            case "B":
            case "b": {
                this.valor += consumoB;
                menuConsumo = false;
                break;
            }
            case "C":
            case "c": {
                this.valor += consumoC;
                menuConsumo = false;
                break;
            }
            default: {
                msg.errorSystemCmd();
                menuConsumo = true;
                break;
            }
        }
    }

    private void extraerProcedencia() {
        switch (procedencia) {
            case "1":
            case "Nacional":
            case "nacional": {
                this.valor += procedenciaNacional;
                menuProcedencia = false;
                break;
            }
            case "2":
            case "Importado":
            case "importado": {
                this.valor += procedenciaImportada;
                menuProcedencia = false;
                break;
            }
            default: {
                msg.errorSystemCmd();
                menuProcedencia = true;
                break;
            }
        }
    }

    public String getElectrodomestico() {
        return electrodomestico;
    }

    public double getValor() {
        valor = precioAdiccional + valor;
        return valor;
    }
}
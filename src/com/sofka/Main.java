package com.sofka;

import com.extensions.ExtensionsMessage;

import java.util.*;

public class Main {

    ArrayList<String> lista = new ArrayList<>();
    private final Scanner entrada = new Scanner(System.in);
    private final ExtensionsMessage msg = new ExtensionsMessage();

    private final Electrodomesticos electrodomesticos = new Electrodomesticos();
    private final Nevera nevera = new Nevera();
    private final Televisor televisor = new Televisor();
    private boolean Repeat = false;

    public void menuInicial() {

        do {
            String seleccion = mensajeMenuBienvenida(Repeat);
            Repeat = opcionesDinamicasMenu(seleccion);
        }
        while (true);
    }

    private boolean opcionesDinamicasMenu(String seleccion) {
        switch (seleccion) {
            case "1": {
                extraerDatosNuevoProducto();
                break;
            }
            case "2": {
                leerListaProductos();
                break;
            }
            case "3": {
                exitMenuFacturacion();
            }
            default: {
                msg.errorSystemCmd();
                msg.pressAnyKeyToContinue();
                break;
            }
        }
        return true;
    }

    private void exitMenuFacturacion() {
        System.out.println("Haz cerrado sesión, espero y vuelvas pronto.");
        System.exit(1);
    }

    private void extraerDatosNuevoProducto() {
        msg.clearConsole();
        System.out.println("Haz seleccionado la opción nuevo producto.");
        System.out.printf("¿Que electrodoméstico desea agregar? %n1. Televisor%n2. Nevera%n3. Otro electrodoméstico.%n4. Atras%n");
        String electrodomesticoAdd = entrada.nextLine();
        sustraerDatosNuevoProducto(electrodomesticoAdd);
    }

    private void sustraerDatosNuevoProducto(String electrodomesticoAdd) {
        switch (electrodomesticoAdd) {
            case "1":
                extraerDatosTelevisor();
                break;
            case "2":
                extraerDatosNevera();
                break;
            case "3":
                extraerDatosElectrodomestico();
                break;
            case "4":
                Repeat = true;
                menuInicial();
                break;
            default:
                msg.errorSystemCmd();
                msg.pressAnyKeyToContinue();
                extraerDatosNuevoProducto();
                break;
        }
    }

    private void extraerDatosElectrodomestico() {
        System.out.println("Haz seleccionado otro electrodoméstico");
        electrodomesticos.crearNuevoElectrodomestico();
        String valorDinamico = String.valueOf(electrodomesticos.getValor());
        String electrodomesticoDinamico = electrodomesticos.getElectrodomestico();
        lista.add("    "+ electrodomesticoDinamico +"                $"+ valorDinamico+"\n" +
                "            Valor adiccional: "+electrodomesticos.precioAdiccional);
    }

    private void extraerDatosNevera() {
        System.out.println("Haz seleccionado Nevera");
        nevera.crearNuevaNevera();
        String valorDinamico = String.valueOf(nevera.getValor());
        String electrodomesticoDinamico = nevera.getElectrodomestico();
        lista.add("        "+ electrodomesticoDinamico +"                      $"+ valorDinamico+"\n" +
                "           Capacidad de la nevera: "+nevera.capacidad+"lt\n" +
                "            Valor adiccional: "+nevera.precioAdiccional);
    }

    private void extraerDatosTelevisor() {
        System.out.println("Haz seleccionado Televisor");
        televisor.crearNuevoTelevisor();
        String valorDinamico = String.valueOf(televisor.getValor());
        String electrodomesticoDinamico = televisor.getElectrodomestico();
        lista.add("        "+ electrodomesticoDinamico +"                   $"+ valorDinamico+"\n" +
                "      Tamaño TV: "+televisor.sizeTv+"               TDT: "+televisor.tdtTv+"\n" +
                "            Valor adiccional: "+televisor.precioAdiccional);
    }

    private void leerListaProductos() {
        if (0 < lista.size()) {
            listRegisteredProducts();
        } else {
            noDataRecorded();
        }
    }

    private void listRegisteredProducts() {
        msg.pictureComputer();
        msg.lineaSalto();
        System.out.printf("LISTA DE PRODUCTOS FACTURADOS: %n%n");

        for (String i : lista) {
            System.out.printf("    Electrodomestico    |    Costo electrodomestico   %n");
            System.out.print(i+ "\n" + "\n");
            msg.lineaSalto();
        }
        msg.pressAnyKeyToContinue();
    }

    private void noDataRecorded() {
        msg.clearConsole();
        msg.pictureComputer();
        msg.lineaSalto();
        System.out.println("ACTUALMENTE NO HAY PRODUCTOS EN LA BASE DE DATOS");
        msg.lineaSalto();
        msg.pressAnyKeyToContinue();
    }

    private String mensajeMenuBienvenida(boolean Repeat) {
        msg.clearConsole();
        if (Repeat) {
            msg.pictureRobot();
            msg.lineaSalto();
            System.out.println("¡Hola, bienvenido denuevo al sistema de facturación!");
            msg.lineaSalto();
        } else {
            msg.pictureComputer();
            msg.lineaSalto();
            System.out.println("¡Hola, bienvenido al sistema de facturación!");
            msg.lineaSalto();
        }

        System.out.printf("Por favor selecciona una opción: %n1. Nuevo producto %n2. Ver productos %n3. Cerrar sesión %n");
        return entrada.nextLine();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menuInicial();
    }

}

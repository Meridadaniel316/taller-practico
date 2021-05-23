package com.extensions;

import java.util.*;

public class ExtensionsMessage {

    Scanner entrada = new Scanner(System.in);

    public void pressAnyKeyToContinue()
    {
        System.out.println("<<<Presione ENTER para continuar>>>");
        try
        {
            entrada.nextLine();
        }
        catch(Exception ignored) {}
        clearConsole();
    }

    public void clearConsole()
    {
        for (int i=0; i < 30; i++)

        {
            System.out.println();
        }
    }
    public void lineaSalto() {
        System.out.println("———————————————————————————————————————————————————————————————");
    }

    public void errorSystemCmd()
    {
        clearConsole();
        System.out.printf("%n " +
                "──▄────▄▄▄▄▄▄▄────▄───\n" +
                "─▀▀▄─▄█████████▄─▄▀▀──\n" +
                "─────██─▀███▀─██──────\n" +
                "───▄─▀████▀████▀─▄────\n" +
                "─▀█────██▀█▀██────█▀──\n");
        lineaSalto();
        System.out.printf("HAS SELECCIONADO UNA OPCIÓN ERROREA...%nINTENTA NUEVAMENTE... %n");
        lineaSalto();
    }

    public void pictureComputer(){
        System.out.print("\n" +
                "▐▓█▀▀▀▀▀▀▀▀▀█▓▌░▄▄▄▄▄░\n" +
                "▐▓█░░▀░░▀▄░░█▓▌░█▄▄▄█░\n" +
                "▐▓█░░▄░░▄▀░░█▓▌░█▄▄▄█░\n" +
                "▐▓█▄▄▄▄▄▄▄▄▄█▓▌░█████░\n" +
                "░░░░▄▄███▄▄░░░░░█████░\n");
    }

    public void pictureRobot(){
        System.out.print("\n" +
                "░░░░░░░░░░░░░░░░░░░░░\n" +
                "░░░░░░░▄█▄▄▄█▄░░░░░░░\n" +
                "▄▀░░░░▄▌─▄─▄─▐▄░░░░▀▄  F  A  C  T  U  R  A  C  I  Ó  N\n" +
                "█▄▄█░░▀▌─▀─▀─▐▀░░█▄▄█      D  I  N  A  M  I  C  A\n" +
                "░▐▌░░░░▀▀███▀▀░░░░▐▌\n" +
                "████░▄█████████▄░████\n");
    }
}
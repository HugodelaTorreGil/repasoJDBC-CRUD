package main;

import utils.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileManager fm = new FileManager();

        int opcion;

        do {
            System.out.println("==== CONVERSOR CSV ↔ DAT ====");
            System.out.println("1. CSV → DAT");
            System.out.println("2. DAT → CSV");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("Ruta del CSV de entrada: ");
                    String rutaCsv = sc.nextLine();

                    System.out.print("Ruta del DAT de salida: ");
                    String rutaDat = sc.nextLine();

                    try {
                        ArrayList<String> lineasCsv = fm.leerCSV(rutaCsv);
                        fm.escribirDat(rutaDat, lineasCsv);
                        System.out.println("Conversión CSV → DAT completada.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ruta del DAT de entrada: ");
                    String rutaDat2 = sc.nextLine();

                    System.out.print("Ruta del CSV de salida: ");
                    String rutaCsv2 = sc.nextLine();

                    try {
                        ArrayList<String> lineasDat = fm.leerDat(rutaDat2);
                        fm.escribirCSV(rutaCsv2, lineasDat);
                        System.out.println("Conversión DAT → CSV completada.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}

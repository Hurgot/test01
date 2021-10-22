/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test_01;

import java.util.Scanner;

/**
 *
 * @author HURGOT - BACKEND
 */
public class App1 {

    private final Scanner SCAN = new Scanner(System.in);

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: No ha ingresado un número entero válido.");
            System.exit(0);
            return -1;
        }
    }

    private String getUserInput(String message) {
        System.out.println(message);
        return SCAN.nextLine();
    }

    private String buildArrayString (int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if ((i+1) < arr.length) {
                str += "-";
            }
        }
        return str;
    }
    
    public void run() {
        System.out.println("************ INICIO **************\n");

        String iDays = getUserInput("DIAS:");
        final int days = parseInput(iDays);
        String iHouses = getUserInput("# CASAS:");
        final int nHouses = parseInput(iHouses);
        int houses[] = new int[nHouses];
        
        for (int i = 0; i < nHouses; i++) {
            String nInput = getUserInput("Estado casa #" + (i+1));
            int intInput = parseInput(nInput);
            if (intInput != 0 && intInput != 1) {
                System.out.println("ERROR: Los estados posibles son 0-1");
                System.exit(0);
            } else {
                houses[i] = intInput;
            }
        }
        
        String initialHouses = buildArrayString(houses);

        if (days < 0 || nHouses > 8) {
            System.out.println("ERROR: Los parámetros ingresados no son validos.");
        } else {
            for (int i = 0; i < days; i++) {
                int prevValue = 0;
                int nextValue = 0;

                for (int k = 0; k < houses.length; k++) {
                    if (k < houses.length - 1) {
                        nextValue = houses[k + 1];
                        if (nextValue == prevValue) {
                            prevValue = houses[k];
                            houses[k] = 0;
                        } else {
                            prevValue = houses[k];
                            houses[k] = 1;
                        }
                    } else {
                       if (prevValue == 0) {
                            prevValue = houses[k];
                            houses[k] = 0;
                        } else {
                            prevValue = houses[k];
                            houses[k] = 1;
                        }
                    }
                }
            }
        }
        String finalHouses = buildArrayString(houses);
        System.out.println("ENTRADA: " + initialHouses);
        System.out.println("SALIDA:" + finalHouses);
        
        System.out.println("\n************** FIN ***************");

    }
}

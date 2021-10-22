/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test_01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author HURGOT - BACKEND
 */
public class App2 {

    private final Scanner SCAN = new Scanner(System.in);

    private String getUserInput(String message) {
        System.out.println(message);
        return SCAN.nextLine();
    }

    public static void permute(String a, LinkedList<String> per) {
        if (per.size() == 1) {
            System.out.println(a+per.get(0));
        }
        for (int i = 0; i < per.size(); i++) {
            String b = per.remove(i);
            permute(a + b, per);
            per.add(i, b);
        }
    }

    public void run() {
        String inputStr = getUserInput("Ingrese la cadena a permutar:");
        String strSplit[] = inputStr.split("");

        if (strSplit.length == 1) {
            System.out.println("PERMUTACIONES: " + inputStr);
        } else {
            LinkedList<String> per = new LinkedList<>();

            per.addAll(Arrays.asList(strSplit));
            System.out.println("PERMUTACIONES:");
            permute("", per);
        }

    }

}

package com.milosjanus;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scn = new Scanner(System.in);

    private static int unosBroja() {

        int broj;

        while(true) {
            try {
                System.out.print("Polje za unos: ");
                broj = scn.nextInt();
                if(broj <= 0) {
                    continue;
                }
                System.out.println("Uneli ste broj: " + broj);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Niste lepo uneli vrednosti. ");
                scn.next();
            }
        }
        return broj;
    }

    private static int[][] mnozenjeMatrice(int[][] mat1, int[][] mat2) {

        int mat3[][] = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                mat3[i][j] = 0;
                for (int w = 0; w < mat1[0].length; w++) {        // broj kolona prve matrice i redova druge
                    mat3[i][j] += mat1[i][w] * mat2[w][j];
                }
            }
        }
        return mat3;
    }

    private static void ucitaj(int mat[][]) {


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                while (true) {
                    try {
                        System.out.print("matrica[" + i + ", " + j + "] = ");
                        mat[i][j] = scn.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Broj treba da bude tipa Integer. Pokusajte ponovo!");
                        scn.next();
                    }
                }
            }
        }
    }

    public static void main (String[]args) {

        System.out.println("Dobrodosli!");
        System.out.println("****************************************");


        System.out.print(MyColors.ANSI_YELLOW + "Unos broja redova prve matrice. ");
        int redovi = unosBroja();
        System.out.print("Unos broja kolona prve matrice. ");
        int kolone = unosBroja();

        System.out.println(MyColors.ANSI_RESET + "****************************************");

        try {
            for (int i = 0; i < 40; i++) {
                System.out.print("*");
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }

        System.out.println(MyColors.ANSI_RED + "\nUpozorenje!");
        System.out.println("Za mnozenje matrice broj kolona prve matrice mora da bude jednaka sa brojem redova druge matrice");

        System.out.println(MyColors.ANSI_RESET + "****************************************");

        int[][] prvaMatrica = new int[redovi][kolone];
        System.out.print(MyColors.ANSI_GREEN + "Unos broja kolona druge matrice, broj redova je: " + kolone + ". ");
        int kolone1 = unosBroja();
        int[][] drugaMatrica = new int[kolone][kolone1];

        System.out.println("Unesite podatke za prvu matricu");
        ucitaj(prvaMatrica);
        System.out.println(MyColors.ANSI_PURPLE + "Vasa matrica izgleda ovako: ");
        System.out.println(Arrays.deepToString(prvaMatrica));

        System.out.println(MyColors.ANSI_RESET + "****************************************");

        System.out.println(MyColors.ANSI_YELLOW + "Unesite podatke za drugu matricu");
        ucitaj(drugaMatrica);
        System.out.println(MyColors.ANSI_BLUE + "Vasa matrica izgleda ovako: ");
        System.out.println(Arrays.deepToString(drugaMatrica));

        System.out.println(MyColors.ANSI_RESET + "****************************************");

        System.out.println(MyColors.ANSI_CYAN + "Proizvod matrica1 i matrica2 je: ");
        System.out.println(Arrays.deepToString(mnozenjeMatrice(prvaMatrica, drugaMatrica)));

        System.out.println(MyColors.ANSI_RESET + "Hvala Vam sto ste koristili ovaj program");
    }
}


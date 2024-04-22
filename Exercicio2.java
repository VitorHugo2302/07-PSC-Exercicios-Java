/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio7;

/**
 *
 * @author 42414189
 */
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        System.out.println("Preencha a matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o elemento da posição [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        if (verificarQuadradoMagico(matriz)) {
            System.out.println("A matriz é um quadrado mágico!");
        } else {
            System.out.println("A matriz não é um quadrado mágico!");
        }

        scanner.close();
    }

    public static boolean verificarQuadradoMagico(int[][] matriz) {
        int somaReferencia = 0;
        for (int j = 0; j < 3; j++) {
            somaReferencia += matriz[0][j];
        }

        for (int i = 0; i < 3; i++) {
            int somaLinha = 0;
            int somaColuna = 0;

            for (int j = 0; j < 3; j++) {
                somaLinha += matriz[i][j];
                somaColuna += matriz[j][i];
            }

            if (somaLinha != somaReferencia || somaColuna != somaReferencia) {
                return false;
            }
        }

        int somaDiagonalPrincipal = 0;
        for (int i = 0; i < 3; i++) {
            somaDiagonalPrincipal += matriz[i][i];
        }
        if (somaDiagonalPrincipal != somaReferencia) {
            return false;
        }

        int somaDiagonalSecundaria = 0;
        for (int i = 0; i < 3; i++) {
            somaDiagonalSecundaria += matriz[i][2 - i];
        }
        if (somaDiagonalSecundaria != somaReferencia) {
            return false;
        }

        return true;
    }
}

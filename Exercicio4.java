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

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matriz matriz = new Matriz(4, 4);

        int opcao;
        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Preencher a matriz");
            System.out.println("2 - Exibir valores da diagonal principal e secundária");
            System.out.println("3 - Exibir a matriz transposta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    matriz.preencherMatriz(scanner);
                    break;
                case 2:
                    matriz.exibirDiagonais();
                    break;
                case 3:
                    matriz.exibirMatrizTransposta();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static class Matriz {

        private double[][] matriz;

        public Matriz(int linhas, int colunas) {
            matriz = new double[linhas][colunas];
        }

        public void preencherMatriz(Scanner scanner) {
            System.out.println("Preencha a matriz 4x4:");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print("Digite o elemento da posição [" + (i + 1) + "][" + (j + 1) + "]: ");
                    matriz[i][j] = scanner.nextDouble();
                }
            }
        }

        public void exibirDiagonais() {
            OperacoesMatriz.exibirDiagonais(matriz);
        }

        public void exibirMatrizTransposta() {
            OperacoesMatriz.exibirMatrizTransposta(matriz);
        }
    }

    public static class OperacoesMatriz {

        public static void exibirDiagonais(double[][] matriz) {
            System.out.println("\nValores da diagonal principal:");
            for (int i = 0; i < 4; i++) {
                System.out.print(matriz[i][i] + " ");
            }

            System.out.println("\nValores da diagonal secundária:");
            for (int i = 0; i < 4; i++) {
                System.out.print(matriz[i][3 - i] + " ");
            }
            System.out.println();
        }

        public static void exibirMatrizTransposta(double[][] matriz) {
            System.out.println("\nMatriz transposta:");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(matriz[j][i] + " ");
                }
                System.out.println();
            }
        }
    }
}

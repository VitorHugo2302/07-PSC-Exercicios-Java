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

public class Exercicio3 {
    private char[][] tabuleiro;
    private char jogadorAtual;

    public Exercicio3() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X';
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void imprimirTabuleiro() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean jogoTerminou() {
        return (verificarLinhas() || verificarColunas() || verificarDiagonais() || tabuleiroCheio());
    }

    private boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verificarLinhas() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
                return true;
            }
        }
        return false;
    }

    private boolean verificarColunas() {
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j] && tabuleiro[0][j] != ' ') {
                return true;
            }
        }
        return false;
    }

    private boolean verificarDiagonais() {
        return ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ')
                || (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' '));
    }

    public void fazerJogada(int linha, int coluna) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogadorAtual;
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Jogada inválida! Tente novamente.");
        }
    }

    public char obterVencedor() {
        if (verificarLinhas() || verificarColunas() || verificarDiagonais()) {
            return (jogadorAtual == 'X') ? 'O' : 'X';
        } else {
            return ' ';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exercicio3 jogo = new Exercicio3();

        System.out.println("Bem-vindo ao Jogo da Velha!");

        while (!jogo.jogoTerminou()) {
            jogo.imprimirTabuleiro();
            System.out.println("É a vez do jogador " + jogo.jogadorAtual);
            System.out.print("Informe a linha (1-3): ");
            int linha = scanner.nextInt() - 1;
            System.out.print("Informe a coluna (1-3): ");
            int coluna = scanner.nextInt() - 1;

            jogo.fazerJogada(linha, coluna);
        }

        jogo.imprimirTabuleiro();
        char vencedor = jogo.obterVencedor();
        if (vencedor != ' ') {
            System.out.println("O jogador " + vencedor + " venceu!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }

        scanner.close();
    }

}

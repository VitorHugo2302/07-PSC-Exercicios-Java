/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio7;

import java.util.Scanner;

/**
 *
 * @author 42414189
 */
public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] agenda = new String[31][24];

        int opcao;
        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Agendar compromisso");
            System.out.println("2 - Consultar compromisso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    agendarCompromisso(agenda, scanner);
                    break;
                case 2:
                    consultarCompromisso(agenda, scanner);
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

    public static void agendarCompromisso(String[][] agenda, Scanner scanner) {
        System.out.print("Digite o dia do mês (1 a 31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a hora do compromisso (0 a 23): ");
        int hora = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o compromisso: ");
        String compromisso = scanner.nextLine();

        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            agenda[dia - 1][hora] = compromisso;
            System.out.println("Compromisso agendado com sucesso!");
        } else {
            System.out.println("Dia ou hora inválidos!");
        }
    }

    public static void consultarCompromisso(String[][] agenda, Scanner scanner) {
        System.out.print("Digite o dia do mês (1 a 31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a hora do compromisso (0 a 23): ");
        int hora = scanner.nextInt();

        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            String compromisso = agenda[dia - 1][hora];
            if (compromisso != null) {
                System.out.println("Compromisso: " + compromisso);
            } else {
                System.out.println("Nenhum compromisso agendado para este horário.");
            }
        } else {
            System.out.println("Dia ou hora inválidos!");
        }
    }
}

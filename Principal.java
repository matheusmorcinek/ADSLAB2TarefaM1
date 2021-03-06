package ADSLAB2TarefaM1;

import java.util.Scanner;

/**
 * 
 * M1 | Tarefa - Desafio do Módulo 1 Matheus Moreira Morcinek
 * 
 * ==========================================================================
 * [x] Crie dois jogadores, com nomes solicitados pelo teclado
 * ==========================================================================
 * [x] Crie um objeto do tipo JogoDaVelha com um tamanho de tabuleiro informado
 * pelo usuário via teclado
 * ==========================================================================
 * [x] Desenvolva, utilizando os métodos criados nas classes JogoDaVelha e
 * Jogador, a lógica do jogo da velha. Os jogadores devem indicar qual posição
 * (linha e coluna) querem jogar. O primeiro jogador joga com o 'X', enquanto o
 * segundo com a 'O'
 * ==========================================================================
 * [x] Ao final de cada jogo, você deve aumentar a pontuação do jogador vencedor
 * e perguntar se eles desejam jogar novamente. Quando os jogadores não quiserem
 * mais jogar, imprima na tela as informações do jogador vencedor
 */

public class Principal {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.print("Informe o tamanho do tabuleiro: ");
        int tamanhoTabuleiro = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("Criando tabuleiro de tamanho " + tamanhoTabuleiro + "...\n");

        JogoDaVelha jogoDaVelha = new JogoDaVelha(tamanhoTabuleiro);
        jogoDaVelha.toString();

        System.out.print("Informe o nome do Jogador 1: ");
        String nomeJogador1 = scanner.nextLine();

        Jogador jogador1 = new Jogador(nomeJogador1);

        System.out.print("Informe o nome do Jogador 2: ");
        String nomeJogador2 = scanner.nextLine();

        Jogador jogador2 = new Jogador(nomeJogador2);

        boolean continua = true;
        while (continua) {

            IniciaRodada(jogador1, jogador2, jogoDaVelha);

            System.out.printf("Selecione uma opção:\n");
            System.out.print("1 - Para iniciar uma nova rodada. \n");
            System.out.print("2 - Para terminar. ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 2) {

                System.out.printf("============= Pontuação geral =============\n");
                System.out.printf("[Jogador 1] " + jogador1.getNome() + "\n");
                System.out.printf("[Jogador 1] Pontuação: " + jogador1.getPontuacao() + "\n");
                System.out.printf("[Jogador 2] " + jogador2.getNome() + "\n");
                System.out.printf("[Jogador 2] Pontuação: " + jogador2.getPontuacao() + "\n");

                if (jogador1.getPontuacao() == jogador2.getPontuacao()) {

                    System.out.printf("\n");
                    System.out.printf("O jogo terminou em EMPATE!!!!\n");
                    System.out.printf("===========================================\n");
                } else {

                    System.out.printf("\n");
                    System.out.printf("O(a) jogador(a) " + jogador2.getNome() + " ganhou!!\n");
                    System.out.printf("===========================================\n");
                }

                continua = false;
            } else {

                jogoDaVelha = new JogoDaVelha(tamanhoTabuleiro);
                jogoDaVelha.toString();
            }

        }

    }

    private static void IniciaRodada(Jogador jogador1, Jogador jogador2, JogoDaVelha jogoDaVelha) {

        boolean vencedor = false;
        while (!vencedor) {

            System.out.printf("[Jogador 1] " + jogador1.getNome() + " Informe a posição para marcar X\n");

            boolean jogadaValida = false;
            while (!jogadaValida) {

                System.out.print("valor de x: ");
                int valorX = scanner.nextInt();
                scanner.nextLine();
                System.out.print("valor de y: ");
                int valorY = scanner.nextInt();
                scanner.nextLine();

                jogadaValida = jogoDaVelha.realizaJogada(valorX, valorY, 'X');
            }

            jogoDaVelha.toString();

            vencedor = jogoDaVelha.verificaGanhador();

            if (vencedor) {

                System.out.printf("[Jogador 1] " + jogador1.getNome() + " Foi o ganhador da rodada!\n");
                jogador1.adicionaPonto();
                System.out.printf("[Jogador 1] Pontuação: " + jogador1.getPontuacao() + "\n");
                break;
            } else if (jogoDaVelha.getJogadasRestantes() == 0) {
                System.out.printf("Empate!!!\n");
                break;
            }

            System.out.printf("[Jogador 2] " + jogador2.getNome() + " Informe a posição para marcar X\n");

            jogadaValida = false;
            while (!jogadaValida) {

                System.out.print("valor de x: ");
                int valorX = scanner.nextInt();
                scanner.nextLine();
                System.out.print("valor de y: ");
                int valorY = scanner.nextInt();
                scanner.nextLine();

                jogadaValida = jogoDaVelha.realizaJogada(valorX, valorY, 'O');
            }

            jogoDaVelha.toString();

            vencedor = jogoDaVelha.verificaGanhador();

            if (vencedor) {

                System.out.printf("[Jogador 1] " + jogador1.getNome() + " Foi o ganhador da rodada!\n");
                jogador1.adicionaPonto();
                System.out.printf("[Jogador 1] Pontuação: " + jogador1.getPontuacao() + "\n");
                break;
            }
            if (jogoDaVelha.getJogadasRestantes() == 0) {
                System.out.printf("Empate!!!\n");
                break;
            }

        }
    }

}

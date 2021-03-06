package ADSLAB2TarefaM1;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 *
 * 
 * [x] No construtor da classe, receba por parâmetro um valor inteiro referente
 * às dimensões do tabuleiro. Por exemplo, se o inteiro recebido for 3, o
 * tabuleiro terá dimensões 3x3; caso o valor recebido seja 7, o tabuleiro terá
 * dimensões 7x7, e assim sucessivamente. Com este valor recebido, inicialize o
 * tabuleiro.
 * ============================================================================
 * [x] Crie o método realizaJogada, que recebe dois inteiros (referentes a uma
 * linha e uma coluna do tabuleiro) e um caractere, referente a jogada a ser
 * realizada ('X' ou 'O'). Este método retorna verdadeiro ou falso, e
 * simplesmente coloca no tabuleiro a jogada realizada. Caso já tenha uma jogada
 * na posição indicada, o método retorna falso, indicando que a jogada não pode
 * ser realizada. Caso a jogada seja realizada corretamente, o método retorna
 * verdadeiro.
 * ============================================================================
 * [x] Crie um método chamado verificaGanhador, que retorna um valor booleano.
 * Este método analisa o tabuleiro e retorna verdadeiro caso o jogo tenha um
 * vencedor, e falso caso contrário. O jogo tem um vencedor caso as duas
 * diagonais (principal e secundária) estejam preenchidas com o mesmo caractere
 * ('X' ou 'O'), ou quando alguma linha estiver preenchida com o mesmo caractere
 * ('X' ou 'O'), ou ainda quando alguma coluna estiver preenchida com o mesmo
 * caractere ('X' ou 'O').
 * ============================================================================
 * [x] Na classe JogoDaVelha, faça o método toString, que retorna uma String que
 * refere-se ao estado atual do tabuleiro.
 * 
 */
public class JogoDaVelha {

    private int dimensao;
    private char[][] tabuleiro;

    public JogoDaVelha(int dimensao) {

        this.dimensao = dimensao;
        // tabuleiro = new char[dimensao][dimensao];
        // tabuleiro = new char[][]{{'X','X','O'},{'O','X','O'},{'X','O','X'}};
        tabuleiro = new char[][] { { 0, 'X', 'X' }, { 'O', 0, 'X' }, { 'X', 'O', 'O' } };

    }

    public int getDimensao() {
        return dimensao;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public boolean realizaJogada(int x, int y, char valor) {

        if (valor != 'X' || valor != 'O' || valor != 'x' || valor != 'o') {

            return false;
        }

        if (tabuleiro[x][y] == 0) {

            tabuleiro[x][y] = valor;
            return true;
        }

        return false;
    }

    public boolean verificaGanhador() {

        char jogadorGanhador = 0;

        // verifica linhas
        for (int x = 0; x < tabuleiro.length; x++) {

            int pontos = 1;

            // primeiro valor da linha estiver vazio passa para proxima linha
            if (tabuleiro[x][0] == 0) {
                continue;
            }

            char primeiroValor = tabuleiro[x][0];

            for (int y = 1; y < tabuleiro.length; y++) {

                // se valor na linha estiver vazio, pula para proxima
                if (tabuleiro[x][y] == 0) {
                    break;
                }

                // pontua se o valor for o mesmo da primeira/ultima posicao
                if (tabuleiro[x][y] == primeiroValor) {
                    pontos++;
                }
            }

            // verifica se pontuou na linha inteira
            if (pontos == dimensao) {

                jogadorGanhador = primeiroValor;
               
                System.out.println("Ganhou " + jogadorGanhador);
                return true;
            }
        }

        // verifica colunas
        for (int x = 0; x < tabuleiro.length; x++) {

            int pontos = 1;

            // primeiro valor da coluna estiver vazio passa para proxima linha
            if (tabuleiro[0][x] == 0) {
                continue;
            }

            char primeiroValor = tabuleiro[0][x];

            for (int y = 1; y < tabuleiro.length; y++) {

                // se valor na coluna estiver vazio, pula para proxima
                if (tabuleiro[y][x] == 0) {
                    break;
                }

                // pontua se o valor for o mesmo da primeira/ultima posicao
                if (tabuleiro[y][x] == primeiroValor) {
                    pontos++;
                }
            }

            // verifica se pontuou na coluna inteira
            if (pontos == dimensao) {

                jogadorGanhador = primeiroValor;

                System.out.println("Ganhou " + jogadorGanhador);
                return true;
            }
        }

        // verifica diagonal esquerda -> direita
        if (tabuleiro[0][0] != 0) {

            char primeiroValor = tabuleiro[0][0];
            int pontos = 1;

            for (int x = 1; x < tabuleiro.length; x++) {

                if (tabuleiro[x][x] == 0) {
                    break;
                }

                if (tabuleiro[x][x] == primeiroValor) {
                    pontos++;
                }
            }

            // verifica na diagonal
            if (pontos == dimensao) {

                jogadorGanhador = primeiroValor;

                System.out.println("Ganhou " + jogadorGanhador);
                return true;
            }
        }

        // verifica diagonal direita -> esquerda
        if (tabuleiro[0][tabuleiro.length - 1] != 0) {

            char primeiroValor = tabuleiro[0][tabuleiro.length - 1];
            int pontos = 1;

            for (int x = 1; x < tabuleiro.length; x++) {

                if (tabuleiro[x][tabuleiro.length - x - 1] == 0) {
                    break;
                }

                if (tabuleiro[x][tabuleiro.length - x - 1] == primeiroValor) {
                    pontos++;
                }
            }

            // verifica na diagonal
            if (pontos == dimensao) {

                jogadorGanhador = primeiroValor;

                System.out.println("Ganhou " + jogadorGanhador);
                return true;
            }
        }

        System.out.println("ngm ganhou ainda");
        return false;
    }

    @Override
    public String toString() {

        System.out.println("=============================");
        System.out.println();

        for (int x = 0; x < tabuleiro.length; x++) {
            for (int y = 0; y < tabuleiro.length; y++) {

                System.out.print(MessageFormat.format("| {0} ", tabuleiro[x][y]));
                // System.out.print(MessageFormat.format("| {0}{1} ", x, y));
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
        System.out.println("=============================");

        return "JogoDaVelha [dimensao=" + dimensao + ", tabuleiro=" + Arrays.toString(tabuleiro) + "]";
    }

}
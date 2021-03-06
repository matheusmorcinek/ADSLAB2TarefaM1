package ADSLAB2TarefaM1;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 *
 * 
    [x] No construtor da classe, receba por parâmetro um valor inteiro referente às dimensões do tabuleiro.
     Por exemplo, se o inteiro recebido for 3, o tabuleiro terá dimensões 3x3; caso o valor recebido seja 7, o tabuleiro terá dimensões 7x7, e assim sucessivamente. 
     Com este valor recebido, inicialize o tabuleiro.
    [x] Crie o método realizaJogada, que recebe dois inteiros (referentes a uma linha e uma coluna do tabuleiro) e um caractere, referente a jogada a ser realizada ('X' ou 'O').
         Este método retorna verdadeiro ou falso, e simplesmente coloca no tabuleiro a jogada realizada. Caso já tenha uma jogada na posição indicada,
      o método retorna falso, indicando que a jogada não pode ser realizada. Caso a jogada seja realizada corretamente, o método retorna verdadeiro.
    [ ] Crie um método chamado verificaGanhador, que retorna um valor booleano. Este método analisa o tabuleiro e retorna verdadeiro caso o jogo tenha um vencedor,
     e falso caso contrário. O jogo tem um vencedor caso as duas diagonais (principal e secundária) estejam preenchidas com o mesmo caractere ('X' ou 'O'),
     ou quando alguma linha estiver preenchida com o mesmo caractere ('X' ou 'O'), ou ainda quando alguma coluna estiver preenchida com o mesmo caractere ('X' ou 'O').
    [x] Na classe JogoDaVelha, faça o método toString, que retorna uma String que refere-se ao estado atual do tabuleiro. 
 * 
 */
public class JogoDaVelha {

    private int dimensao;
    private char[][] tabuleiro;

    public JogoDaVelha(int dimensao) {

        this.dimensao = dimensao;
        tabuleiro = new char[dimensao][dimensao];
        // tabuleiro = new char[][]{{'X','O','O'},{'O','X','O'},{'O','O','X'}};
        
    }
   
    public int getDimensao() {
        return dimensao;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public boolean realizaJogada(int x, int y, char valor){
      
        if (valor != 'X' || valor != 'O' || valor != 'x' || valor != 'o') {

            return false;
        }

        if (tabuleiro[x][y] == 0) {

            tabuleiro[x][y] = valor;
            return true;
        } 

        return false;
    }


    //TODO
    public boolean verificaGanhador() {

        return false;
    }

    @Override
    public String toString() {

        System.out.println("=============================");
        System.out.println();

        for (int x = 0; x < tabuleiro.length; x++) {
            for (int y = 0; y < tabuleiro.length; y++) {
                
                System.out.print(MessageFormat.format("| {0} ", tabuleiro[x][y]));
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
        System.out.println("=============================");

        return "JogoDaVelha [dimensao=" + dimensao + ", tabuleiro=" + Arrays.toString(tabuleiro) + "]";
    }

    
}
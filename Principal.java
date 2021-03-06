package ADSLAB2TarefaM1;

/**
 * 
 * [ ] Crie dois jogadores, com nomes solicitados pelo teclado 
 * [ ] Crie um
 * objeto do tipo JogoDaVelha com um tamanho de tabuleiro informado pelo usuário
 * via teclado 
 * [ ] Desenvolva, utilizando os métodos criados nas classes
 * JogoDaVelha e Jogador, a lógica do jogo da velha. Os jogadores devem indicar
 * qual posição (linha e coluna) querem jogar. O primeiro jogador joga com o
 * 'X', enquanto o segundo com a 'O' 
 * [ ] Ao final de cada jogo, você deve
 * aumentar a pontuação do jogador vencedor e perguntar se eles desejam jogar
 * novamente. Quando os jogadores não quiserem mais jogar, imprima na tela as
 * informações do jogador vencedor
 */

public class Principal {

    // int[][] arr = new int[10][20];
    // arr[0][0] = 1;

    public static void main(String[] args) {

        JogoDaVelha jv = new JogoDaVelha(3);
        // jv.toString();

        jv.verificaGanhador();
    //    System.out.println();

        // char[][] arr = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'}};

        // for (int x = 0; x < arr.length; x++) {
        //     for (int y = 0; y < arr.length; y++) {
                
        //         System.out.print(arr[x][y]);
        //     }
        //     System.out.println();
        // }

       
        // char value = 'M'; 

        // if (value == 0) {
        //     System.out.println("vazio");
        // } else {
        //     System.out.println(value);
        // }

       
    }

}

package ADSLAB2TarefaM1;

/**
 * 
 * [x] No construtor de jogador, receba parâmetros para inicializar o nome dos
 * atributos, e inicialize os pontos em zero 
 * [x] Crie os métodos de acesso 
 * [x]
 * Crie o toString
 * 
 */

public class Jogador {

    private String nome;
    private int pontuacao = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionaPonto() {
        this.pontuacao = this.pontuacao + 1;
    }

    @Override
    public String toString() {
        return "Jogador [nome=" + nome + ", pontuacao=" + pontuacao + "]";
    }
}

package velha;

public abstract class Jogador { //classe abstrata;
    
    protected int[] tentativa = new int[2]; //vetor para guardar tentativa;
    protected int jogador;

    
    public Jogador(int jogador){ //construtor referenciado a classe local
        this.jogador = jogador; 
    }
    
    
    //metodos abstract para ser referenciado em outras classes
    public abstract void jogar(Tabuleiro tab); 
    
    public abstract void Tentativa(Tabuleiro tab);

    //verifica tentativa, passando o array e o tabuleiro
    public boolean verificaTentativa(int[] tentativa, Tabuleiro tab){
        if(tab.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
            
    }
    
}

package velha;

import java.util.Random; //gerar numeros randomicos biblioteca

public class Computador extends Jogador{
    
	//construtor
    public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador criado com sucesso!");
    }
   
    //chamada o metodo void
    public void jogar(Tabuleiro tab){
        Tentativa(tab);
        tab.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tab){ //Metodo de tentativa
        do{
            do{
                Random gerador = new Random(); 
                tentativa[0] = gerador.nextInt(3); //gerando numero randomico a entre 0 a 3
                tab.tabuleiroCompleto();
                                            
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                Random gerador2 = new Random(); 
                tentativa[1] = gerador2.nextInt(3); //gerando numero randomico a entre 0 a 3
                tab.tabuleiroCompleto();
                                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
           
            
            if(!verificaTentativa(tentativa, tab))
                System.out.println("Tentando outro...");
        }while( !verificaTentativa(tentativa, tab) );
    }
}

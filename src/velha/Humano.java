package velha;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);
    
    public Humano(int jogador){ //construtor Humano 
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador criado com sucesso!");
    }
    
    @Override
    public void jogar(Tabuleiro tab){ // jogar passando a tentativa e posição;
        Tentativa(tab);
        tab.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tab){ //tentativa
        do{
            do{
                System.out.print("Entre com a Linha: "); //linha
                tentativa[0] = entrada.nextInt(); //gravando
                
                if( tentativa[0] > 3 ||tentativa[0] < 1) //se for maior que 3 ou menor do que 1, invalida jogo da velha somente com 3
                    System.out.println("Linha inválida: Tente novamente");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            
            //mesma coisa com a Coluna
            do{
                System.out.print("Entre com a Coluna: ");
                tentativa[1] = entrada.nextInt();
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("Linha inválida: Tente novamente");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; 
            tentativa[1]--;
            
            if(!verificaTentativa(tentativa, tab))
                System.out.println("Ja foi instanciado, tente outro: ");
        }while( !verificaTentativa(tentativa, tab) );
    }
}


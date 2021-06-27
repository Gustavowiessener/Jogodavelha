package velha;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tab; // atribuição de um novo objeto tabuleiro;
    private int rodada=1, chamadaVez=1;
    private Jogador jogador1; //duas instancia primeira e segundo jogador
    private Jogador jogador2;
    public Scanner abertura = new Scanner(System.in);  //para poder utilizar na instanciação da opção

    
    public Jogo(){ // instacia do jogo;
        tab = new Tabuleiro(); //novo
        iniciarJogadores(); //iniciando os jogadores
        
        while( Jogar() );
    }
    
    //instanciando o inicio para os jogadores;
    public void iniciarJogadores(){ 
              
        if(escolherJogador() == 1) // instanciando os primeiro jogador
            this.jogador1 = new Humano(1);
        else
            this.jogador1 = new Computador(1);
        
                
        if(escolherJogador() == 1) // instanciando o segundo jogador
            this.jogador2 = new Humano(2);
        else
            this.jogador2 = new Computador(2);
        
    }
    
    
    public int escolherJogador(){ 
        int opcao=0; //iniciando variavel em 0;
        
        do{
        	
        	System.out.println("*********************");
        	System.out.println("*  JOGO DA VELHA    *");
        	System.out.println("1. Jogador          *");
            System.out.println("2. Computador       *");
         	System.out.println("*********************");
         	System.out.print("Entre com a opcao desejada para jogar: ");
            opcao = abertura.nextInt(); // SENDO INSTANCIADA AQUI;
            
            if(opcao != 1 && opcao != 2) // se opção invalida retorna um erro
                System.out.println("Error! Tente novamente.");
        }while(opcao != 1 && opcao != 2); //
        
        return opcao;
    }
    
   
   
    
    public boolean Jogar(){ // Metodo para jogar
        if(ganhou() == 0 ){
            System.out.println("*********************************");
            System.out.println("*Rodada: " + rodada); // RODADA
            System.out.println("");
            System.out.println("*Vez do jogador:  " + chamadaVez() ); //chamada da vez
            
            if(chamadaVez()==1)
                jogador1.jogar(tab); // jogador passando metodo e como parametro o tabuleiro;
            else
                jogador2.jogar(tab); // se retornar falso inicia outro;
            
            
            if(tab.tabuleiroCompleto()){ // se o tabuleiro for completo (EMPATE)
                System.out.println("Tudo empatado por aqui!!");
                return false;
            }
            chamadaVez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1 ) //caso o primeiro ganhe
                System.out.println("Parabens!!!! O primeiro jogador ganhou!");
            else //caso o segundo ganhe
                System.out.println("Parabens!!!! O segundo jogador ganhou!");
            
            return false;
        }
            
    }
    
    
    
    public int ganhou(){ // verifica as linhas/colunas e diagonais para ver quem ganhou
        if(tab.verificaLinhas() == 1)
            return 1;
        if(tab.verificaColunas() == 1)
            return 1;
        if(tab.verificaDiagonais() == 1)
            return 1;
        
        if(tab.verificaLinhas() == -1)
            return -1;
        if(tab.verificaColunas() == -1)
            return -1;
        if(tab.verificaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    public int chamadaVez(){ // metodo referente a jez
        if(chamadaVez %2 == 1) //intercalando entre jogadores
            return 1;
        else
            return 2;
    }    
    
    
}

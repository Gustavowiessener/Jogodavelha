package velha; //pacote

public class Tabuleiro {
    private int[][] tab= new int[3][3]; //instanciado com 3x3
    
    public Tabuleiro(){ //zerar o tabuleiro
        zerarTabuleiro();
    }
    
    public void zerarTabuleiro(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
            	tab[linha][coluna]=0;
    }
    
    public void exibeTabuleiro(){ //metodo void para exibir o tabuleiro;
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){ //laço da linha
        
            for(int coluna=0 ; coluna<3 ; coluna++){ //laço da coluna
                
                if(tab[linha][coluna]==-1){ //instanciando
                    System.out.print(" X ");
                }
                if(tab[linha][coluna]==1){ 
                    System.out.print(" O ");
                }
                if(tab[linha][coluna]==0){
                    System.out.print("   ");
                }
                
                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosicao(int[] tentativa){ //get para pegar a posição
        return tab[tentativa[0]][tentativa[1]];
    }
    
    public void setPosicao(int[] tentativa, int jogador){ //set para atribuir para não ter acesso diretamente aos atributos
        if(jogador == 1)
        	tab[tentativa[0]][tentativa[1]] = -1;
        else
        	tab[tentativa[0]][tentativa[1]] = 1;
        
        exibeTabuleiro();
    }
    
    public boolean tabuleiroCompleto(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                if( tab[linha][coluna]==0 )
                    return false;
        return true;
    }

    
    //METODOS PARA CHECAGEM LINHA/COLUNA/DIAGONAL

    public int verificaDiagonais(){
        if( (tab[0][0] + tab[1][1] + tab[2][2]) == -3) //percorrendo linhas e colunas
            return -1;
        if( (tab[0][0] + tab[1][1] + tab[2][2]) == 3)
            return 1;
        if( (tab[0][2] + tab[1][1] + tab[2][0]) == -3)
            return -1;
        if( (tab[0][2] + tab[1][1] + tab[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
   
    public int verificaLinhas(){
        for(int linha=0 ; linha<3 ; linha++){

            if( (tab[linha][0] + tab[linha][1] + tab[linha][2]) == -3) //percorrendo linhas e colunas
                return -1; 
            if( (tab[linha][0] + tab[linha][1] + tab[linha][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int verificaColunas(){
        for(int coluna=0 ; coluna<3 ; coluna++){

            if( (tab[0][coluna] + tab[1][coluna] + tab[2][coluna]) == -3) //percorrendo linhas e colunas
                return -1;
            if( (tab[0][coluna] + tab[1][coluna] + tab[2][coluna]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    


 }

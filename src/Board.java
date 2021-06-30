
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João Subtil
 */
public class Board {
    
 private int Board[][] = new int[9][3];
    Random randomNumber = new Random();
    private boolean isLineCompleted[] = new boolean[3];

    Board() {
        for(int i = 0; i < isLineCompleted.length; i++) {
            isLineCompleted[i] = false; 
        }
        create();
    }

   

    private void create() {

        for (int i =0; i<Board.length;i++){
            preencherColuna(Board[i], i );      
        }   

        for(int linha=0; linha<3; linha++){    
            for (int i=0; i<4; i++){
                    
                int posicao = randomNumber.nextInt(Board.length);
                
                if (Board[posicao][linha] == 0) {
                    i=i-1;
                } else {
                Board[posicao][linha]= 0;
                }
            }
        }
    }

   

    public int getNumber(int linha, int coluna) {
        return Board[linha][coluna];
    }

    public void apagar(int numero) {
        
        int posicao = (numero/10);
        if(numero==90){
            posicao--;
        }
        for (int l = 0; l < 3; l++){
            if(numero == Board[posicao][l]){
             Board[posicao][l] = -1;   
             
            }
        }
    }

    public boolean verificarLinhas() {

        int y=0;            
        for(int h = 0; h < 3; h++){
            for(int k = 0; k<9;k++){
                if(Board[k][h] == -1){
                    y++;
                }
            }
            if(y==5){
                if(!isLineCompleted[h]) {

                    System.out.println("\nLinha completa!");
                    isLineCompleted[h] = true;
                    return true;
                } 
            }
            y=0;
        }
        return false;
    }

    public void preencherColuna(int coluna[],int numero){
        
        int espaco = 0;
        int max = (10*numero)+10;
        int min = 10*numero;
        if (numero==0){
            min=1;
        }
        if(numero==8){
            max=max+1;
        }
        for (int b = 1; b <= 9; b++) {
            int randomb = randomNumber.nextInt(max-min)+ min ;
            if (numCheck(coluna, randomb)) {
                coluna[espaco++]= randomb;
            if (espaco>=coluna.length){
                return;
            }
            }
            
        }
    }

    private boolean numCheck(int box [], int n) {
        for (int i = 0; i < box.length ; i++) {
            if (box[i] == n) {
                return false;
            }
        }
        return true;
    }
    
    public boolean numCheck(int coluna, int linha, int n) {

        if (Board[coluna][linha] == n) {
            return true;
        }
        return false;
    }

    
    public boolean gameover() {
        
        int p=0;

        for (int i = 0; i < Board[0].length; i++){  
            for (int j = 0; j < Board.length; j++){
                if (Board[j][i] == -1){
                    p++;   
                }
            }
        }
        if(p==15){
            System.out.println("                            ");
            System.out.println("Parabéns você ganhou o jogo!");
            System.out.println("                            ");
            return true;
        }
        return false;
    }
   
    public String[] getAvailableNumber(){
        int n=0;    
        String[]result = new String[15];

        for(int h=0;h<9;h++){
            for(int i=0;i<3;i++){    
                if(Board[h][i]!= 0){
                    result[n]= String.valueOf(Board[h][i]);
                    n++;
                }

            }
        }
        return result;
    }
    
    private boolean pretencerColuna(int coluna , int number){
        
        String getValue = new String();
        int index = (int) number / 10;
        if(number==90){
            index--;
            
        }
        if(coluna == index){
            return true;
        }
        return false;
    }
    
    
}

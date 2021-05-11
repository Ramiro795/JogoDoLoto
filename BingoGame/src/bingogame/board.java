package bingogame;

import java.util.Random;

public class board {
    
    private int board[][] = new int[9][3];
    Random randomNumber = new Random();
    private boolean isLineCompleted[] = new boolean[3];

    board() {
        for(int i = 0; i < isLineCompleted.length; i++) {
            isLineCompleted[i] = false; 
        }
        create();
    }

    board(board copia) {
        for(int i = 0; i < isLineCompleted.length; i++) {
            isLineCompleted[i] = false; 
        }
        copy(copia);
    }   

    private void create() {

        for (int i =0; i<board.length;i++){
            preencherColuna(board[i], i );      
        }   

        for(int linha=0; linha<3; linha++){    
            for (int i=0; i<4; i++){
                    
                int posicao = randomNumber.nextInt(board.length);
                
                if (board[posicao][linha] == 0) {
                    i=i-1;
                } else {
                board[posicao][linha]= 0;
                }
            }
        }
    }

    public void copy(board copy) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = copy.getNumber(i, j);
            }
        }
    }

    public int getNumber(int linha, int coluna) {
        return board[linha][coluna];
    }

    public void apagar(int numero) {
        
        int posicao = (numero/10);
        if(numero==90){
            posicao--;
        }
        for (int l = 0; l < 3; l++){
            if(numero == board[posicao][l]){
             board[posicao][l] = -1;   
             
            }
        }
    }

    public void verificarLinhas() {

        int y=0;            
        for(int h = 0; h < 3; h++){
            for(int k = 0; k<9;k++){
                if(board[k][h] == -1){
                    y++;
                }
            }
            if(y==5){
                if(!isLineCompleted[h]) {

                    System.out.println("\nLinha completa!");
                    isLineCompleted[h] = true;
                } 
            }
            y=0;
        }
    }

    public void preencherColuna(int coluna[],int numero){
        
        int espaco = 0;
        int max = (10*numero)+9;
        int min = 10*numero;
        if (numero==0){
            min=1;
        }
        if(numero==8){
            max=max+2;
        }
        for (int b = 1; b <= 9; b++) {
            
        //int randomNumber = random.nextInt(max - min) + min;
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

    public void display() {

        for (int i = 0; i < board[0].length; i++) {
            System.out.println();
            for (int j = 0; j < board.length; j++){
            
                if (board[j][i] == -1){
                    System.out.print((j == 0) ? "X" : " X");
                
                } else if (board[j][i] == 0) {
                    System.out.print((j == 0) ? " " : "  ");
                } else {
                    System.out.print(board[j][i]);
                }
                System.out.print(" | ");
            } 
        }
    }

    public boolean gameover() {
        
        int p=0;

        for (int i = 0; i < board[0].length; i++){  
            for (int j = 0; j < board.length; j++){
                if (board[j][i] == -1){
                    p++;   
                }
            }
        }
        if(p==15){
            System.out.println("                            ");
            System.out.println("Parabéns você ganhou o jogo!");
            System.out.println("                            ");
            return false;
        }
        return true;
    }
}
package bingogame;
 
import java.io.*;
import java.util.Scanner;

public class BingoGame {
     
    public static void main(String[] args) throws IOException {

        System.out.println("    J | O | G | O |  | L | O | T | O |   ");
        System.out.println("                                          ");
        System.out.println(" Para sair escreve 'exit' ");
        
        Scanner scan =new Scanner(System.in);

        board board = new board();
        board board_copy = new board(board); 
        board.display();
        
        System.out.println();
        System.out.println();
        

        String responta = " ";
        String exit = " "; 
        int numerosorteado = 0;

        while(responta.compareTo("nao") != 0) {
            while(board.gameover()){

                System.out.println();
                System.out.println();
                System.out.print("Digite o numero sorteado: ");
                exit = scan.next();

                if (exit.compareTo("exit")== 0){
                    break;
                    
                } else{
                    numerosorteado = Integer.parseInt(exit);
                }
                if ((numerosorteado>0)&&(numerosorteado<=90)){
                    
                    board.apagar(numerosorteado);
                    board.display();
                    board.verificarLinhas();
                }
            }

            System.out.println("Novo Jogo? Escreva 'sim' ou 'nao' ");
            responta = scan.next();
            if (responta.compareTo("sim") == 0){

                System.out.println("CartÃ£o Novo ou o mesmo? Escreva 'novo' ou 'mesmo' ");
                String materCartao = "";
                materCartao = scan.next();
                if (materCartao.compareTo("novo")== 0){
                    board = new board();
                    board_copy = new board(board);
                
                } else if (materCartao.compareTo("mesmo")== 0){
                    board.copy(board_copy);
                }
                board.display();
            }
        }

        scan.close();
    }
}


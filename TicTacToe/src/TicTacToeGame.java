import Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    static Deque<Player> dq;
    Board board;
    TicTacToeGame(){
        initialize();
    }
    static int n=3;

    public void initialize(){
        PlayingPieceX px = new PlayingPieceX(PIECETYPE.X);
        PlayingPieceY py = new PlayingPieceY(PIECETYPE.O);
        Player p1 = new Player("KK", px);
        Player p2 = new Player("Ayu", py);
        dq = new LinkedList<>();
        dq.add(p1);
        dq.add(p2);
        board = new Board(3);
    }

    public void startGame(){
        Scanner obj = new Scanner(System.in);

        while(true){
            board.printBoard();
            if(!board.isFreeSpaceLeft()){
                System.out.println("Game is a draw");
                break;
            }
            Player turn = dq.removeFirst();

            System.out.println("Player "+turn.name+" Enter the row value");
            int row = obj.nextInt();
            System.out.println("Player "+turn.name+" Enter the column value value");
            int col = obj.nextInt();
            if(!board.isValidEntry(row, col)){
                System.out.println("Invalid Entry!! Please try again");
                continue;
            }
            board.addPiece(row,col,turn);
            System.out.println("Entry Added Successfully");
            if(board.isWinner(row, col, turn.playingPiece.piecetype)){
                board.printBoard();
                System.out.println("Player "+turn.name+" has won the match");
                break;
            }

            dq.addLast(turn);
        }
    }
}

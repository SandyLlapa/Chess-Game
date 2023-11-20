//  Name:   Sandy Llapa
//  x500:   llapa016

import java.util.Arrays;
import java.util.Scanner;
public class Game{
    static Board object;

    public static void main(String[] args) {
        Game first= new Game();
        object = new Board();
        System.out.println(object.toString());

        //INTRODUCTION / INSTRUCTIONS
        System.out.println("Welcome to the game of chess");
        System.out.println("To end the game, please type 'QUIT'");
        System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
        System.out.println("Example: 0 1 0 3");
        //

        Scanner myScanner = new Scanner(System.in);
        String moveInput = myScanner.nextLine();

        boolean winnerNot = first.winner(); // determines if there is a winner in the game

        if(moveInput.equals("QUIT")){
            winnerNot=true; // helps break while loop when user wants to quit game
        }

        while(!winnerNot && !moveInput.equals("QUIT")){
            moveInput= moveInput.replaceAll("\\s","");

            int[] input= new int[moveInput.length()];  // converts string to int array for easy access to row and column values.
            for(int i=0; i< input.length;i++){
                int x=Character.getNumericValue(moveInput.charAt(i));
                input[i] = x;
            }

            Piece startResult =object.getPiece(input[1],input[0]);

            if(startResult.getCharacter()=='\u265C' || startResult.getCharacter()=='\u2656'){ // ROOK
                System.out.println(first.getRook(input[0], input[1], input[2], input[3], startResult.getIsBlack()));
                System.out.println(object);
                System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
                moveInput = myScanner.nextLine();
            }

            if(startResult.getCharacter() == '\u265F'|| startResult.getCharacter() == '\u2659'){ //PAWN
                System.out.println(first.getPawn(input[0],input[1],input[2],input[3], startResult.getIsBlack()));
                System.out.println(object);
                System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
                moveInput = myScanner.nextLine();
            }

            if(startResult.getCharacter() == '\u265E' || startResult.getCharacter() == '\u2658'){ // KNIGHT
                System.out.println(first.getKnight(input[0],input[1],input[2],input[3], startResult.getIsBlack()));
                System.out.println(object);
                System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
                moveInput = myScanner.nextLine();
            }

            if(startResult.getCharacter() == '\u265D' || startResult.getCharacter() == '\u2657'){ // BISHOP
                System.out.println(first.getBishop(input[0], input[1],input[2], input[3], startResult.getIsBlack()));
                System.out.println(object);
                System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
                moveInput = myScanner.nextLine();
            }

            if(startResult.getCharacter()=='\u2655' || startResult.getCharacter()== '\u265B'){ // QUEEN
                System.out.println(first.getQueen(input[0], input[1],input[2], input[3], startResult.getIsBlack()));
                System.out.println(object);
                System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
                moveInput = myScanner.nextLine();
            }

            if(startResult.getCharacter() == '\u265A' || startResult.getCharacter() == '\u2654'){ // KING
                System.out.println(first.getKing(input[0], input[1],input[2], input[3], startResult.getIsBlack()));
                System.out.println(object);
                System.out.println("What is your move? (format: [start col] [start row] [end col] [end row])");
                moveInput = myScanner.nextLine();
            }
            winnerNot= first.winner(); // determines if there is a winner or not
        }
        System.out.println("GAME OVER, THANK YOU FOR PLAYING");
    }
    public boolean getRook(int col, int row, int endCol, int endRow, boolean isBlack){

        Rook rook = new Rook(row,col,isBlack);
        boolean truth = rook.isMoveLegal(object,endRow,endCol);  //checks if move is legal

        if(truth){
            object.movePiece(row, col, endRow, endCol,object); // if legal, move piece to the destination
        }
        if (!truth){
            System.out.println("ILLEGAL MOVE");
        }
        return truth;
    }

    public boolean getPawn(int col, int row, int endCol, int endRow, boolean isBlack){
        Pawn pawn = new Pawn(row,col,isBlack);
        boolean truth = pawn.isMoveLegal(object,endRow,endCol);
        Piece change = object.board[col][row].pawnPromotion(row, col, endRow, endCol, object); // represents the chess piece that the pawn will be exchanged for
        if (truth && change ==null ){
            object.movePiece(row, col, endRow,endCol, object);
        }
        if(truth && change !=null){
            object.movePiece(row, col, endRow,endCol, object);
            object.board[endCol][endRow] = change;  // if pawn reaches opposite side of board, pawn will be exchanged for given piece input from user.
        }
        if (!truth){
            System.out.println("ILLEGAL MOVE");
        }
        return truth;
    }

    public boolean getBishop(int col, int row, int endCol, int endRow, boolean isBlack){
        Bishop bishop = new Bishop(row, col, isBlack);
        boolean truth = bishop.isMoveLegal(object, endRow, endCol);

        if (truth){
            object.movePiece(row, col, endRow, endCol,object);
        }
        if (!truth){
            System.out.println("ILLEGAL MOVE");
        }
        return truth;
    }
    public boolean getKnight(int col, int row, int endCol, int endRow, boolean isBlack){
        Knight knight = new Knight(row,col,isBlack);
        boolean truth = knight.isMoveLegal(object,endRow,endCol);

        if(truth){
            object.movePiece(row, col, endRow, endCol, object);
        }
        if (!truth){
            System.out.println("ILLEGAL MOVE");
        }
        return truth;
    }
    public boolean getQueen(int col, int row, int endCol, int endRow, boolean isBlack){
        Queen queen = new Queen(row, col, isBlack);
        boolean truth = queen.isMoveLegal(object, endRow, endCol);

        if(truth){
            object.movePiece(row, col, endRow, endCol, object);
        }
        if (!truth){
            System.out.println("ILLEGAL MOVE");
        }
        return truth;
    }
    public boolean getKing(int col, int row, int endCol, int endRow, boolean isBlack){
        King king = new King(row, col, isBlack);
        boolean truth = king.isMoveLegal(object, endRow, endCol);

        if(truth){
            object.movePiece(row, col, endRow, endCol, object);
        }
        if (!truth){
            System.out.println("ILLEGAL MOVE");
        }
        return truth;
    }
    public boolean winner(){
        if(object.isGameOver()){
            return true;
        }
        return false;
    }
}
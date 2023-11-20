//  Name:   Sandy Llapa
//  x500:   llapa016

import java.util.Objects;
import java.util.Scanner;

public class Piece {

    // Instance variables
    private char character;
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */

    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow){

        return true;
    }
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol){
        return true;
    }

    public boolean verifyHorizontal( int startRow, int startCol, int endRow, int endCol){
        return true;
    }

    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol){
        return true;
    }




    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            // Pawn chars
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            // Rook chars
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            // Knight chars
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            // Bishop chars
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            // Queen chars
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            // King chars
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the current chess unicode character.
     * @return Unicode character.
     */
    public char getCharacter(){
        return this.character;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {

        return this.isBlack;
    }

    /**
     * Tests the equality of two Piece objects based on
     * their character parameter.
     * @param other An instance of Piece to compare with this
     *              instance.
     * @return Boolean value representing equality result.
     */
    public boolean equals(Piece other){
        return this.character == other.character;
    }

    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + this.character;
    }

    public Piece pawnPromotion(int startRow, int startCol, int endRow, int endCol, Board object){
        Piece newPiece=null;

        for (int i=0; i<object.board.length; i++){
            if(endRow==7 & endCol==i && object.board[startCol][startRow].isBlack){  // if black pawn reaches the other end of the board
                System.out.println("Your pawn has reach the opposite side of the board successfully, pick any piece (not a king) to promote your pawn to: ");
                System.out.println("Options: Queen, Bishop, Rook, Knight");
                Scanner myScanner = new Scanner(System.in); // user decides what piece they want
                String pieceInput = myScanner.nextLine();

                if (pieceInput.equals("Queen") || pieceInput.equals("queen")){
                    char name = '\u265B';
                    newPiece = new Piece(name, endRow, endCol, true);

                }
                if(pieceInput.equals("bishop") || pieceInput.equals("Bishop")){
                    char name = '\u265D';
                    newPiece = new Piece(name,endRow, endCol,true );

                }
                if(pieceInput.equals("Rook") || pieceInput.equals("rook")){
                    char name= '\u265C';
                    newPiece = new Piece(name,endRow, endCol,true );

                }
                if(pieceInput.equals("Knight") || pieceInput.equals("knight")){
                    char name = '\u265E';
                    newPiece = new Piece(name,endRow, endCol,true );

                }
                if(pieceInput.equals("king") || pieceInput.equals("King") ){  // default case if user types king
                    System.out.println("CANT PICK KING, DEFAULT ROOK PIECE");
                    char name= '\u265C';
                    newPiece = new Piece(name,endRow, endCol,true );

                }
            }
            if(endRow==0 && endCol==i && !object.board[startCol][startRow].isBlack){ // if white pawn reaches the other end of the board
                System.out.println("Your pawn has reach the opposite side of the board successfully, pick a piece (not a king) to promote your pawn to: ");
                System.out.println("Options: Queen, Bishop, Rook, Knight");
                Scanner myScanner = new Scanner(System.in);
                String pieceInput = myScanner.nextLine();
                if (pieceInput.equals("Queen") || pieceInput.equals("queen")){
                    char name = '\u2655';
                    newPiece = new Piece(name, endRow, endCol, false);

                }
                if(pieceInput.equals("bishop") || pieceInput.equals("Bishop")){
                    char name = '\u2657';
                    newPiece = new Piece(name,endRow, endCol,false );

                }
                if(pieceInput.equals("Rook") || pieceInput.equals("rook")){
                    char name= '\u2656';
                    newPiece = new Piece(name,endRow, endCol,false);

                }
                if(pieceInput.equals("Knight") || pieceInput.equals("knight")){
                    char name = '\u2658';
                    newPiece = new Piece(name,endRow, endCol,false);

                }
                if(pieceInput.equals("king") || pieceInput.equals("King") ){
                    System.out.println("CANT PICK KING, DEFAULT ROOK PIECE");
                    char name= '\u2656';
                    newPiece = new Piece(name,endRow, endCol,false);
                }

            }
        }
        return newPiece;
    }
}

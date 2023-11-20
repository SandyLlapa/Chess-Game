//  Name:   Sandy Llapa
//  x500:   llapa016

import java.util.Arrays;
public class Board {

    // Instance variables
    static Piece[][] board;
    static Board tester;


    //TODO:
    // Construct an object of type Board using given arguments.
    public static void main(String[] args){
        tester= new Board();
        System.out.println(tester.toString());

    }
    public Board() {
        board = new Piece[8][8];

        //Black rook, knight, bishop, king, queen:
        board[0][0] = new Piece('\u265C',0,0,true); // rook
        board[1][0] = new Piece('\u265E',0,1,true); // knight
        board[2][0] = new Piece('\u265D',0,2,true); // bishop
        board[4][0] = new Piece('\u265A',0,4,true); // king
        board[3][0] = new Piece('\u265B',0,3,true); // queen
        board[5][0] = new Piece('\u265D',0,5,true); // bishop
        board[6][0] = new Piece('\u265E',0,6,true); // knight
        board[7][0] = new Piece('\u265C', 0,7,true); // rook
        // Black pawns
        board[0][1] = new Piece('\u265F',1,0,true);
        board[1][1] = new Piece('\u265F',1,1,true);
        board[2][1] = new Piece('\u265F',1,2,true);
        board[3][1] = new Piece('\u265F',1,3,true);
        board[4][1] = new Piece('\u265F',1,4,true);
        board[5][1] = new Piece('\u265F',1,5,true);
        board[6][1] = new Piece('\u265F',1,6,true);
        board[7][1] = new Piece('\u265F',1,7,true);


        //White rook, knight, bishop, king, queen:
        board[0][7] = new Piece('\u2656',7,0,false); // rook
        board[1][7] = new Piece('\u2658',7,1,false); // knight
        board[2][7] = new Piece('\u2657',7,2,false); // bishop
        board[4][7] = new Piece('\u2654',7,4,false); // king
        board[3][7] = new Piece('\u2655',7,3,false); // queen
        board[5][7] = new Piece('\u2657',7,5,false); // bishop
        board[6][7] = new Piece('\u2658',7,6,false); // knight
        board[7][7] = new Piece('\u2656', 7,7,false); // rook

        //White pawns
        board[0][6] = new Piece('\u2659',6,0,false);
        board[1][6] = new Piece('\u2659',6,1,false);
        board[2][6] = new Piece('\u2659',6,2,false);
        board[3][6] = new Piece('\u2659',6,3,false);
        board[4][6] = new Piece('\u2659',6,4,false);
        board[5][6] = new Piece('\u2659',6,5,false);
        board[6][6] = new Piece('\u2659',6,6,false);
        board[7][6] = new Piece('\u2659',6,7,false);

    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        char temp;
        Piece result=null;

        if(board[col][row]==null){
            result=null;

        }
        else if(board[col][row] !=null){
            temp = board[col][row].getCharacter();
            result = new Piece( temp, row, col, board[col][row].getIsBlack());
        }

        return result ;

    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        piece.setPosition(row,col);
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol, Board obj) {
        if (board[startCol][startRow] != null ) {
            if (board[startCol][startRow].isMoveLegal(obj, endRow, endCol)) {
                obj.setPiece(endRow, endCol, board[startCol][startRow]);
                board[endCol][endRow] = board[startCol][startRow]; // changes position of starting chess piece
                board[startCol][startRow]= null; // starting chess piece will no longer appear on chess board
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }

    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean kingOne = false; // checks if one king is gone
        boolean kingTwo = false;
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]!=null){
                    char result =board[i][j].getCharacter();
                    if(result=='\u265A'){
                        kingOne= true;
                    }
                    if (result=='\u2654'){
                        kingTwo= true;
                    }
                    if(kingOne && kingTwo){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String result ="   ";
        result= result +"0 " +  "1 " + "2 " + "3 " + "4 " + "5 " + "6 " + "7 " +"\n";
        result = result + '\uFF10';
        int counter=0;
        for(int i=0; i< board.length;i++){
            for(int x=0; x< board[0].length; x++){
                counter+=1;
                if(board[x][i] !=null){
                    result= result + "|"+  board[x][i].toString();
                }
                else if(board[x][i]==null){
                    result = result + "| ";
                }
                if(counter%8==0){
                    result = result+"|"+ "\n";
                }
                if(counter ==8){
                    result = result + '\uFF11';
                }
                if(counter ==16){
                    result = result + '\uFF12';
                }
                if(counter ==24){
                    result = result + '\uFF13';
                }
                if(counter ==32){
                    result = result + '\uFF14';
                }
                if(counter ==40){
                    result = result + '\uFF15';
                }
                if(counter ==48){
                    result = result + '\uFF16';
                }
                if(counter ==56){
                    result = result + '\uFF17';
                }
            }
        }
        return result;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {

        for(int i= 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                board[i][j] = null;
            }
        }

    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack, Board obj) {
        boolean first= false, second=false, third=false, fourth=false; // the different conditions that must be met

        if(startRow<= board.length && startCol <= board.length && endRow <= board.length && endCol <= board.length){
            first = true;
        }

        if(obj.getPiece(startRow, startCol) != null){
            second = true;
        }

        if(board[startCol][startRow].getIsBlack() == isBlack){
            third = true;
        }

        if(board[endCol][endRow]==null){
            fourth= true;
        }
        if(board[endCol][endRow] != null){
            if(board[endCol][endRow].getIsBlack() != isBlack){
                fourth = true;
            }
        }

        if (first && second && third && fourth) // if all conditions met, return true
            return true;
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        boolean first=false,second=false; // represents the different cases
        if(startRow+1>=0 && startRow+1< board.length && endRow==startRow+1){  // First case
            first=true;
        }
        if(startRow-1>=0 && startRow-1<board.length && endRow==startRow-1){
            first = true;
        }
        if(startRow==endRow){
            first=true;
        }
        if(startCol+1>=0 &&  startCol+1< board.length && endCol== startCol+1){ // Second case
            second=true;
        }
        if(startCol-1>=0 && startCol-1 < board.length && endCol == startCol-1){
            second= true;
        }
        if(startCol==endCol){
            second=true;
        }
        if(second && first){
            return true;
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        boolean first=false, second=false, third=false; // represents the different cases

        if(startRow==endRow && endCol<= board.length){ // checks if within range
            first = true;
        }
        else if (startRow!= endRow){
            return false;
        }

        int counter=0;
        int firstIndex = Math.min(startCol,endCol); // Both of these variable is useful when working with a starting point that is larger in value compared to the destination point values.
        int secondIndex = Math.max(startCol, endCol);

        for(int i=firstIndex; i<= secondIndex;i++){
            if(i != Math.min(startCol,endCol) && i != Math.max(startCol, endCol) && board[i][startRow]==null){ // counts empty spaces between starting point to destination
                counter+=1;
            }
            if(i==Math.max(startCol, endCol)){ // checks if the difference of starCol and endCol is equal to counter (non-inclusive)
                int spaces = Math.abs(startCol - endCol);
                second = (counter == spaces -1);
            }

            if(i!=Math.min(startCol,endCol) && i!=Math.max(startCol, endCol) && board[i][startRow]!=null){ // the occasion of when a spot is not empty
                third = true;
            }
        }
        if(first&& second && !third){
            return true;
        }
        else{
            return false;
        }
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        boolean first= false, second= false, third=false; // represents the different cases

        int counter=0;
        if(startCol== endCol && startCol<= board[0].length){
            first=true;
        }
        else if(startCol != endCol){
            return false;
        }
        int firstIndex = Math.min(startRow, endRow); // these two variables help to deal with the instances when the destination point value (endRow) is less than the starting point value(startRow)
        int secondIndex = Math.max(startRow, endRow);

        for(int i=firstIndex ; i<=secondIndex; i++){
            if( i!= Math.min(startRow, endRow) && i != Math.max(startRow, endRow) && board[startCol][i]==null){
                counter +=1;
            }
            if(i == Math.max(startRow, endRow)){  // checks if number of empty spaces (counter) is equal to the difference between startRow and endRow(non-inclusive)
                int spaces = Math.abs(startRow - endRow);
                second = (counter == spaces - 1);

            }
            if(i!= Math.min(startRow, endRow) && i !=Math.max(startRow, endRow) && board[startCol][i]!=null){
                third = true;
            }
        }
        if(first&& second && !third)
            return true;
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.

    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        boolean first = false, second=false, third=false, fourth=false; // represents the different cases
        int firstCount=0, secondCount=0, thirdCount=0 ,fourthCount=0; // counters for each case

        int beginRow = Math.min(startRow, endRow);
        int beginCol= Math.min(startCol, endCol);
        int lastRow= Math.max(endRow, startRow);
        int  lastCol= Math.max(endCol, startCol);

        for(int i=1; i< board.length; i++) {
            if ((beginCol + i) >= 0 && (beginCol + i) < board.length && (beginRow - i) >= 0 && (beginRow - i) < board.length && board[beginCol + i][beginRow - i] == null && lastRow != beginRow - i && lastCol != (beginCol + i)) {
                firstCount += 1; // counts empty spaces between starting point to ending point
            }
            if (lastRow == beginRow - i && lastCol == (beginCol + i)) { // determines if the number of empty spaces is equal to the difference between startCol and endCol
                int spaces = Math.abs(startCol - endCol);
                first = (firstCount == spaces - 1);
            }
        }

        for(int i=1; i< board.length; i++){
            if((beginCol-i)>=0 && (beginCol-i)< board.length && (beginRow+i)>=0 && (beginRow+i)< board.length && board[beginCol-i][beginRow+i]==null && lastCol != beginCol-i && lastRow!=beginRow+i ) {
                secondCount += 1;
            }
            if(lastRow==beginRow+i && lastCol==beginCol-i){
                int spaces = Math.abs(startCol - endCol);
                second = (secondCount == spaces - 1);
            }
        }

        for(int i=1; i< board.length; i++) {
            if ((beginCol + i) >= 0 && (beginCol + i) < board.length && (beginRow + i) >= 0 && (beginRow + i) < board.length && board[beginCol + i][beginRow + i]==null && lastRow != beginRow + i && lastCol != beginCol + i) {
                thirdCount += 1;
            }
            if (lastRow == beginRow + i && lastCol == beginCol + i) {
                int spaces = Math.abs(startCol - endCol);
                third = (thirdCount == spaces - 1);
            }
        }
        for(int i=1; i< board.length; i++) {

            if((beginCol-i)>=0 && (beginCol-i)< board.length && (beginRow-i)>=0 && (beginRow-i)< board.length && board[beginCol-i][beginRow-i]==null&& lastCol!=beginCol-i && lastRow!=beginRow-i) {
                fourthCount += 1;
            }
            if( lastCol==beginCol-i && lastRow==beginRow-i){
                int spaces = Math.abs(startCol - endCol);
                fourth = (fourthCount == spaces - 1);
            }
        }

        if(first || second || third || fourth){ // if at least one of the conditions is met, return true
            return true;
        }
        return false;
    }
}

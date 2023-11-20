//  Name:   Sandy Llapa
//  x500:   llapa016
public class Knight {
    int row;
    int col;
    boolean isBlack;

    public Knight(int row, int col, boolean isBlack){
        this.row= row;
        this.col=col;
        this.isBlack= isBlack;

    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        boolean first=false;  // represents the different possible moves for a knight
        boolean second=false;
        boolean third=false;
        boolean fourth = false;

        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endRow== (row-2) && endCol==(col-1)){  // north movement
            first = true;
        }
        else if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endRow== (row-2) && endCol==(col+1)){ // north
            first = true;
        }

        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endRow== (row+2) && endCol==(col-1)){ // south movement
            second = true;
        }
        else if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endRow== (row+2) && endCol==(col+1)){ // south
            second = true;
        }

        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endCol== (col-2) && endRow==(row-1)){ // west movement
            third = true;
        }
        else if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endCol== (col-2) && endRow==(row+1)){ // west
            third = true;
        }

        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endCol== (col+2) && endRow==(row-1)){ // east movement
            fourth = true;
        }
        else if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && endCol== (col+2) && endRow==(row+1)){ // east
            fourth = true;
        }

        if(first || second || third || fourth) // at least one condition is met
            return true;
        return false;


    }
}

//  Name:   Sandy Llapa
//  x500:   llapa016
public class Bishop {
    int row;
    int col;
    boolean isBlack;

    public Bishop(int row, int col, boolean isBlack){
        this.row=row;
        this.col=col;
        this.isBlack=isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && board.verifyDiagonal(row,col,endRow,endCol)){  // checks if destination and diagonal move is valid
            return true;
        }
        return false;
    }
}

//  Name:   Sandy Llapa
//  x500:   llapa016
public class King {
    int row;
    int col;
    boolean isBlack;


    public King(int row, int col, boolean isBlack){
        this.row= row;
        this.col = col;
        this.isBlack = isBlack;

    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifyAdjacent(row,col,endRow,endCol) && board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board)) // checks if move is legal for king piece
            return true;
        return false;
    }
}

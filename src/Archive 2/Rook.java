//  Name:   Sandy Llapa
//  x500:   llapa016
public class Rook {
    private int row;
    private int col;
    private boolean isBlack;

    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col=col;
        this.isBlack=isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && (board.verifyHorizontal(row, col, endRow, endCol))){  // both if statements determines if move is a valid horizontal and vertical move
            return true;
        }
        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && board.verifyVertical(row, col, endRow, endCol) ){
            return true;
        }
        return false;
    }
}

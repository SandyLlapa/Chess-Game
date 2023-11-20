//  Name:   Sandy Llapa
//  x500:   llapa016
public class Queen {
    int row;
    int col;
    boolean isBlack;

    public Queen(int row, int col, boolean isBlack){
        this.row= row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){ //determines if moves is valid for a queen piece
        if(board.verifySourceAndDestination(row,col,endRow,endCol,isBlack, board) && (board.verifyVertical(row,col,endRow,endCol) || board.verifyHorizontal(row,col,endRow,endCol) || board.verifyDiagonal(row,col,endRow,endCol))){
            return true;
        }
        return false;
    }
}

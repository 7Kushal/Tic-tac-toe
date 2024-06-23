package models;

public class Board {
    final private int size;
    public PlayingPice[][] board;

    public int getSize() {
        return size;
    }

    public PlayingPice[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPice[][] board) {
        this.board = board;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    int freeSpaces ;
    Board(int size){
        this.size =size;
        board = new PlayingPice[size][size];
        this.freeSpaces = size*size;
    }
    public boolean addPiece(int row, int col, PlayingPice p){
        if(board[row][col]!=null){
            System.out.println("Invalid Position please try again");
            return false;
        }
        freeSpaces--;
        board[row][col] = p;
        return true;
    }
    public boolean freeSpace(){
        return freeSpaces > 0;
    }
    public void printBoard(){
        System.out.println("------------------------------");
        for(int i =0 ; i< size;i++){
            for(int j=0;j<size;j++){
//                System.out.println("---");
                if(board[i][j]!=null)
                System.out.print(" " + board[i][j].p);
                else System.out.print(" N");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}

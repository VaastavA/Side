public class ChessBoard {

    private ChessBoardBLock[][] board = new ChessBoardBLock[8][8];

    public ChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new ChessBoardBLock((char)('A'+i),j);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
        }
        System.out.println();
    }

    public void move(Piece piece, char row, int column) {

    }

    class ChessBoardBLock{
        private char row;
        private int column;

        public ChessBoardBLock(char row,int column){
            this.row = row;
            this.column = column;
        }

        public char getRow() {
            return row;
        }

        public void setRow(char row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }
    }

}

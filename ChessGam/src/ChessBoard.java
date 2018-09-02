public class ChessBoard {
    private final static String LINE = "  -----------------------------------------";

    private ChessBoardBLock[][] board = new ChessBoardBLock[8][8];

    public ChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new ChessBoardBLock((char) ('A' + i), j);
            }
        }
    }

    public void printBoard() {
        System.out.println("Chess Board\n\n");
        System.out.println(LINE);
        for (int i = 7; i > -1; i--) {
            System.out.print((i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print("|" + board[i][j].toString());
            }
            System.out.print("|\n");
            System.out.println(LINE);
        }
        System.out.println("     A    B    C    D    E    F    G    H  ");
    }

    public void move(Piece piece, ChessBoardBLock chessBoardBLock) {
        if (chessBoardBLock.getPiece() != null) {
            chessBoardBLock.getPiece().setLife(false);
        }
        if (piece.getCurrent() != null) {
            piece.getCurrent().setPiece(null);
        }
        piece.setCurrent(chessBoardBLock);
        chessBoardBLock.setPiece(piece);

    }

    class ChessBoardBLock {
        private char row;
        private int column;
        private Piece piece;

        public ChessBoardBLock(char row, int column) {
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

        public Piece getPiece() {
            return piece;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public void setColumn(int column) {

            this.column = column;
        }

        @Override
        public String toString() {
            if (getPiece() == null) {
                return "    ";
            } else {
                if (getPiece().isColour()) {
                    return "wh " + getPiece().getSymbol();
                } else {
                    return "bL " + getPiece().getSymbol();
                }
            }
        }
    }

    public ChessBoardBLock[][] getBoard() {
        return board;
    }

    public void setBoard(ChessBoardBLock[][] board) {
        this.board = board;
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.printBoard();

    }

}

public class ChessBoard {
    private final static String LINE = "  -----------------------------------------";

    private ChessBoardBLock[][] board = new ChessBoardBLock[8][8];

    public ChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new ChessBoardBLock(j, (char) ('A' + i));
            }
        }
    }

    public void printBoard() {
        System.out.println("Chess Board\n\n");
        System.out.println(LINE);
        for (int i = 7; i > -1; i--) {
            System.out.print((i + 1) + " ");
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
        private int row;
        private char column;
        private Piece piece;

        public ChessBoardBLock(int row, char column) {
            this.row = row;
            this.column = column;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setColumn(char column) {
            this.column = column;
        }

        public int getRow() {
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

    public ChessBoardBLock getBlock(char c, int i) {
        if (c >= 'A' && c <= 'H' && i < 9 && i > 0) {
            System.out.println((c - 'A') + "   " + (i - 1));
            System.out.println(board[i-1][c-'A'].getPiece());
            return board[i - 1][c - 'A'];
        } else return null;
    }

    public void setBoard(ChessBoardBLock[][] board) {
        this.board = board;
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.printBoard();

    }

}

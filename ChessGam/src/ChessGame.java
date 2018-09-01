public class ChessGame {
    private ChessBoard chessBoard;
    private Piece[] pieces;

    public ChessGame() {
        chessBoard = new ChessBoard();
        pieces = new Piece[16];
        int a;
        boolean col;
        a = 0;
        col = true;
        for (int i = 0; i < 2; i++) {
            pieces[a++] = new Piece("Rook", col);
            pieces[a++] = new Piece("Knight", col);
            pieces[a++] = new Piece("Bishop", col);
            pieces[a++] = new Piece("Queen", col);
            pieces[a++] = new Piece("King", col);
            pieces[a++] = new Piece("Bishop", col);
            pieces[a++] = new Piece("Knight", col);
            pieces[a++] = new Piece("Rook", col);

            for (int j = 0; j < 8; j++) {
                pieces[a++] = new Piece("Pawn", col);
            }
            col = false;
        }
    }
}

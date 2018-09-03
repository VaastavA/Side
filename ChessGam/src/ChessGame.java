import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessGame {
    private ChessBoard chessBoard;
    private Piece[] pieces;
    private static final Pattern MOVES = Pattern.compile("(\\w)(\\d)\\s*(\\w)(\\d)");

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public ChessGame() {
        chessBoard = new ChessBoard();
        pieces = new Piece[32];
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

        startBoard();

    }

    private void startBoard() {
        for (int i = 0; i < 8; i++) {
            chessBoard.move(pieces[i], chessBoard.getBoard()[0][i]);
            System.out.println(chessBoard.getBoard()[0][i].toString());
            chessBoard.move(pieces[i + 8], chessBoard.getBoard()[1][i]);
        }
        for (int i = 16; i < 24; i++) {
            chessBoard.move(pieces[i], chessBoard.getBoard()[7][i - 16]);
            chessBoard.move(pieces[i + 8], chessBoard.getBoard()[6][i - 16]);
        }
    }

    public void startGame() {
        Scanner s = new Scanner(System.in);
        String input = "";
        int moves = 0;
        do {
            chessBoard.printBoard();
            if (moves % 2 != 0) {
                System.out.println("Black's turn: ");
                input = s.nextLine();
                if (input.equalsIgnoreCase("I")) intrcutions();
                if (parseMove(input)) moves++;
                else System.out.println("Bad input. Type I for instructions.");
            } else {
                System.out.println("White's turn: ");
                input = s.nextLine();
                if (input.equalsIgnoreCase("I")) intrcutions();
                if (parseMove(input)) moves++;
                else System.out.println("Bad input. Type I for instructions.");
            }
        } while (pieces[5].isLife() && pieces[5 + 16].isLife());
    }

    public boolean parseMove(String input) {
        Matcher m = MOVES.matcher(input);
        if (m.matches()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));
            ChessBoard.ChessBoardBLock temp1 = getChessBoard().getBlock(m.group(1).charAt(0), Integer.parseInt(m.group(2)));
            ChessBoard.ChessBoardBLock temp2 = getChessBoard().getBlock(m.group(3).charAt(0), Integer.parseInt(m.group(4)));
            if (temp1 == null || temp2 == null || temp1.getPiece() == null) return false;
            else {
                getChessBoard().move(temp1.getPiece(),temp2);
                return true;
            }
        }
        return false;

    }

    public void intrcutions() {
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        System.out.println(chessGame.getChessBoard().getBlock('E',1));
        chessGame.startGame();
    }
}

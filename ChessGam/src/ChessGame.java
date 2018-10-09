import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Row == Vertical value, horizontal constituents
 Column == Horizontal value, vertical constituents
 */
public class ChessGame {
    private ChessBoard chessBoard;
    private Piece[] pieces;
    int moves = 0;
    ChessBoard.ChessBoardBLock temp1 = null;
    ChessBoard.ChessBoardBLock temp2 = null;
    private static final Pattern MOVES = Pattern.compile("(\\w)(\\d)\\s*(\\w)(\\d)"); // format the move needs to be given in

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    /* Initialize board and all pieces
       and call startBoard() to
       place them accordingly on board
     */
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

    /* Places pieces at the starting postions
    according to cheese board format
     */
    private void startBoard() {
        for (int i = 0; i < 8; i++) {
            chessBoard.move(pieces[i], chessBoard.getBoard()[0][i]);
            chessBoard.move(pieces[i + 8], chessBoard.getBoard()[1][i]);
        }
        for (int i = 16; i < 24; i++) {
            chessBoard.move(pieces[i], chessBoard.getBoard()[7][i - 16]);
            chessBoard.move(pieces[i + 8], chessBoard.getBoard()[6][i - 16]);
        }
    }

    /*Starts taking moves, checking if move is legal
    and performing moves based on parsed input.
    Checks life of both kings after every move
     */
    public void startGame() {
        Scanner s = new Scanner(System.in);
        String input = "";
        do {
            chessBoard.printBoard();
            if (moves % 2 != 0) {
                System.out.println("Black's turn: ");
                input = s.nextLine();
                if (input.equalsIgnoreCase("I")) instrcutions();
                if (parseMove(input)) ;
                else { System.out.println("Bad input. Type I for instructions."); continue; }
                if (checkLegal()) {
                    moves++;
                    getChessBoard().move(temp1.getPiece(), temp2);
                } else { System.out.println("Illegal Move. Type I for instructions.") ; continue; }
            } else {
                System.out.println("White's turn: ");
                input = s.nextLine();
                if (input.equalsIgnoreCase("I")) instrcutions();
                if (parseMove(input)) ;
                else { System.out.println("Bad input. Type I for instructions."); continue; }
                if (checkLegal()) {
                    moves++;
                    getChessBoard().move(temp1.getPiece(), temp2);
                } else { System.out.println("Illegal Move. Type I for instructions."); continue; }
            }
        } while (pieces[5].isLife() && pieces[5 + 16].isLife());
    }

    private boolean parseMove(String input) {
        Matcher m = MOVES.matcher(input);
        if (m.matches()) {
            temp1 = getChessBoard().getBlock(m.group(1).charAt(0), Integer.parseInt(m.group(2)));
            temp2 = getChessBoard().getBlock(m.group(3).charAt(0), Integer.parseInt(m.group(4)));
            if (temp1 == null || temp2 == null || temp1.getPiece() == null) return false;
            else {
                return true;
            }
        }
        return false;

    }

    private boolean checkLegal() {
        //getChessBoard().move(temp1.getPiece(),temp2);        Actually make the move after checking if its legal
        char piece = temp1.getPiece().getSymbol().charAt(0);

        switch (piece) {
            case 'P':
                return checkPawn();
            case 'K':
                break;
            case 'Q':
                break;
            case 'B':
                break;
            case 'R':
                break;
            case 'N':
                break;
        }
        return true;
    }

    private boolean checkPawn() {
        int startRow = temp1.getRow();
        int startColumn = temp1.getColumn();
        int endRow = temp2.getRow();
        int endColumn = temp2.getColumn();
        boolean colour = temp1.getPiece().isColour();
        int horizontal = endColumn - startColumn;
        int vertical = endRow - startRow;

        if (horizontal ==1 || horizontal == -1){
            if((colour && vertical!=1) || (!colour && vertical!=-1)) return false;
            if(temp2.getPiece()==null) return false;
            else return true;
        }else if(horizontal>1 || horizontal<-1) return false;
        else if (colour) {
            if (vertical <= 0) return false; //moving in right direction for colour
            if (startRow == 1 && vertical == 2 && getChessBoard().getBoard()[startRow + 1][startColumn-65].getPiece() == null)
                return true; //start position rule
            else if (vertical != 1) return false; // can only move one position
            else return true;
        } else {
            if (vertical >= 0) return false;
            if (startRow == 6 && vertical == -2 && getChessBoard().getBoard()[startRow - 1][startColumn-65].getPiece() == null)
                return true;
            else if (vertical != -1) return false;
            else return true;
        }
    }

    private boolean underCheck() {
        return false;
    }

    public void instrcutions() {
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.startGame();
    }
}

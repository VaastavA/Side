import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessGame {
    private ChessBoard chessBoard;
    private Piece[] pieces;
    int moves = 0;
    ChessBoard.ChessBoardBLock temp1 = null;
    ChessBoard.ChessBoardBLock temp2 = null;
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
        do {
            chessBoard.printBoard();
            if (moves % 2 != 0) {
                System.out.println("Black's turn: ");
                input = s.nextLine();
                if (input.equalsIgnoreCase("I")) intrcutions();
                if (parseMove(input)) ;
                else System.out.println("Bad input. Type I for instructions.");
                if (checkLegal()) moves++;
                else System.out.println("Illegal Move. Type I for instructions.");
            } else {
                System.out.println("White's turn: ");
                input = s.nextLine();
                if (input.equalsIgnoreCase("I")) intrcutions();
                if (parseMove(input)) ;
                else System.out.println("Bad input. Type I for instructions.");
                if (checkLegal()) moves++;
                else System.out.println("Illegal Move. Type I for instructions.");
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
            temp1 = getChessBoard().getBlock(m.group(1).charAt(0), Integer.parseInt(m.group(2)));
            temp2 = getChessBoard().getBlock(m.group(3).charAt(0), Integer.parseInt(m.group(4)));
            if (temp1 == null || temp2 == null || temp1.getPiece() == null) return false;
            else {
                return true;
            }
        }
        return false;

    }

    public boolean checkLegal(){
        //getChessBoard().move(temp1.getPiece(),temp2);        Actually make the move after checking if its legal
        if((temp1.getPiece().isColour()==true && moves%2!=0) || (temp1.getPiece().isColour()==false && moves%2==0) ){
            return false;
        }
        if(temp2.getPiece()!=null && temp1.getPiece().isColour()==temp2.getPiece().isColour()){
            return false;
        }else {
            if(temp1.getPiece().getSymbol().equals("K")){
                if(Math.abs(temp1.getRow()-temp2.getRow())>1 && Math.abs(temp1.getColumn()-temp2.getColumn())>1){
                    return false;
                    //check for check
                }else {
                    getChessBoard().move(temp1.getPiece(),temp2);
                    return true;
                }
            }else if(temp1.getPiece().getSymbol().equals("Q")){
                if((Math.abs(temp1.getRow()-temp2.getRow())!= Math.abs(temp1.getColumn()-temp2.getColumn()) || Math.abs(temp1.getRow()-temp2.getRow())!=0 || Math.abs(temp1.getRow()-temp2.getRow())!=0)){
                    return false;
                }
                if(Math.abs(temp1.getRow()-temp2.getRow())==0){
                    //check up/down path for piece
                }
                else{
                    getChessBoard().move(temp1.getPiece(),temp2);
                    return true;
                }
            }else if(temp1.getPiece().getSymbol().equals("P")){

            }
        }
    }

    public void intrcutions() {
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.startGame();
    }
}

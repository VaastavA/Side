public class Piece {
    private String name;
    private char symbol;
    private boolean colour;  //white true black false
    private boolean life;
    private ChessBoard.ChessBoardBLock current;


    public Piece(String name, boolean colour){
        this.name = name;
        symbol = parseSymbol(name);
    }
    public char boardPrint() {
        return getSymbol();
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isColour() {
        return colour;
    }

    public void setColour(boolean colour) {
        this.colour = colour;
    }

    public char parseSymbol(String name){
        if(name.equalsIgnoreCase("King")){
            return 'K';
        }
        else if(name.equalsIgnoreCase("Queen")){
            return 'K';
        }
        else if(name.equalsIgnoreCase("Knight")){
            return 'K';
        }
        else if(name.equalsIgnoreCase("Bishop")){
            return 'K';
        }
        else if(name.equalsIgnoreCase("Rook")){
            return 'K';
        }
        else if(name.equalsIgnoreCase("Pawn")){
            return 'K';
        }
        else {
            return ' ';
        }

    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public void kill(){
        setLife(false);
    }


}

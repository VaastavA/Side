public class Piece {
    private String name;
    private String symbol;
    private boolean colour;  //white true black false
    private boolean life;
    private ChessBoard.ChessBoardBLock current;


    public Piece(String name, boolean colour){
        this.name = name;
        symbol = parseSymbol(name);
    }

    public String getName() {
        return name;
    }

    public ChessBoard.ChessBoardBLock getCurrent() {
        return current;
    }

    public void setCurrent(ChessBoard.ChessBoardBLock current) {
        this.current = current;
    }

    public String getSymbol() {

        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isColour() {
        return colour;
    }

    public void setColour(boolean colour) {
        this.colour = colour;
    }

    public String parseSymbol(String name){
        if(name.equalsIgnoreCase("King")){
            return "K";
        }
        else if(name.equalsIgnoreCase("Queen")){
            return "Q";
        }
        else if(name.equalsIgnoreCase("Knight")){
            return "N";
        }
        else if(name.equalsIgnoreCase("Bishop")){
            return "B";
        }
        else if(name.equalsIgnoreCase("Rook")){
            return "R";
        }
        else if(name.equalsIgnoreCase("Pawn")){
            return "P";
        }
        else {
            return "";
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

public class Cell {
    CellState cs;
    Coordinates cd;
    int maxY;

    public CellState getCs() {
        return cs;
    }

    public void setCs(CellState cs) {
        this.cs = cs;
    }

    public Cell() {
        this.cs = CellState.CLOSED;
    }

    class Coordinates{
        int x,y,actual;

        public int getY() {
            return y;
        }

        public int getActual() {
            return actual;
        }

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
            actual = ComputeActual();
        }

        public void setActual(int actual) {
            this.actual = actual;
        }

        public int getX() {
            return x;

        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;

        }

        public int ComputeActual(){
            return (x*maxY)+y;
        }
    }


}

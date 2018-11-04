import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Logic {
    private UnionFind UF;
    private Cell[][] grid;
    private Cell[][] gridUpdate;
    private int gridSize;

    public Logic(int size) {
        this.UF = new UnionFind(size);
        defaultCell(grid);
        defaultCell(gridUpdate);
        gridSize = size;
    }

    public void defaultCell(Cell[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; i < a[i].length; j++) {
                a[i][j] = new Cell();
                a[i][j].cd.setX(i);
                a[i][j].cd.setY(j);
            }
        }
    }

    public void MonteCarlo(){
        Random r = new Random(3);
        while (true){
            int now = r.nextInt(gridSize*gridSize);
            if(grid[now/gridSize][now%gridSize].cs==CellState.OPEN) continue;
            else {
                grid[now/gridSize][now%gridSize].cs = CellState.OPEN;
            }
        }
    }


    public void update() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j].cs!=CellState.CLOSED)
                if (flows(i, j)) {
                    gridUpdate[i][j].setCs(CellState.FLOWING);
                } else {
                    gridUpdate[i][j].setCs(grid[i][j].cs);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].setLiving(gridUpdate[i][j].getLiving());
            }
        }
    }

    public static JFrame frame = new JFrame();
    public static JPanel[][] gridGUI;

    public void initGridGUI() {
        gridGUI = new JPanel[grid.length][grid[0].length]; //allocate the size of grid
        frame.setLayout(new GridLayout(grid.length, grid[0].length)); //set layout
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridGUI[i][j] = new JPanel(); //creates new panel
                gridGUI[i][j].setBackground(Color.white);
                frame.add(gridGUI[i][j]);
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setLocationRelativeTo(null);
        frame.setTitle("Conway's Game of Life");
        frame.setVisible(true);
    }

    public void printGridGUI() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getCs() == CellState.CLOSED) {
                    gridGUI[i][j].setBackground(Color.black);
                }
                if (grid[i][j].getCs() == CellState.OPEN) {
                    gridGUI[i][j].setBackground(Color.white);
                } else {
                    gridGUI[i][j].setBackground(Color.BLUE);
                }
            }
        }
    }

    public void printGrid() {

        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                for (int k = 0; k < grid[i].length + 1; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                if (j == grid[i].length - 1) {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    System.out.println("|");
                } else {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            if (i == grid.length - 1) {
                for (int k = 0; k < grid[i].length; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
        }
    }
}

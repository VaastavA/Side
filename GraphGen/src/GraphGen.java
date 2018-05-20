import javax.swing.*;
import java.util.ArrayList;

public class GraphGen {
    private Line[] graph = new Line[201];
    private String input = "";
    private int a, b, c;
    private static String tp = "x\\^2";

    public GraphGen() {
        for (int i = 0; i < 201; i++) {
            graph[i] = new Line();
            if (i == 100) {
                graph[i].addAxis();
            }
        }
    }

    public void takeInput() {
        while (true) {
            input = JOptionPane.showInputDialog("Enter Function :");
            try {
                parse(input);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid Input!\nEnter function of the format Ax^2+Bx+C", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
        }
    }

    public void parse(String s) throws NumberFormatException {
        String[] partA = s.split(tp);
        a = Integer.parseInt(partA[0]);
        String[] partB = partA[1].split("x");
        b = Integer.parseInt(partB[0]);
        c = Integer.parseInt(partB[1]);
    }

    class Line {
        private String[] sample = new String[201];
        private String DOT = "*";
        private String PLUS = "+";

        Line() {
            for (int i = 0; i < 201; i++) {
                if (i == 100) {
                    sample[i] = "|";
                } else {
                    sample[i] = DOT;
                }
            }
        }

        public void AddPoint(int a) {
            sample[a] = PLUS;
        }

        public void addAxis() {
            for (int i = 0; i < 201; i++) {
                sample[i] = "-";
            }
        }

        public void print() {
            for (int i = 0; i < 201; i++) {
                System.out.print(sample[i]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("x^2");
        GraphGen a = new GraphGen();
        a.takeInput();
        a.graph[1].print();
    }
}

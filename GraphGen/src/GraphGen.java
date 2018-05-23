import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphGen {
    private static final Pattern QUADRATIC_FORM = Pattern.compile("([+-]?\\d+)[Xx]2\\s*([+-]?\\d+)[Xx]\\s*([+-]?\\d+)\\s*");
    private Line[] graph = new Line[201];
    private String input = "";
    private int a, b, c;

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
                JOptionPane.showMessageDialog(null, "Invalid Input!\nEnter function of the format Ax2+Bx+C", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
        }
    }

    public void parse(String s) throws NumberFormatException {
        Matcher matcher = QUADRATIC_FORM.matcher(s);
        if (!matcher.matches()) {
            throw new NumberFormatException();
        }
        a = Integer.parseInt(matcher.group(1));
        b = Integer.parseInt(matcher.group(2));
        c = Integer.parseInt(matcher.group(3));
        compute();
    }

    public void compute() {
        for (int i = -100; i <= 200; i++) {
            float q = (a * i * i) + (b * i) + c;
            int t = Math.round(q);
            if (t >= -100 && t <= 100) {
                graph[t + 100].addPoint(i + 100);
            }
        }
    }

    //Print bottom to top pls
    public void print() {
        for (int i = 200; i >= 0; i--) {
            graph[i].print();
        }
    }

    class Line {
        private String[] sample = new String[201];
        private String DOT = ".";
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

        public void addPoint(int a) {
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
        GraphGen a = new GraphGen();
        a.print();
        System.out.println();
        a.takeInput();
        a.print();

    }
}

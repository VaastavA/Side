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
        System.out.println(String.format("%d,%d,%d",a.a,a.b,a.c));
    }
}

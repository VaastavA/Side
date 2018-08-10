import javax.swing.*;


public class GraphGen {
    private Line[] graph = new Line[201];
    private String input = "";
    private int degree;
    private double coeffs[];

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
            input = JOptionPane.showInputDialog("Enter Degree of function :");
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
        degree = Integer.parseInt(s);
        if (degree < 0) {
            throw new NumberFormatException();
        }
        coeffs = new double[degree + 1];

        for (int i = 0; i < degree + 1; ) {
            String coeffer = JOptionPane.showInputDialog("Enter " + i + " degree coefficent: ");
            double temp;
            try {
                temp = Double.parseDouble(coeffer);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Number entered is not integer", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            coeffs[i] = temp;
            i++;
        }
        compute();
    }

    public void compute() {
        for (int i = 0; i < 201; i++) {

            double temp = 0;
            for (int j = 0; j < degree + 1; j++) {
                temp += coeffs[j] * Math.pow(i - 100, j);
            }
            int temper = (int) Math.round(temp);
            if (temper <= 100 && temper >= -100) {
                graph[temper+100].addPoint(i);
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
        while (true) {
            GraphGen a = new GraphGen();
            a.print();
            System.out.println();
            a.takeInput();
            a.print();
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to plot again?", "Confrim", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.NO_OPTION) {
                System.out.println("Thank you for using GraphGen");
                break;
            }
        }
    }
}

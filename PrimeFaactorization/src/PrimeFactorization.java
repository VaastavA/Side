import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.ArrayList;

public class PrimeFactorization {
    private int Number1;
    private ArrayList<Integer> factors;


    public PrimeFactorization(int Number1) {
        setNumber1(Number1);
        setFactors(new ArrayList<>());
    }

    public void factorize() {
        int number = getNumber1();
        if (number < 0) {
            factors.add(-1);
            number *= -1;
        }
        if (number == 0) {
            factors.add(0);
            return;
        }
        int quotient = 0;
        for (int i = 2; i <= number; ) {
            if (number % i == 0) {
                factors.add(i);
                number /= i;
                continue;
            } else {
                i++;
            }
        }
    }

    public String print() {
        String factors = "";
        ArrayList<Integer> printIt = getFactors();
        for (Integer i : printIt) {
            factors += (i + " x ");
        }
        int lastX = factors.lastIndexOf('x');
        factors = factors.substring(0, lastX);

        return factors;
    }

    public int getNumber1() {
        return Number1;
    }

    public ArrayList<Integer> getFactors() {
        return factors;
    }

    public void setNumber1(int number1) {
        Number1 = number1;
    }

    public void setFactors(ArrayList<Integer> factors) {
        this.factors = factors;
    }

    public static void main(String[] args) {
        while (true) {
            int argument = 0;
            while (true) {
                String input = JOptionPane.showInputDialog(null, "Enter Number to Prime Factorize: ", "Prime Factorizer", JOptionPane.PLAIN_MESSAGE);
                try {
                    argument = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Input is not an Integer", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }
            PrimeFactorization pf = new PrimeFactorization(argument);
            pf.factorize();
            JOptionPane.showMessageDialog(null, pf.print());
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to try another number?", "Rerun", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for using Primefactorizer", "Exit", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (answer == JOptionPane.YES_OPTION) {
                continue;
            }
        }
    }
}

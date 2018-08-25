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
        if(number<0){
            factors.add(-1);
            number *= -1;
        }
        if(number ==0){
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

    public String print(){
        String factors = "";
        ArrayList<Integer> printIt = getFactors();
        for(Integer i : printIt){
            factors += (i+" x ");
        }
        int lastX = factors.lastIndexOf('x');
        factors = factors.substring(0,lastX);

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
        PrimeFactorization pf = new PrimeFactorization(Integer.parseInt(args[0]));
        pf.factorize();
        System.out.println(pf.print());
    }
}

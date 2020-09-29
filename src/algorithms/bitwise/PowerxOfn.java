package algorithms.bitwise;

import java.util.Scanner;

public class PowerxOfn {

    private static final Scanner scanner = new Scanner(System.in);

    public static double myPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long)n);
        while(absN > 0) {
            if((absN & 1) == 1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;

        /*
        if(x == (double) 1) return x;
        double res = 1;
        long m = Math.abs((long) n);
        while (m-- >= 1) {
            res *= x;
        }
        return n > 0 ? res : 1 / res;
        */
    }

    /*
    public double myPow(double x, int m) {
             double temp = x;
             if(m == 0) return 1;

             temp = myPow(x, m / 2);

             if(m % 2 == 0) return temp*temp;
             else {
                 if(m > 0) return x * temp * temp;
                 else return (temp * temp) / x;
             }
     }
     */


    public static void main(String[] args) {

        System.out.println("Enter Number: ");
        double num = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Exponent: ");
        int expo = Integer.parseInt(scanner.nextLine());

        System.out.println(myPow(num, expo));
    }
}

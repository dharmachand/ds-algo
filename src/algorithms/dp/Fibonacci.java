package algorithms.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static final Scanner scanner = new Scanner(System.in);

    public static final int MAX = 100;
    public static final int NIL = -1;

    private long[] lookup;

    public Fibonacci() {
        lookup = new long[MAX];
        Arrays.fill(lookup, NIL);
        lookup[0] = 0;
        lookup[1] = 1;
    }

    //Dynamic Programming with memoization which is top down
    //It is nothing but recursion with storing values of previous state or sub-problem
    //Time Complexity: Polynomial
    private long getNthFibonacciDPMemoization(int n) {
        if ( n > 1 && lookup[n] == NIL) {
            lookup[n] = getNthFibonacciDPMemoization(n - 1) + getNthFibonacciDPMemoization(n - 2);
        }
        return lookup[n];
    }

    //Dynamic Programming with tabulation which is bottom down
    //It is non-recursive with storing values from base state or starting sub-problem
    //Time Complexity: Polynomial
    private long getNthFibonacciDPTabulation(int n) {
        //lookup[0] and lookup[1] are already initialized in constructor
        for (int i = 2; i < n + 1; i++) {
            lookup[i] = lookup[i - 1] + lookup[i - 2];
        }
        return lookup[n];
    }

    //No recursion Time Complexity: O(n)
    private long getNthFibonacciNonRecursive(int n) {
        long f0 = 0, f1 = 1, fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    //Plain recursion :: Time Complexity: Exponential
    private long getNthFibonacciRecursive(int n) {
        if (n == 0 || n == 1) return n;
        return getNthFibonacciRecursive(n - 1) + getNthFibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Enter number[0 - 100]: ");
        int n = Integer.parseInt(scanner.nextLine());

        if (n >= 100) {
            System.out.println("Number out of range, should be between 0 and 100");
        } else {
            Fibonacci fibonacci = new Fibonacci();
            long startTime = System.currentTimeMillis();
            System.out.print("Nth Fibonacci Number (DP -> Memoization -> TopDown): " + fibonacci.getNthFibonacciDPMemoization(n));
            long endTime = System.currentTimeMillis();
            System.out.println("( " + (endTime - startTime) + " ms )");

            fibonacci = new Fibonacci();
            startTime = System.currentTimeMillis();
            System.out.print("Nth Fibonacci Number (DP -> Tabulation -> BottomUp): " + fibonacci.getNthFibonacciDPTabulation(n));
            endTime = System.currentTimeMillis();
            System.out.println("( " + (endTime - startTime) + " ms )");

            fibonacci = new Fibonacci();
            startTime = System.currentTimeMillis();
            System.out.print("Nth Fibonacci Number (Non Recursive): " + fibonacci.getNthFibonacciNonRecursive(n));
            endTime = System.currentTimeMillis();
            System.out.println("( " + (endTime - startTime) + " ms )");

            fibonacci = new Fibonacci();
            startTime = System.currentTimeMillis();
            System.out.print("Nth Fibonacci Number (Plain Recursive): " + fibonacci.getNthFibonacciRecursive(n));
            endTime = System.currentTimeMillis();
            System.out.println("( " + (endTime - startTime) + " ms )");
        }

    }

}

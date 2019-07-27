package datastructures.stacks;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class MinStack extends Stack<Integer> {
    private Stack<Integer> min = new Stack<>();

    @Override
    public Integer push(Integer value) {
        super.push(value);
        if (min.isEmpty()) {
            min.push(value);
        } else {
            Integer minVal = min.peek();
            if (minVal < value) min.push(minVal);
            else min.push(value);
        }
        return value;
    }

    @Override
    public Integer pop() {
        min.pop();
        return super.pop();
    }

    //time: O(1) and space: O(n)
    public Integer getMin() {
        if (min.isEmpty()) throw new EmptyStackException();
        return min.peek();
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //18 19 29 15 16
        System.out.println("Enter integers: ");
        String[] nk = scanner.nextLine().split(" ");

        MinStack minStack = new MinStack();

        for (int i = 0; i < nk.length; i++) {
            minStack.push(Integer.parseInt(nk[i]));
        }

        System.out.println("Top of the min stack is: " + minStack.getMin());

        System.out.println("Min integers popped out of stack: ");
        while (!minStack.isEmpty()) {
            System.out.print(minStack.pop() + " ");
        }
        System.out.println(" ");

        // push elements gain
        for (int i = 0; i < nk.length; i++) {
            minStack.push(Integer.parseInt(nk[i]));
        }

        minStack.pop();
        minStack.pop();

        System.out.println("After popping 2 elements from stack");
        System.out.println("Top of the min stack is: " + minStack.getMin());

        System.out.println("Min integers popped out of stack: ");
        while (!minStack.isEmpty()) {
            System.out.print(minStack.pop() + " ");
        }
        System.out.println(" ");

    }
}

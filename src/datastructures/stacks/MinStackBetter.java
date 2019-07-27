package datastructures.stacks;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class MinStackBetter extends Stack<Integer> {
    private Integer minElem = 0;

    @Override
    public Integer push(Integer value) {
        if (super.isEmpty()) {
            minElem = value;
            super.push(value);
        } else {
            if (value >= minElem) super.push(value);
            else {
                super.push(2 * value - minElem);
                minElem = value;
            }
        }
        return value;
    }

    @Override
    public Integer pop() {
        int value = super.pop();
        if (value < minElem) {
            int prevMin = minElem;
            minElem = 2 * minElem - value;
            value = prevMin;
        }
        return value;
    }

    //time: O(1) and space: O(1)
    public Integer getMin() {
        if (super.isEmpty()) throw new EmptyStackException();
        return minElem;
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //18 19 29 15 16
        System.out.println("Enter integers: ");
        String[] nk = scanner.nextLine().split(" ");

        MinStackBetter minStack = new MinStackBetter();

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

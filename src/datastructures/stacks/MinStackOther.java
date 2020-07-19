package datastructures.stacks;

import java.util.Arrays;

public class MinStackOther {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    MinStackOther() {
        stack = new Stack<>();
    }
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        int[] input = {-2, 0, -3};
        MinStackOther minS = new MinStackOther();
        for (int in : input) {
            minS.push(in);
        }
        System.out.println("Input Stack: " + Arrays.toString(input));
        System.out.print("Popping from stack: " );
        int count = input.length;
        while (count > 0) {
            System.out.print(minS.top() + " ");
            minS.pop();

            count--;
        }
    }
}

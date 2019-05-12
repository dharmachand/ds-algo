package datastructures.stacks;

import java.util.Scanner;

public class Stack<T> {

    public static Scanner scanner = new Scanner(System.in);

    public Node top;

    class Node {
        T data;
        Node next;

        public Node(T value) {
            this.data = value;
        }
    }

    public void push(T value) {
        Node node = new Node(value);
        node.next = this.top;
        this.top = node;
    }

    public T pop() {
        if (this.isEmpty()) throw new IllegalStateException("stack is empty");
        T value = this.top.data;
        this.top = this.top.next;
        return value;
    }

    public T peek() {
        if (this.isEmpty()) throw new IllegalStateException("stack is empty");
        return this.top.data;
    }


    public boolean isEmpty() {
        return this.top == null;
    }

    public static void main(String[] args) {

        System.out.println("Enter integers: ");
        String[] nk = scanner.nextLine().split(" ");

        Stack<Integer> intStack = new Stack<>();

        for (int i = 0; i < nk.length; i++) {
            intStack.push(Integer.parseInt(nk[i]));
        }

        System.out.println("Top of the integer stack is: " + intStack.peek());

        System.out.println("Integers popped out of stack: ");
        while (!intStack.isEmpty()) {
            System.out.print(intStack.pop() + " ");
        }
        System.out.println(" ");

        System.out.println("Enter strings: ");
        String[] sk = scanner.nextLine().split(" ");

        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < sk.length; i++) {
            stringStack.push(sk[i]);
        }

        System.out.println("Top of the string stack is: " + stringStack.peek());

        System.out.println("Strings popped out of stack: ");
        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop() + " ");
        }
        System.out.println(" ");


    }
}

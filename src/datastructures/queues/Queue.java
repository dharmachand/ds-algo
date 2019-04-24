package datastructures.queues;

import java.util.Scanner;

public class Queue {

    public static final Scanner scanner = new Scanner(System.in);

    private int rear, front, size;
    private int capacity;
    private  int[] array;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        array = new int[this.capacity];
    }

    public boolean isFull() {
        return (this.size == this.capacity);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    private void enqueue(int element) {
        if (isFull()) { return; }
        this.rear = (this.rear + 1) % this.capacity;
        array[this.rear] = element;
        this.size = this.size + 1;
    }

    private int dequeue () {
        if (isEmpty()) { return Integer.MIN_VALUE; }
        int element = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return element;
    }

    private int front() {
        if (isEmpty()) { return Integer.MIN_VALUE; }
        return this.array[this.front];
    }

    private int rear() {
        if (isEmpty()) { return Integer.MIN_VALUE; }
        return this.array[this.rear];
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        Queue elementQueue = new Queue(100);

        for (int i = 0; i < nk.length; i++) {
            elementQueue.enqueue(Integer.parseInt(nk[i]));
        }

        System.out.println("Queue front: " + elementQueue.front());

        System.out.println("Queue rear: " + elementQueue.rear());

        System.out.println("Elements de-queued: ");
        while (!elementQueue.isEmpty()) {
            System.out.print(elementQueue.dequeue() + " ");
        }
    }



}

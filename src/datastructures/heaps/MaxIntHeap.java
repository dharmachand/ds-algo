package datastructures.heaps;

import java.util.Arrays;
import java.util.Scanner;

public class MaxIntHeap {

    public static Scanner scanner = new Scanner(System.in);

    private int capacity;
    private int size;
    private int[] elements;

    public MaxIntHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.elements = new int[this.capacity];
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            this.capacity *= 2;
            this.elements = Arrays.copyOf(elements, this.capacity);
        }
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int leftChild(int parentIndex) {
        return this.elements[getLeftChildIndex(parentIndex)];
    }

    public int rightChild(int parentIndex) {
        return this.elements[getRightChildIndex(parentIndex)];
    }

    public int parent(int childIndex) {
        return this.elements[getParentIndex(childIndex)];
    }

    public boolean hasLeftChild(int parentIndex) {
        return this.getLeftChildIndex(parentIndex) < this.size;
    }

    public boolean hasRightChild(int parentIndex) {
        return  this.getRightChildIndex(parentIndex) < this.size;
    }

    public boolean hasParent(int childIndex) {
        return this.getParentIndex(childIndex) >= 0;
    }

    public void swap(int fromIndex, int toIndex) {
        int temp = this.elements[fromIndex];
        this.elements[fromIndex] = this.elements[toIndex];
        this.elements[toIndex] = temp;
    }

    //Time Complexity: O(Logn)
    public void add(int value) {
        ensureCapacity();
        this.elements[this.size] = value;
        this.size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = this.size - 1;
        while (hasParent(index) && this.elements[index] > parent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    //Time Complexity: O(1)
    public int peek() { //peek will return root which is max element
        if (this.size == 0) throw new IllegalStateException("empty heap");
        return this.elements[0];
    }

    //Time Complexity: O(Logn)
    public int poll() { // poll will extract max
        if (size == 0) throw new IllegalStateException("empty heap");
        int maxElement = this.elements[0];
        this.elements[0] = this.elements[this.size - 1];
        this.size--;
        heapifyDown();
        return maxElement;
    }

    //Time Complexity: O(Logn)
    public int extractMax() {
        return this.poll();
    }

    //Time Complexity: O(Logn)
    private void heapifyDown() {
        int index = 0;
        int biggerChildIndex;
        while (hasLeftChild(index)) {
            biggerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (this.elements[biggerChildIndex] > this.elements[index]) {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }


    public void printElements() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elements[i] + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        //7 10 4 3 20 15
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        MaxIntHeap maxHeap = new MaxIntHeap(nk.length);

        //Time Complexity for building heap: O(n)
        for (int i = 0; i < nk.length; i++) {
            maxHeap.add(Integer.parseInt(nk[i]));
        }

        System.out.println("Root of max heap (largest element): " + maxHeap.peek());
        System.out.println("Max Heap elements: ");
        maxHeap.printElements();
    }

}

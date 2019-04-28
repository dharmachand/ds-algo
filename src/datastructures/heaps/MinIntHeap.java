package datastructures.heaps;

import java.util.Arrays;
import java.util.Scanner;

public class MinIntHeap {

    public static final Scanner scanner = new Scanner(System.in);

    private int capacity;
    private int size;
    private int[] elements;

    public MinIntHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.elements = new int[this.capacity];
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

    public int leftChild(int index) {
        return this.elements[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return this.elements[getRightChildIndex(index)];
    }

    public int parent(int index) {
        return this.elements[getParentIndex(index)];
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < this.size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < this.size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public void swap(int fromIndex, int toIndex) {
        int temp = this.elements[fromIndex];
        this.elements[fromIndex] = this.elements[toIndex];
        this.elements[toIndex] = temp;
    }

    public void ensureExtraCapacity() {
        if (this.size == this.capacity) {
            this.elements = Arrays.copyOf(elements, 2 * capacity);
            this.capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("empty heap");
        return elements[0]; //return root which is min element
    }

    public int poll() { // poll will extract min
        if (size == 0) throw new IllegalStateException("empty heap");
        int element = this.elements[0];
        this.elements[0] = this.elements[this.size - 1];
        size--;
        heapifyDown();
        return element;
    }

    public int extractMin() {
        return poll();
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (this.elements[index] < this.elements[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void add(int value) {
        ensureExtraCapacity();
        this.elements[size] = value;
        this.size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > this.elements[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void printElements() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elements[i] + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        MinIntHeap minHeap = new MinIntHeap(nk.length);

        for (int i = 0; i < nk.length; i++) {
            minHeap.add(Integer.parseInt(nk[i]));
        }

        System.out.println("Min Heap elements: ");
        minHeap.printElements();


    }
}

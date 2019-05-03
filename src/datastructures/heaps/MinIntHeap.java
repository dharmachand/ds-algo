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
            this.capacity *= 2;
            this.elements = Arrays.copyOf(elements, this.capacity);
        }
    }

    //Time Complexity: O(1)
    public int peek() { //peek will return root which is min element
        if (this.size == 0) throw new IllegalStateException("empty heap");
        return this.elements[0]; //root is min element
    }

    //Time Complexity: O(Logn)
    public int poll() { // poll will extract min
        if (this.size == 0) throw new IllegalStateException("empty heap");
        int minElement = this.elements[0];
        this.elements[0] = this.elements[this.size - 1];
        this.size--;
        heapifyDown();
        return minElement;
    }

    //Time Complexity: O(Logn)
    public int extractMin() {
        return poll();
    }

    //Time Complexity: O(Logn)
    private void heapifyDown() {
        int index = 0;
        int smallerChildIndex;
        while (hasLeftChild(index)) {
            smallerChildIndex = getLeftChildIndex(index);
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

    //Time Complexity: O(Logn)
    public void add(int value) {
        ensureExtraCapacity();
        this.elements[this.size] = value;
        this.size++;
        heapifyUp();
    }

    //Time Complexity: O(Logn)
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

        //Time Complexity for building heap: O(n)
        for (int i = 0; i < nk.length; i++) {
            minHeap.add(Integer.parseInt(nk[i]));
        }

        System.out.println("Root of min heap (smallest element): " + minHeap.peek());
        System.out.println("Min Heap elements: ");
        minHeap.printElements();


    }
}

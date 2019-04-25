package datastructures.linkedlists;

import java.util.Scanner;

public class LinkedList {

    private static final Scanner scanner = new Scanner(System.in);

    private Node head;

     static class Node { //defined static to reference in main()
        int data;
        Node next;
        Node(int value) {
            data = value;
            next = null;
        }
    }

    public Node peek() {
         return this.head;
    }

    //Inserts new node in the front of the list
    public void push(int value) {
         Node newNode = new Node(value);
         newNode.next = head;
         head = newNode;
    }

    //Deletes node at front of the list, move the head
    public void pop() {
         if (head == null) {
             throw new IllegalStateException("Empty LinkedList, pop can't be done");
         }
         head = head.next;
    }

    //Inserts new node to the last of the list
    public void append(int value) {
         Node newNode = new Node(value);
         newNode.next = null; //new node will be last node

        if (head == null) { // Head will be null if linkedlist is empty
            head = newNode;
            return; // set new node as head and return
        }

         Node last = head;
         while (last.next != null) {
             last = last.next;
         }

         last.next = newNode;
    }

    //Inserts new node after a given node
    public void insertAfter(Node previousNode, int value) {
        if (previousNode == null) {
            throw new IllegalStateException("previous node is null");
        }

        Node newNode = new Node(value);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
    }

    //Inserts new node before a given node
    public void insertBefore(Node nextNode, int value) {
        if (nextNode == null) {
            throw new IllegalStateException("next node is null");
        }

        Node currNode = head;
        while (currNode.next != null && currNode.next.data != nextNode.data) {
            currNode = currNode.next;
        }

        if (currNode.next == null) {
            throw new IllegalStateException("before element is not found");
        }

        Node newNode = new Node(value);
        newNode.next = nextNode;
        currNode.next = newNode;
    }

    //Removes node
    public void remove(int value) {
        if (head == null) {
            throw new IllegalStateException("Empty LinkedList");
        }

        // If head node itself holds the key to be deleted
        if (head.data == value) {
            head = head.next;
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        Node currNode = head;
        Node prevNode = null;
        while (currNode != null && currNode.data != value) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        // If key was not present in linked list
        if (currNode == null) { return; }

        prevNode.next = currNode.next;

    }

    //Removes node at given position
    public void removeAt(int position) {
        if (head == null) {
            throw new IllegalStateException("Empty LinkedList");
        }

        // If position is 0 delete head node itself
        if (position == 0) {
            head = head.next;
            return;
        }

        // Traverse to position of the node to be deleted, keep track of the
        // previous node as we need to change temp.next
        Node currNode = head;
        Node prevNode = null;
        int i = 0;
        while (currNode != null && i != position) {
            prevNode = currNode;
            currNode = currNode.next;
            i++;
        }

        // If postion is out of bounds
        if (currNode == null) { return; }

        prevNode.next = currNode.next;

    }

    public static void reverse(LinkedList linkedList) {
         Node currNode = linkedList.head;
         Node prevNode = null;
         Node nextNode;
         while (currNode != null) {
             nextNode = currNode.next;
             currNode.next = prevNode;
             prevNode = currNode;
             currNode = nextNode;
         }
         linkedList.head = prevNode;
    }

    public static void printElements(LinkedList linkedList) {
         Node currNode = linkedList.head;
         while (currNode != null) {
             System.out.print(currNode.data + " ");
             currNode = currNode.next;
         }
        System.out.println("");
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        LinkedList elementList = new LinkedList();

        for (int i = 0; i < nk.length; i++) {
            elementList.append(Integer.parseInt(nk[i]));
        }

        System.out.println("Enter element to be inserted: ");
        int elementToBeInserted = Integer.parseInt(scanner.nextLine());

        elementList.push(elementToBeInserted); //insert element at the head
        System.out.println("Elements after insertion at head: ");
        printElements(elementList);

        //reset list
        elementList.pop();

        elementList.append(elementToBeInserted); //insert element at the end
        System.out.println("Elements after insertion at the end: ");
        printElements(elementList);

        //reset list
        elementList.removeAt(nk.length); //remove element at given position

        elementList.insertAfter(elementList.head, elementToBeInserted); //insert element after specified node
        System.out.println("Elements after insertion after head: ");
        printElements(elementList);

        //reset list
        elementList.remove(elementToBeInserted);

        elementList.insertBefore(elementList.head.next.next, elementToBeInserted); //insert element before specified node
        System.out.println("Elements after insertion before 3rd element: ");
        printElements(elementList);

        reverse(elementList);
        System.out.println("Elements after reversal: ");
        printElements(elementList);

        System.out.println("Head of the elements linked list: " + elementList.peek().data);


    }

}

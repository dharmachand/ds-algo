package datastructures.linkedlists;

import java.util.Scanner;

public class CircularLinkedList<T> {

    private static final Scanner scanner = new Scanner(System.in);

    public Node head;

    class Node {
        T data;
        Node next;

        Node(T value) {
            data = value;
            next = this;
        }
    }


    public void push(T value) {
         Node newNode = new Node(value);
         if (this.head == null) {
             this.head = newNode;
         } else {
             Node last = this.head;
             while (last.next != this.head) {
                 last = last.next;
             }
             newNode.next = this.head;
             last.next = newNode;
         }
    }

    public static void printElements(CircularLinkedList linkedList) {
         CircularLinkedList.Node currNode = linkedList.head;
         while (currNode.next != linkedList.head) {
             System.out.print(currNode.data + " ");
             currNode = currNode.next;
         }
        System.out.println(currNode.data + " ");
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        CircularLinkedList<Integer> elementList = new CircularLinkedList<>();

        for (int i = 0; i < nk.length; i++) {
            elementList.push(Integer.parseInt(nk[i]));
        }

        System.out.println("Elements: ");
        printElements(elementList);


    }

}

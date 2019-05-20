package datastructures.linkedlists;

import java.util.Scanner;

public class DeleteNode {
    private static final Scanner scanner = new Scanner(System.in);

    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) { this.data = data; }
    }

    public static ListNode deleteAtPos(ListNode head, int position) {
        if (head == null) return head;

        int pos = 1;
        ListNode currNode = head, prevNode = null;
        if (position == 1) {
            head = currNode.next;
            return head;
        }

        // Please note that below logic won't work
//        while (currNode != null) {
//            prevNode = currNode;
//            if (position == pos) {
//                prevNode.next = currNode.next;
//                return head;
//            }
//            currNode = currNode.next;
//            pos++;
//        }

        while (currNode != null && pos != position) {
            prevNode = currNode;
            currNode = currNode.next;
            pos++;
        }
        if (currNode == null) return head;

        prevNode.next = currNode.next;
        return head;
    }

    public void append(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = null; //new node will be last node

        if (head == null) { // Head will be null if linkedlist is empty
            head = newNode;
            return; // set new node as head and return
        }

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public static void printElements(ListNode head) {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] inputElements = scanner.nextLine().split(" ");

        DeleteNode dn = new DeleteNode();

        ListNode head = new ListNode(Integer.parseInt(inputElements[0]));
        for (int i = 1; i < inputElements.length; i++) {
            dn.append(head, Integer.parseInt(inputElements[i]));
        }

        System.out.println("Enter position of the element to be deleted: ");
        int position = Integer.parseInt(scanner.nextLine());

        head = deleteAtPos(head, position);

        printElements(head);

    }
}

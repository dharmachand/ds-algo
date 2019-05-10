package datastructures.linkedlists;

import java.util.Scanner;

public class KthToLast {

    private static final Scanner scanner = new Scanner(System.in);

    public static LinkedList.Node findKthFromLast(LinkedList linkedList, int k) {
        LinkedList.Node fastNode = linkedList.head;
        LinkedList.Node slowNode = linkedList.head;
        int pos = 0;
        while (fastNode != null && pos < k) {
            fastNode = fastNode.next;
            pos++;
        }
        while (fastNode != null && slowNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] inputElements = scanner.nextLine().split(" ");

        System.out.println("Enter Kth position: ");
        int k = Integer.parseInt(scanner.nextLine());

        LinkedList elementList = new LinkedList();

        for (int i = 0; i < inputElements.length; i++) {
            elementList.append(Integer.parseInt(inputElements[i]));
        }

        LinkedList.Node kthNode = findKthFromLast(elementList, k);
        System.out.println("Kth element from last: " + kthNode != null ? kthNode.data : null);

    }

}

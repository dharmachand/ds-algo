package datastructures.linkedlists;

import java.util.Scanner;

public class DeleteMiddle {

    private static final Scanner scanner = new Scanner(System.in);

    public static void deleteMiddle(LinkedList linkedList) {
        LinkedList.Node fastNode = linkedList.head;
        LinkedList.Node slowNode = linkedList.head;
        LinkedList.Node prevSlowNode = slowNode;
        while (fastNode != null
                && fastNode.next != null
                && slowNode != null) {

            fastNode = fastNode.next;
            fastNode = fastNode.next;

            prevSlowNode = slowNode;
            slowNode = slowNode.next;
        }
        prevSlowNode.next = slowNode.next;
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] inputElements = scanner.nextLine().split(" ");

        LinkedList elementList = new LinkedList();

        for (int i = 0; i < inputElements.length; i++) {
            elementList.append(Integer.parseInt(inputElements[i]));
        }

        System.out.println("List after deleting middle element: ");
        deleteMiddle(elementList);
        LinkedList.printElements(elementList);

    }

}

package datastructures.linkedlists;

import java.util.HashSet;
import java.util.Scanner;

public class LoopDetection {

    private static final Scanner scanner = new Scanner(System.in);

    //using extra data structure
    public static CircularLinkedList.Node detectLoop(CircularLinkedList circularLinkedList) {
        CircularLinkedList.Node curr = circularLinkedList.head;
        HashSet<CircularLinkedList.Node> nodeSet = new HashSet<>();
        while (curr != null) {
            if (!nodeSet.contains(curr)) {
                nodeSet.add(curr);
            } else {
                break;
            }
            curr = curr.next;
        }
        return curr;
    }


    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] inputElements = scanner.nextLine().split(" ");

        CircularLinkedList elementList = new CircularLinkedList();

        for (int i = 0; i < inputElements.length; i++) {
            elementList.push(Integer.parseInt(inputElements[i]));
        }

        CircularLinkedList.Node curr = elementList.head;
        while (curr.next != elementList.head) {
            curr = curr.next;
        }
        curr.next = elementList.head.next; //created loop at 2nd element

        System.out.println("Loop is at element: " + detectLoop(elementList).data);

    }

}

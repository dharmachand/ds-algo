package datastructures.linkedlists;

import java.util.Scanner;

public class RearrangeList {

    private static final Scanner scanner = new Scanner(System.in);

    //rearrange elements as below
    //Input: a1 - >a2 - > ••• - >an - >b1 - >b2 - > ••• - >bn
    //Output: a1 - >b1 - >a2 - >b2 - > •.• - >an - >bn
    //input list has even number of nodes
    public static void rearrange(LinkedList linkedList) {
        LinkedList.Node fastNode = linkedList.head;
        LinkedList.Node slowNode = linkedList.head;

        while (fastNode != null
                && fastNode.next != null
                && slowNode != null) {
            //move fastNode 2 nodes at a time so that when fast nodes reaches end
            //slowNode will be in the middle
            fastNode = fastNode.next;
            fastNode = fastNode.next;

            slowNode = slowNode.next;
        }
        fastNode = linkedList.head; //reset fastNode to head

        LinkedList.Node prevFastNode, prevSlowNode;
        while (fastNode != null & slowNode != null) {
            prevFastNode = fastNode;
            prevSlowNode = slowNode;

            fastNode = fastNode.next;
            slowNode = slowNode.next;

            prevFastNode.next = prevSlowNode;
            if (slowNode == null) break;
            prevSlowNode.next = fastNode;
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        LinkedList elementList = new LinkedList();

        for (int i = 0; i < nk.length; i++) {
            elementList.append(Integer.parseInt(nk[i]));
        }

        rearrange(elementList);
        System.out.println("Elements after rearrangement: ");
        LinkedList.printElements(elementList);

    }

}

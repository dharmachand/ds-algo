package datastructures.linkedlists;

import java.util.Scanner;

public class Palindrome {

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean isPalindrome(LinkedList linkedList) {
        LinkedList.Node fwNode = linkedList.head;

        linkedList.reverse();
        LinkedList.Node bwNode = linkedList.head;

        while (fwNode != null && bwNode != null) {
            if (fwNode.data != bwNode.data) return false;

            fwNode = fwNode.next;
            bwNode = bwNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        //1 2 3 2 1
        //1 2 1 3 4
        System.out.println("Enter element list: ");
        String[] nk = scanner.nextLine().split(" ");

        LinkedList<Integer> elementList = new LinkedList<>();

        for (int i = 0; i < nk.length; i++) {
            elementList.append(Integer.parseInt(nk[i]));
        }

        System.out.println("Element list is a palindrome: " + isPalindrome(elementList));

    }

}

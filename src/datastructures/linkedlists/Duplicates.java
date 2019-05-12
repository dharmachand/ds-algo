package datastructures.linkedlists;

import java.util.HashSet;
import java.util.Scanner;

public class Duplicates {

    private static final Scanner scanner = new Scanner(System.in);

    //Using extra data stucture
    //Time Complexity: O(n pow 2) & Space Complexity: O(n)
    public static void removeDuplicates(LinkedList<Integer> linkedList) {
        LinkedList.Node curr = linkedList.head;
        LinkedList.Node prev = null;
        HashSet<Integer> elementSet = new HashSet<>();
        while (curr != null) {
            if (!elementSet.contains(curr.data)) {
                elementSet.add((Integer)curr.data);
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
    }

    //Without using extra data stucture
    //Time Complexity: O(n pow 2) & Space Complexity: O(1)
    public static void removeDuplicatesWithOutExtraDs(LinkedList<Integer> linkedList) {
        LinkedList.Node main = linkedList.head;
        LinkedList.Node ref, prevMain = main;;
        while (main != null) {
            ref = linkedList.head;
            while (ref != null && ref != main
                    && ref.data != main.data) {
                ref = ref.next;
            }
            if (ref != null && ref != main
                    && ref.data == main.data) {
                prevMain.next = main.next;
                main = main.next;
            } else {
                prevMain = main;
                main = main.next;
            }
        }

    }

    public static void main(String[] args) {
        //1 2 1 3 4 5 3
        //1 2 1 3 4 5 3 6
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        LinkedList<Integer> elementList = new LinkedList<>();

        for (int i = 0; i < nk.length; i++) {
            elementList.append(Integer.parseInt(nk[i]));
        }

        removeDuplicates(elementList);
        System.out.println("Elements after removing duplicates (extra data structure): ");
        LinkedList.printElements(elementList);

        //reset list
        elementList = new LinkedList<>();
        for (int i = 0; i < nk.length; i++) {
            elementList.append(Integer.parseInt(nk[i]));
        }

        removeDuplicatesWithOutExtraDs(elementList);
        System.out.println("Elements after removing duplicates (without extra data structure): ");
        LinkedList.printElements(elementList);

    }

}

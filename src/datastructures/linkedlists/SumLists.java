package datastructures.linkedlists;

import java.util.Scanner;

public class SumLists {

    private static final Scanner scanner = new Scanner(System.in);

    //TODO - Implement Logic
    public static LinkedList<Integer> sumLists(LinkedList<Integer> num1List, LinkedList<Integer> num2List) {
        LinkedList<Integer> sumList = new LinkedList();

        LinkedList.Node num1Node = num1List.head;
        LinkedList.Node num2Node = num2List.head;

        //sum both lists - remember to add carry forward if any
        int carryFw = 0, exp = 0, remainder, digit;
        while (num1Node != null && num2Node != null ) {
            digit = ((Integer)num1Node.data + (Integer)num2Node.data + carryFw) % 10;
            carryFw = ((Integer)num1Node.data + (Integer)num2Node.data + carryFw) / 10;

            sumList.append(digit);
            exp += 1;

            num1Node = num1Node.next;
            num2Node = num2Node.next;
        }
        while (num1Node != null) {
            digit = ((Integer)num1Node.data + carryFw) % 10;
            carryFw = ((Integer)num1Node.data + carryFw) / 10;

            sumList.append(digit);
            exp += 1;

            num1Node = num1Node.next;
        }
        while (num2Node != null) {
            digit = ((Integer)num2Node.data + carryFw) % 10;
            carryFw = ((Integer)num2Node.data + carryFw) / 10;

            sumList.append(digit);
            exp += 1;

            num2Node = num2Node.next;
        }
        if (carryFw > 0) sumList.append(carryFw);

        return sumList;
    }

    public static void main(String[] args) {

        System.out.println("Enter number1: ");
        String[] num1 = scanner.nextLine().split(" ");

        LinkedList<Integer> num1List = new LinkedList<>();

        for (int i = 0; i < num1.length; i++) {
            num1List.append(Integer.parseInt(num1[i]));
        }

        System.out.println("Enter number2: ");
        String[] num2 = scanner.nextLine().split(" ");

        LinkedList<Integer> num2List = new LinkedList<>();

        for (int i = 0; i < num2.length; i++) {
            num2List.append(Integer.parseInt(num2[i]));
        }

        LinkedList<Integer> sumList = sumLists(num1List, num2List);
        System.out.println("Sum of numbers: ");
        LinkedList.printElements(sumList);
    }

}

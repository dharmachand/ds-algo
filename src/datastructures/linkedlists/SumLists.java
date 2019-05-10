package datastructures.linkedlists;

import java.util.Scanner;

public class SumLists {

    private static final Scanner scanner = new Scanner(System.in);

    //TODO - Implement Logic
    public static LinkedList sumLists(LinkedList num1List, LinkedList num2List) {
        LinkedList sumList = new LinkedList();

        LinkedList.Node num1Node = num1List.head;
        LinkedList.Node num2Node = num2List.head;

        //sum both lists - remember to add carry forward if any
        int carryFw = 0, exp = 0, remainder, digit;
        while (num1Node != null && num2Node != null ) {
            digit = (num1Node.data + num2Node.data + carryFw) % 10;
            carryFw = (num1Node.data + num2Node.data + carryFw) / 10;

            sumList.append(digit);
            exp += 1;

            num1Node = num1Node.next;
            num2Node = num2Node.next;
        }
        while (num1Node != null) {
            digit = (num1Node.data + carryFw) % 10;
            carryFw = (num1Node.data + carryFw) / 10;

            sumList.append(digit);
            exp += 1;

            num1Node = num1Node.next;
        }
        while (num2Node != null) {
            digit = (num2Node.data + carryFw) % 10;
            carryFw = (num2Node.data + carryFw) / 10;

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

        LinkedList num1List = new LinkedList();

        for (int i = 0; i < num1.length; i++) {
            num1List.append(Integer.parseInt(num1[i]));
        }

        System.out.println("Enter number2: ");
        String[] num2 = scanner.nextLine().split(" ");

        LinkedList num2List = new LinkedList();

        for (int i = 0; i < num2.length; i++) {
            num2List.append(Integer.parseInt(num2[i]));
        }

        LinkedList sumList = sumLists(num1List, num2List);
        System.out.println("Sum of numbers: ");
        LinkedList.printElements(sumList);
    }

}

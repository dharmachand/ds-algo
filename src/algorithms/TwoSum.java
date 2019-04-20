package algorithms;

import java.util.*;

public class TwoSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsHash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsHash.put(nums[i], i);
        }
        int complement;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (numsHash.containsKey(complement) && numsHash.get(complement) != i) {
                return new int[] {i, numsHash.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void printElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    public static void main(String[] args) {

        System.out.println("Target: ");
        int target = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter elements: ");
        String[] input = scanner.nextLine().split(" ");

        int[] elements = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            elements[i] = Integer.parseInt(input[i]);
        }

        int[] indeces = twoSum(elements, target);

        System.out.println("Indeces of compliment numbers: ");
        printElements(indeces);

        scanner.close();
    }

}

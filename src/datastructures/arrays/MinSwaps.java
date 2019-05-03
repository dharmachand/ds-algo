package datastructures.arrays;

import java.util.Scanner;

public class MinSwaps {

    private static final Scanner scanner = new Scanner(System.in);

    //min swaps needed to bring elements less than k together
    private static int minSwapsToBringElementsLessthanK(int[] elements, int k) {
        int n = elements.length;
        // Find count of elements which are less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (elements[i] <= k)
                ++count;

        // Find unwanted elements in current window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (elements[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement count of previous window
            if (elements[i] > k)
                --bad;

            // Increment count of current window
            if (elements[j] > k)
                ++bad;

            // Update ans if count of 'bad' is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }



    public static void main(String[] args) {

        //-1 2 -3 4 5 6 -7 8 9
        System.out.println("Enter elements: ");
        String[] nk = scanner.nextLine().split(" ");

        System.out.println("enter a number: ");
        int k = Integer.parseInt(scanner.nextLine());

        int[] elements = new int[nk.length];

        for (int i = 0; i < nk.length; i++) {
            elements[i] = Integer.parseInt(nk[i]);
        }

        System.out.println("Min swaps required to bring elements < number together: " + minSwapsToBringElementsLessthanK(elements, k));

    }


}

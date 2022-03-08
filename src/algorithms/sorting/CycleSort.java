package algorithms.sorting;

import java.util.Arrays;

public class CycleSort {

    public static void main(String[] args) {
        int[] input = { 1, 8, 3, 9, 10, 10, 2, 4 };
        System.out.println(Arrays.toString(cycleSort(input)));
    }

    // Unstable sorting algorithm, in-pace sorting algorithm and optimal no. of writes
    private static int[] cycleSort(int[] input) {
        int n = input.length;
        // count number of memory writes
        int writes = 0;

        // traverse array elements and put it to on the right place
        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            // initialize item as starting point
            int item = input[cycle_start];

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++)
                if (input[i] < item)
                    pos++;

            // If item is already in correct position
            if (pos == cycle_start)
                continue;

            // ignore all duplicate elements
            while (item == input[pos])
                pos += 1;

            // put the item to it's right position
            if (pos != cycle_start) {
                int temp = item;
                item = input[pos];
                input[pos] = temp;
                writes++;
            }

            // Rotate rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // Find position where we put the element
                for (int i = cycle_start + 1; i < n; i++)
                    if (input[i] < item)
                        pos += 1;

                // ignore all duplicate elements
                while (item == input[pos])
                    pos += 1;

                // put the item to it's right position
                if (item != input[pos]) {
                    int temp = item;
                    item = input[pos];
                    input[pos] = temp;
                    writes++;
                }
            }
        }
        System.out.println("Writes: " + writes);
        return input;
    }

}

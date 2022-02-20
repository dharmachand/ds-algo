package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowersOfHanoi {
    /**
     * Tower of Hanoi is a mathematical puzzle where we have three pegs and n disks. The objective of the puzzle is to move the entire stack to another peg, obeying the following simple rules:
     * Only one disk can be moved at a time.
     * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
     * No disk may be placed on top of a smaller disk.
     * Here, we are given n denoting the number of disks in the first peg, we need to return all the steps taken to move all disks from the first peg to the third peg.
     * There can be multiple possibilities to complete the given objective. Every valid possibility to achieve objective will be a valid answer.
     *
     * Example
     * Input: n = 4
     *
     * Output:
     *
     * [ [1, 2], [1, 3], [2, 3], [1, 2], [3, 1], [3, 2], [1, 2], [1, 3], [2, 3], [2, 1], [3, 1], [2, 3], [1, 2], [1, 3], [2, 3] ]
     */

    /*
     * Recursive Solution
     */
    public static List<List<Integer>> towerOfHanoi(int n) {
        // Write your code here
        List<List<Integer>> answer = new ArrayList<>();
        towerOfHanoiHelper(n, 1, 3, 2, answer);
        return answer;
    }

    public static void towerOfHanoiHelper(int n, int fromPeg,
            int toPeg, int auxPeg, List<List<Integer>> answer) {
        if (n == 1) {
            // As it is last disk we shift it from fromPeg to toPeg
            answer.add(new ArrayList<>(Arrays.asList(fromPeg, toPeg)));
            return;
        }
        // Shift top n - 1 disks fromPeg -> auxPeg using toPeg.
        towerOfHanoiHelper(n-1, fromPeg, auxPeg, toPeg, answer);

        // Store the step of moving of 1 top disk from fromPeg to toPeg
        answer.add(new ArrayList<>(Arrays.asList(fromPeg, toPeg)));

        // Shifting back remaining n-1 disks auxPeg -> toPeg using fromPeg
        towerOfHanoiHelper(n-1, auxPeg, toPeg, fromPeg, answer);
    }

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(4));
    }


}

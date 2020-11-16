package algorithms.backtracking;

public class DiceRollSum {
    //Given number of dices to roll and a desired sum. Print all combinations of dice values

    public static void printDiceRollSum(int diceSum, int targetSum) {
        printDiceRollSum(diceSum, 0, targetSum, new StringBuilder());
    }

    private static void printDiceRollSum(int diceSum, int runningSum, int targetSum, StringBuilder sb) {
        if (runningSum > targetSum) return;

        if (diceSum == 0) {
            if (runningSum == targetSum) System.out.println(sb.toString());
        } else {
            for (int i = 1; i <= 6; i++) {
                sb.append(i);
                printDiceRollSum(diceSum - 1, runningSum + i, targetSum, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        printDiceRollSum(3, 7);
    }
}

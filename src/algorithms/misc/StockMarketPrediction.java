package algorithms.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockMarketPrediction {

    private static List<Integer> getClosestSmaller(int[] nums, int[] queries) {
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            int index = q - 1;
            int left = index;
            int right = index;
            while (left >= 0) {
                if (nums[left] < nums[index]) {
                    break;
                }
                left--;
            }
            while (right < nums.length) {
                if (nums[right] < nums[index]) {
                    break;
                }
                right++;
            }
            if (left < 0 && right >= nums.length) {
                res.add(-1);
            } else if (left < 0) {
                res.add(right + 1);
            } else if (right >= nums.length) {
                res.add(left + 1);
            } else {
                res.add(Math.min(left, right) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 8, 4, 9, 10, 8, 3, 6, 4};
        int[] queries = {6, 5, 4};
        System.out.println(getClosestSmaller(nums, queries));
    }

    public List<Integer> findNextSmallest(List<Integer> stockPrices, int[] queries) {
        int[] nextSmallest = new int[stockPrices.size()];
        Arrays.fill(nextSmallest, -1);

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < stockPrices.size(); i++) {
            int currPrice = stockPrices.get(i);
            while (!stack.isEmpty() && currPrice < stockPrices.get(stack.peek())) {
                nextSmallest[stack.pop()] = i;
            }
            stack.add(i);
        }
        stack.clear();

        for (int i = stockPrices.size() - 1; i >= 0; i--) {
            int currPrice = stockPrices.get(i);
            while (!stack.isEmpty() && currPrice < stockPrices.get(stack.peek())) {
                int stackIndex = stack.pop();
                if (nextSmallest[stackIndex] == -1 || i < nextSmallest[stackIndex]) {
                    nextSmallest[stackIndex] = i;
                }
            }
            stack.add(i);
        }

        List<Integer> result = new ArrayList();
        for (int query : queries) {
            int day = nextSmallest[query - 1] == -1 ? -1 : nextSmallest[query - 1] + 1;
            result.add(day);
        }
        return result;
    }
}
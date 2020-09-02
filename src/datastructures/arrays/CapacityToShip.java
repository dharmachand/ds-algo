package datastructures.arrays;

public class CapacityToShip {
    /**
     * A conveyor belt has packages that must be shipped from one port to another within D days.
     *
     * The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
     *
     * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
     */

    public static int shipWithinDays(int[] weights, int D) {
        //user binary search to find optimal weight
        int mid, low = 1, high = 25000000; // 50000 x 500
        boolean can;
        while (low <= high) {
            mid = (low + high) / 2;
            can = canShip(weights, D, mid);
            if (can) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canShip(int[] weights, int D, int capacity) {
        int w = 0, day = 1;
        for (int weight : weights) {
            if (weight > capacity || day > D) return false;
            if (weight + w > capacity) {
                w = 0;
                day++;
            }
            w += weight;
        }
        return day <= D;
    }

    public static int shipWithinDaysBetter(int[] weights, int D) {
        //user binary search to find optimal weight
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        int mid, w, day;
        while (left < right) {
            w = 0;
            day = 1;
            mid = (left + right) / 2;
            for (int weight : weights) {
                if (weight + w > mid) {
                    w = 0;
                    day++;
                }
                w += weight;
            }
            if (day > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        //Expected Output: 15

//        int[] weights = {3,2,2,4,1,4};
//        int D = 6;
        //Expected Output: 15

//        int[] weights = {1,2,3,1,1};
//        int D = 4;
        //Expected Output: 3

        System.out.println(shipWithinDays(weights, D));
        System.out.println(shipWithinDaysBetter(weights, D));


    }
}

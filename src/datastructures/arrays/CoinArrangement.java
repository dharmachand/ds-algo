package datastructures.arrays;

public class CoinArrangement {
    public static int arrangeCoins(int n) {
        if (n == 0) return 0;
        else if (n <= 2) return 1;
        int i;
        long sum = 0;
        for (i = 1; i <= n; i++) {
            sum += i;
            if (sum > n) break;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(2147483647));
    }
}

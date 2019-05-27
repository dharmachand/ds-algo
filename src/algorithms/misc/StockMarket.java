package algorithms.misc;

import java.util.Scanner;

public class StockMarket {
    public static Scanner scanner = new Scanner(System.in);

    public static int maxProfitBetter(int[] a) {

        int profit = 0;

        for(int i = 1; i < a.length; i++){
            int gain = a[i] - a[i - 1];
            profit += (gain > 0) ? gain : 0;
        }

        return profit;
    }

    public static int maxProfit(int[] a) {
        int len = a.length;
        int idx = 0, buyIdx = 0, sellIdx = 0;
        int soldPrice, boughtPrice = -1, profit = 0;
        while (idx < len) {
            if (boughtPrice == -1) { //buy stock
                buyIdx = idxToBuy(a, idx); //find the idx to buy
                boughtPrice = buyStock(a, buyIdx);
                if (buyIdx > idx) idx = buyIdx;
            } else { //sell stock
                sellIdx = idxToSell(a, idx, buyIdx); //find the idx to sell
                if (sellIdx > 0) {
                    soldPrice = sellStock(a, sellIdx);
                    profit = updateProfit(profit, soldPrice, boughtPrice);
                    boughtPrice = -1; //reset boughtPrice when you sell stock
                }
                if (sellIdx > idx) idx = sellIdx;
            }
            idx++;
        }
        return profit;
    }

    public static int idxToBuy(int[] a, int idx) {
        int buyIdx = 0, priceToChange;
        int len = a.length;
        for (int i = idx; i < len - 1; i++) {
            priceToChange = a[i + 1] - a[i];
            if (priceToChange > 0) buyIdx = i;
            else break;
        }
        return buyIdx;
    }

    public static int idxToSell(int[] a, int idx, int buyIdx) {
        int sellIdx = 0, priceToChange = -1, priceChanged = -1;
        int i, len = a.length;
        for (i = idx; i < len - 1; i++) {
            priceToChange = a[i + 1] - a[i];
            priceChanged = a[i] - a[buyIdx];
            if (priceToChange <= priceChanged && a[i] > a[buyIdx]) sellIdx = i;
            else break;
        }
        if (i == len - 1) {
            priceToChange = a[i];
            priceChanged = a[i] - a[buyIdx];
            if (priceToChange <= priceChanged && a[i] > a[buyIdx]) sellIdx = i;
        }
        return sellIdx;
    }

    public static int buyStock(int[] a, int buyIdx) {
        return a[buyIdx];
    }

    public static int sellStock(int[] a, int sellIdx) {
        return a[sellIdx];
    }

    public static int updateProfit(int profit, int soldPrice, int boughtPrice) {
        profit += (soldPrice - boughtPrice);
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("Enter stock prices: ");
        String[] nk = scanner.nextLine().split(" ");

        int[] stocks = new int[nk.length];
        for (int i = 0; i < nk.length; i++) {
            stocks[i] = Integer.parseInt(nk[i]);
        }

        int profit = maxProfit(stocks);
        System.out.println("Max profit from selling stocks: " + profit);

        profit = maxProfitBetter(stocks);
        System.out.println("Max profit from selling stocks (better solution): " + profit);
    }
}

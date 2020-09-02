package datastructures.arrays.dp;

public class TicketMinCost {
    public static int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return minCostTickets(days, costs, 0, dp);
    }

    private static int minCostTickets(int[] days, int[] costs, int currDay, int[] dp) {
        if (currDay >= days.length) return 0;

        int dayPass, weekPass, monthPass;
        if (dp[currDay] > 0) return dp[currDay];
        dayPass = minCostTickets(days, costs, currDay + 1, dp) + costs[0];

        weekPass = minCostTickets(days, costs,
                getPassExpiryDay(days, currDay, 7), dp) + costs[1];

        monthPass = minCostTickets(days, costs,
                getPassExpiryDay(days, currDay, 30), dp) + costs[2];

        return dp[currDay] = Math.min(dayPass, Math.min(weekPass, monthPass));
    }

    private static int getPassExpiryDay(int[] days, int currDay, int passType) {
        int i;
        for (i = currDay; i < days.length; i++) {
            if (days[i] >= days[currDay] + passType) break;
        }

        return i;
    }

    public static void main(String[] args) {
//        int[] days = {1,4,6,7,8,20};
//        int[] costs = {2,7,15};
        //Expected Output: 11

        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        //Expected Output: 17

        System.out.println(minCostTickets(days, costs));
    }
}

package coderpad;

/*
0-1 Knapsack Problem :
You are given n items, where each item has:
a weight wt[i]
a value val[i]
You are also given a maximum capacity W of a knapsack.
Your task is to maximize the total value of items you can put into the knapsack without exceeding the total weight W.
You cannot break an item (i.e., either include it or don’t — hence 0-1).*/

public class KnapsackDP {
    public static int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            // Traverse backwards to avoid using the same item more than once
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;

        System.out.println("Max value: " + knapsack(wt, val, W)); // Output: 220
    }
}


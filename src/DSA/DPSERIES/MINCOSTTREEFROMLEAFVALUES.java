package DSA.DPSERIES;
import java.util.*;
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[n][n];
        return calculateCost(arr, 0, n - 1, memo);
    }
    private int calculateCost(int[] arr, int start, int end, int[][] memo) {
        if (start >= end) {
            return 0;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int maxLeft = getMaxValue(arr, start, i);
            int maxRight = getMaxValue(arr, i + 1, end);

            int cost = maxLeft * maxRight + calculateCost(arr, start, i, memo) + calculateCost(arr, i + 1, end, memo);
            minCost = Math.min(minCost, cost);
        }

        memo[start][end] = minCost;
        return minCost;
    }

    private int getMaxValue(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}

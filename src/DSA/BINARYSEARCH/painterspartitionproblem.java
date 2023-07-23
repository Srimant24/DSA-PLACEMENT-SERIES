package DSA.BINARYSEARCH;

import java.util.ArrayList;
import java.util.Collections;

public class painterspartitionproblem {
    public static boolean isPossible(ArrayList<Integer> arr, int n, int m, int mid) {
        int painters = 1;
        int wallsum = 0;

        for (int i = 0; i < n; i++) {
            if (wallsum + arr.get(i) <= mid) {
                wallsum += arr.get(i);
            } else {
                painters++;
                if (painters > m || arr.get(i) > mid) {
                    return false;
                }
                wallsum = arr.get(i);
            }
            if (painters > m) {
                return false;
            }
        }
        return true;
    }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        int s = Collections.min(arr);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }
        int e = sum;
        int ans = -1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
}

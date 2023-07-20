package DSA.QUEE;
import java.util.ArrayDeque;
import java.util.Deque;
public class SUMOFMAXIMUMANDMINIMUMELEMENTOFARRAYSIZEK {
    public static int solve(int[] arr, int n, int k) {
        Deque<Integer> maxi = new ArrayDeque<>();
        Deque<Integer> mini = new ArrayDeque<>();

        // Addition of first k size window
        for (int i = 0; i < k; i++) {
            while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i])
                maxi.pollLast();

            while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i])
                mini.pollLast();

            maxi.offer(i);
            mini.offer(i);
        }
        int ans = 0;
        ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];

        // Process remaining windows
        for (int i = k; i < n; i++) {
            // Removal
            while (!maxi.isEmpty() && i - maxi.peekFirst() >= k) {
                maxi.pollFirst();
            }

            while (!mini.isEmpty() && i - mini.peekFirst() >= k) {
                mini.pollFirst();
            }

            // Addition
            while (!maxi.isEmpty() && arr[maxi.peekLast()] <= arr[i])
                maxi.pollLast();

            while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i])
                mini.pollLast();

            maxi.offer(i);
            mini.offer(i);

            ans += arr[maxi.peekFirst()] + arr[mini.peekFirst()];
        }
        return ans;
    }
}
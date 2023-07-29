package DSA.STRING;

public class STRING {
    public static int solution(String S) { //O(N)
        int n = S.length();
        if(n < 2) {
            return 0;
        }
        int left[] = new int[n-1];
        int right[] = new int[n-1];
        left[0] = S.charAt(0) != '>' ? 1 : 0;
        for(int i=1; i<n-1; i++) {
            if(S.charAt(i) != '>') {
                left[i] = left[i-1]+1;
            } else {
                left[i] = 0;
            }
        }
        right[n-2] = S.charAt(n-1) != '<' ? 1 : 0;
        for(int i=n-3; i>=0; i--) {
            if(S.charAt(i+1) != '<') {
                right[i] = right[i+1]+1;
            } else {
                right[i] = 0;
            }
        }
        int ans = 0;
        for(int i=0; i<S.length()-1; i++) {
            int len = 2*Math.min(left[i], right[i]);
            if(len > ans) {
                ans = len;
            }
        }
        return ans;
    }
}

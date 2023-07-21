package DSA.ARRAY;
import java.util.List;
public class CHECKSORTEDROTATEARRAY {
    public boolean check(List<Integer> nums) {
        int cnt = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1))
                cnt++;
        }
        if (nums.get(nums.size() - 1) > nums.get(0))
            cnt++;

        return cnt <= 1;
    }
}

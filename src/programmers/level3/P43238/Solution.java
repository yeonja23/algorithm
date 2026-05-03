package programmers.level3.P43238;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long lo = 1;
        long hi = (long) times[times.length - 1] * n;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;
            for (int t : times) {
                cnt += mid / t;
                if (cnt >= n) break;
            }

            if (cnt >= n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}

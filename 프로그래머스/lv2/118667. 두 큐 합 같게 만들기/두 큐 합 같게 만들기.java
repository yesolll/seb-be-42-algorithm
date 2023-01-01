import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 
            = new LinkedList<>(Arrays.stream(queue1).mapToLong(i -> i).boxed().collect(Collectors.toList()));
        Queue<Long> q2 
            = new LinkedList<>(Arrays.stream(queue2).mapToLong(i -> i).boxed().collect(Collectors.toList()));

        long sum1 = q1.stream().mapToLong(i->i).sum();
        long sum2 = q2.stream().mapToLong(i->i).sum();

        int maxCnt = (q1.size() + q2.size()) * 2; //
        int cnt = 0;

        while (sum1 != sum2) {
            cnt++;
            if (cnt > maxCnt) return -1;
            
            long pollValue;
            if (sum1 > sum2) {
                pollValue = q1.poll();
                sum1 -= pollValue;
                q2.add(pollValue);
                sum2 += pollValue;
            } else {
                pollValue = q2.poll();
                sum2 -= pollValue;
                q1.add(pollValue);
                sum1 += pollValue;
            }
        }
        return cnt;
    }
}
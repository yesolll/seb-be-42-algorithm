import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int head = 0;
        int tail = people.length -1;
        Arrays.sort(people);
        for (int i = tail; i >= 0; i--) {
            if (tail < head) break;
            if (people[tail] + people[head] <= limit) {
                head++;
            }
            tail--;
            answer++;
        }
        return answer;
    }
}

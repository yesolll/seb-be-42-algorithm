import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        answer = Arrays.stream(numlist).filter(i-> i%n == 0).toArray();
        return answer;
    }
}
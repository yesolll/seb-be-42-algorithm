import java.util.*;

class Solution {
    public static int solution(int[] elements) {
        int length = elements.length;
        Set<Integer> answer = new HashSet<>();
        
        for (int cnt = 1; cnt <= elements.length; cnt++) {
            for (int i = 0; i < length; i++) {
                int sum = 0;
                int until = i + cnt - 1; 
                for (int j = i; j <= until; j++) {
                    int idx = j;
                    if (j >= length) {
                        idx -= length;
                    }
                    sum += elements[idx];
                }
                answer.add(sum);
            }        
        }
        return answer.size();
    }
}
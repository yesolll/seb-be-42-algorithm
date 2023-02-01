import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Entry<Integer, Integer>> sorted =  map.entrySet().stream()
            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
            .collect(Collectors.toList());
        
        int cnt = 0;
        for (Entry<Integer, Integer> entry : sorted) {
            cnt += entry.getValue();
            answer++;
            if (cnt >= k) {
                return answer;
            }
        }
        return answer;
    }
}
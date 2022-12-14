import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.size() == 1) return array[0];

        List<Entry<Integer, Integer>> sorted =  map.entrySet().stream()
                                                    .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                    .collect(Collectors.toList());
        answer = sorted.get(0).getValue() == sorted.get(1).getValue() ? -1 : sorted.get(0).getKey();
        return answer;
    }
}
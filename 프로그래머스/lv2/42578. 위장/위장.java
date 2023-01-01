import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesCnt = new HashMap<>();
        
        for (String[] el : clothes) {
            clothesCnt.put(el[1], clothesCnt.getOrDefault(el[1], 1) + 1);
        }
        
        for (Entry<String, Integer> entry : clothesCnt.entrySet()) {
            answer *= entry.getValue();
        }
        return answer - 1;
    }
}
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            int start = i;
            Map<String, Integer> wants = makeMap(want, number);
            
            for (int j = i; j < start + 10; j++) {
                if (!wants.containsKey(discount[j])) continue;
                wants.put(discount[j], wants.get(discount[j]) - 1);
                
                if (wants.values().stream()
                                    .filter(num -> num <= 0)
                                    .count() == want.length) {
                    answer++;
                    break;
                }
            }
            
        }
        return answer;
    }
    
    private Map<String, Integer> makeMap(String[] want, int[] number) {
        Map<String, Integer> wants = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        return wants;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("[^0-9,]", "");
        String[] arr = s.split(",");
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        
        int[] answer = new int[entryList.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer[idx] = Integer.parseInt(entry.getKey());
            idx++;
        }
        
        return answer;
    }
}
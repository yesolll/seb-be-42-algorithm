import java.util.*;

class Solution {
    public int[] solution(String s) {   // "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        s = s.replaceAll("[^0-9,]", "");// 2,2,1,2,1,3,2,1,3,4
        String[] arr = s.split(",");    // [2,2,1,2,1,3,2,1,3,4]
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        } 
        // 1=3, 2=4, 3=2, 4=1
        
        // value 내림차순
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));
        // 2=4, 1=3, 3=2, 4=1
        
        int[] answer = new int[entryList.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer[idx] = Integer.parseInt(entry.getKey());
            idx++;
        }
        // [2,1,3,4]
        
        return answer;
    }
}
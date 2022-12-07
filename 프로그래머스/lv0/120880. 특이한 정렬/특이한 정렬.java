import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> numMap = new TreeMap<>();
        
        for (int i = 0; i < numlist.length; i++) {
            List<Integer> values = new ArrayList<>();
            int diff = Math.abs(numlist[i] - n);
            if (numMap.get(diff) != null) {
                values = numMap.get(diff);
            }
            values.add(numlist[i]);
            numMap.put(diff, values);
        }

        Iterator<Entry<Integer, List<Integer>>> iterator = numMap.entrySet().iterator();
        while (iterator.hasNext()) {
            List<Integer> value = iterator.next().getValue();
            Collections.sort(value);
            if (value.size() == 1) {
                answer.add(value.get(0));
            }
            else if (value.size() == 2) {
                answer.add(value.get(1));
                answer.add(value.get(0));
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
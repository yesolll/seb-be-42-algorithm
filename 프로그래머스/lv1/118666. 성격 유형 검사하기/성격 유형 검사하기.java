import java.util.*;
import java.util.Map.Entry;

class Solution {
    private Map<Integer, HashMap<String,Integer>> results = new HashMap<>();
    private Map<String, Integer> metrics = new HashMap<>();

    private void init_results() {
        HashMap<String,Integer> valueMap1 = new HashMap<>();
        valueMap1.put("R", 0);
        valueMap1.put("T", 0);
        results.put(1, valueMap1);
        HashMap<String,Integer> valueMap2 = new HashMap<>();
        valueMap2.put("C", 0);
        valueMap2.put("F", 0);
        results.put(2, valueMap2);
        HashMap<String,Integer> valueMap3 = new HashMap<>();
        valueMap3.put("J", 0);
        valueMap3.put("M", 0);
        results.put(3, valueMap3);
        HashMap<String,Integer> valueMap4 = new HashMap<>();
        valueMap4.put("A", 0);
        valueMap4.put("N", 0);
        results.put(4, valueMap4);
        /*
         * {1={R=0, T=0}, 
         *  2={C=0, F=0}, 
         *  3={J=0, M=0}, 
         *  4={A=0, N=0}}
         */
    }

    public void init_metrics() {
        metrics.put("R", 1);
        metrics.put("T", 1);
        metrics.put("C", 2);
        metrics.put("F", 2);
        metrics.put("J", 3);
        metrics.put("M", 3);
        metrics.put("A", 4);
        metrics.put("N", 4);
        /*
         * {R=1, T=1, C=2, F=2, J=3, M=3, A=4, N=4}
         */
    }

    public String solution(String[] survey, int[] choices) {
        init_results();
        init_metrics();
        StringBuilder answer = new StringBuilder();
        String key = "";
        int[] scores = {0,3,2,1,0,1,2,3};
        
        for (int i = 0; i < survey.length; i ++) {
            if (choices[i] <= 3) key = String.valueOf(survey[i].charAt(0));
            else if (choices[i] == 4) continue;
            else if (choices[i] >= 5) key = String.valueOf(survey[i].charAt(1));
            int metric = metrics.get(key);
            HashMap<String,Integer> valueMap = results.get(metric);
            valueMap.put(key, valueMap.get(key) + scores[choices[i]]);
        }
        
        for(Entry<Integer, HashMap<String, Integer>> result : results.entrySet()) {
            List<Map.Entry<String, Integer>> list = new ArrayList<>(result.getValue().entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    int comparision = (o1.getValue() - o2.getValue());
                    return comparision == 0 ? o2.getKey().compareTo(o1.getKey()) : comparision;
                }
            });
            answer.append(list.get(1).getKey());
        }
        return answer.toString();
    }
}
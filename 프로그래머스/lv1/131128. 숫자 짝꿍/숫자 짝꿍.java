import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Comparator<String> comparator = Comparator.reverseOrder();
        Map<String, Integer> xMap = new TreeMap<>(comparator);
        Map<String, Integer> yMap = new TreeMap<>(comparator);
        for(int i = 0; i < X.length(); i++) {
            String cur = String.valueOf(X.charAt(i));
            xMap.put(cur, xMap.getOrDefault(cur, 0) + 1); 
        }
        for(int i = 0; i < Y.length(); i++) {
            String cur = String.valueOf(Y.charAt(i));
            yMap.put(cur, yMap.getOrDefault(cur, 0) + 1); 
        }

        for (Iterator<String> iterator = xMap.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            if (yMap.get(key) == null) iterator.remove();
        }
        for (Iterator<String> iterator = yMap.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            if (xMap.get(key) == null) iterator.remove();
        }

        if (xMap.size() == 0 && yMap.size() == 0) return "-1";
        
        String answer = "";
        for (Iterator<String> iterator = xMap.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            int repeatMin = Math.min(xMap.get(key), yMap.get(key));
            answer += key.repeat(repeatMin);
        }
        if (answer.replace("0", "").length() == 0) return "0";
        return answer;
    }
}
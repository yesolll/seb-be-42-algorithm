import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        Map<String, Integer> scores = new HashMap<>();
        
        for (int i = 0; i < name.length; i++)
            scores.put(name[i], yearning[i]);
        
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for(String person : photo[i]) {
                score += scores.get(person) != null ? 
                         scores.get(person) : 0;
            }
            result[i] = score;
        }
        
        return result;
        
    }
}
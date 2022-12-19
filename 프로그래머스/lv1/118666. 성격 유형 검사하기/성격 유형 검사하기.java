import java.util.*;

class Solution {
    private Map<String, int[]> metrics = new HashMap<>();
    // 타입 = {지표 번호, 계산해주기 위한 값}
    public void init_metrics() {
        metrics.put("R", new int[] {0, 1});
        metrics.put("T", new int[] {0, -1});
        metrics.put("C", new int[] {1, 1});
        metrics.put("F", new int[] {1, -1});
        metrics.put("J", new int[] {2, 1});
        metrics.put("M", new int[] {2, -1});
        metrics.put("A", new int[] {3, 1});
        metrics.put("N", new int[] {3, -1});
    }
    
    public String solution(String[] survey, int[] choices) {
        init_metrics();

        StringBuilder sb = new StringBuilder();
        String[] personalityTypes = {"RT", "CF", "JM", "AN"}; // 성격 유형 항목
        int[] typeScores = new int[4];      // 항목 별 점수 계산 [-3, 1, -2, 0]
        String type = "";                   // 점수 계산할 성격 유형
        int[] scores = {0,3,2,1,0,1,2,3};   // choice별 점수
        
        for (int i = 0; i < survey.length; i ++) {
            if (choices[i] <= 3) type = String.valueOf(survey[i].charAt(0));
            else if (choices[i] == 4) continue; // 0점이면 패스
            else if (choices[i] >= 5) type = String.valueOf(survey[i].charAt(1));
            int[] metric = metrics.get(type);
            typeScores[metric[0]] += scores[choices[i]] * metric[1];
        }
        
        for (int i = 0; i < personalityTypes.length; i++) {
            if (typeScores[i] >= 0) 
                sb.append(personalityTypes[i].charAt(0));
            else 
                sb.append(personalityTypes[i].charAt(1));
        }
        return sb.toString();
    }
}
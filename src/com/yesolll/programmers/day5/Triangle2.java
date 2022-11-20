package com.yesolll.programmers.day5;
public class Triangle2 {
    
    public static int solution(int[] sides) {
        int answer = 0;
        // int max = Collections.max(Arrays.stream(sides).boxed().collect(Collectors.toList()));
        // int min = Collections.min(Arrays.stream(sides).boxed().collect(Collectors.toList()));
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);


        // 가장 긴 변이 max인 경우
        for (int i = (max + 1) - min; i <= max; i++) {
            answer++;
        }

        // 가장 긴 변이 나머지 한 변인 경우
        for (int i = max + 1; i < max + min; i++) {
            answer++;
        }

        return answer;
    }
    
    public static void main(String[] args) {
        
    }
    
}

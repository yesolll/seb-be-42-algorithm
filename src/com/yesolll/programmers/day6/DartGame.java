package com.yesolll.programmers.day6;

import java.util.Arrays;

public class DartGame {
    public static int solution(String dartResult) {
        final String SCORE = "012345678910"; 
        final String SPACE = " ";

        for (int i = 2; i < dartResult.length(); i++) {
            String score = dartResult.charAt(i) + "";
            if (SCORE.contains(score)) {
                dartResult = dartResult.replace(score, SPACE + score);
                i++;
            }
        }

        
        String[] dartResults = dartResult.split(SPACE);
        int[] scores = new int[4];
        for (int i = 0; i < dartResults.length; i++) {
            int score = dartResults[i].charAt(0) - '0';
            for (int j = 1; j < dartResults[i].length(); j++) {
                char bonusOption = dartResults[i].charAt(j);
                switch(bonusOption) {
                    case 'S': 
                        scores[i] += score;
                        break;
                    case 'D':
                        scores[i] += Math.pow(score, 2);
                        break;
                    case 'T':
                        scores[i] += Math.pow(score, 3);
                        break;
                    case '*':
                        scores[i] *= 2;
                        if (i != 0) scores[i-1] *= 2;
                        break;
                    case '#':
                        scores[i] *= -1;
                        break;
                }
            }
        }

        int answer = Arrays.stream(scores).sum();
        return answer;
    }

    public static void main(String[] args) {
        int output = solution("1S2D*3T");
        System.out.println(output);
    }
}

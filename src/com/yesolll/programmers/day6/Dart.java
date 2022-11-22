package com.yesolll.programmers.day6;

import java.util.Arrays;


public class Dart {
    public static int solution(String dartResult) {
        final String SCORE = "123456789"; 
        final String SPACE = " ";
        StringBuffer replaced = new StringBuffer();

        for (int i = 1; i < dartResult.length(); i++) {
            String currentStr = dartResult.charAt(i)+"";
            if (SCORE.contains(currentStr)) {
                replaced.append(dartResult.substring(0, i)).append(SPACE);
                dartResult = dartResult.substring(i, dartResult.length());
                i = 1;
            } 
            else if (currentStr.equals("0") && dartResult.charAt(i-1) != '1') {
                replaced.append(dartResult.substring(0, i)).append(SPACE);
                dartResult = dartResult.substring(i, dartResult.length());
                i = 1;
            }
            
            if(dartResult.length() <= 3) {
                replaced.append(dartResult);
                dartResult = "";
            }
        }
        String[] dartResults = replaced.toString().split(SPACE);
        int[] answers = new int[4];
        for (int i = 0; i < 3; i++) {
            int score = (dartResults[i].charAt(0) == '1' && dartResults[i].charAt(1) == '0') ? 
                        10 : 
                        dartResults[i].charAt(0)-'0';
            for (int j = 1; j < dartResults[i].length(); j++) {
                char bonusOption = dartResults[i].charAt(j);
                switch(bonusOption) {
                    case 'S': 
                        answers[i] += score;
                        break;
                    case 'D':
                        answers[i] += Math.pow(score, 2);
                        break;
                    case 'T':
                        answers[i] += Math.pow(score, 3);
                        break;
                    case '*':
                        answers[i] *= 2;
                        if (i != 0) answers[i-1] *= 2;
                        break;
                    case '#':
                        answers[i] *= -1;
                        break;
                }
            }
        }

        int answer = Arrays.stream(answers).sum();
        return answer;
    }

    public static void main(String[] args) {
        // int output = solution("10S0D*8T");
        int output = solution("10S2D*0T");
        // int output = solution("0S*0D*10T");
        // int output = solution("10S#6D*0T");
        // 1일때: 뒤에 0이면 10
        // 0일때: 앞에 1이면 10
        // System.out.println(output);
    }
}

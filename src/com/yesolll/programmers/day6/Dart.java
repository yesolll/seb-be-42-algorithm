package com.yesolll.programmers.day6;

import java.util.Arrays;


public class Dart {
    public static int solution(String dartResult) {
        /* 
         * 1. 점수(숫자)를 기준으로, 문자열을 잘라가며 회차별 결과 배열로 바꾼다.
         *    1S2D*3T => [1S, 2D*, 3T]
         * 
         * 2. 위 배열을 반복하면서 점수를 추출하고, 보너스와 옵션 별로(switch) 점수를 계산한다. [2,8,27]
         * 
         * 3. 계산완료 배열을 sum()해서 return
         * 
         */

        // SCORE에 해당하면 점수이다. 점수 앞 부분까지 자르면 이전 회차의 점수+보너스+옵션
        final String SCORE = "123456789"; 
        final String SPACE = " ";
        StringBuffer strForSplit = new StringBuffer();

        for (int i = 1; i < dartResult.length(); i++) {
            String currentStr = dartResult.charAt(i)+"";
            if (SCORE.contains(currentStr)) { // 현재 글자가 숫자인가
                // ex) "1S2D*3T" -> strForSplit에 "1S " 넣고 "2D*3T"로 잘라서 넣기
                strForSplit.append(dartResult.substring(0, i)).append(SPACE); // (이전 회차 점수+보너스+옵션 + " ")
                dartResult = dartResult.substring(i, dartResult.length()); // 점수 잘라주기
                i = 1;
              
               //현재 글자가 0인데 앞이 1이 아닌가 ( == 0점인가)
               // ex) "10S2D*3T"
            } else if (currentStr.equals("0") && dartResult.charAt(i-1) != '1') {
                strForSplit.append(dartResult.substring(0, i)).append(SPACE);
                dartResult = dartResult.substring(i, dartResult.length());
                i = 1;
            }
            
            // 남은 점수가 한회차인가 (10은 최대 글자가 4자리, 나머지는 3자리)
            if(
                dartResult.length() <= 3 || 
                (dartResult.length() <= 4 && dartResult.substring(0, 2).equals("10"))
            ) {
                strForSplit.append(dartResult);
                dartResult = ""; // --> for 탈출
            }
        }
                            // "1S 2D* 3T"
        String[] dartResults = strForSplit.toString().split(SPACE);

        // 각 회차의 점수를 계산해서 넣어줄 배열 [1회차, 2회차, 3회차] ex) [2,8,27]
        int[] answers = new int[3];

        // dartResults 순회 ["1S 2D* 3T"]
        for (int i = 0; i < 3; i++) {
            int score = (dartResults[i].charAt(0) == '1' && dartResults[i].charAt(1) == '0') ? 
                        10 : 
                        dartResults[i].charAt(0)-'0';
            // 한 회차 점수 순회 "2D*"
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
                        // 1회차가 아니면 이전 회차 점수도 2배
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
        int output = solution("1S2D*3T");
        // int output = solution("10S2D*0T");
        // int output = solution("0S*0D*10T");
        // int output = solution("10S#6D*10T#");
        // 1일때: 뒤에 0이면 10
        // 0일때: 앞에 1이면 10
        System.out.println(output); // 37
    }
}

package com.yesolll.programmers.day1;

public class GetMiddleLetter {

    public String solution(String s) {
        final int HALF_OF_LENGTH = s.length() / 2;

        String answer = "";
        
        if (s.length() % 2 == 0) {
            answer = s.substring(HALF_OF_LENGTH-1, HALF_OF_LENGTH+1);
        } else {
            answer = s.substring(HALF_OF_LENGTH, HALF_OF_LENGTH+1);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        GetMiddleLetter q = new GetMiddleLetter();
        String output = q.solution("yesolll");
        System.out.println(output);        
    }
}

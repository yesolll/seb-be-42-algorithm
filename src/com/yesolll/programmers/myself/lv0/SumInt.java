package com.yesolll.programmers.myself.lv0;

public class SumInt {
    public int solution(int n) {
        // int answer = 0;
        // String[] str = (n + "").split("");
        // answer = Stream.of(str).mapToInt(Integer::parseInt).sum();
        // return answer;        
        int answer = 0;
        String str = (n + "");
        for (int i = 0; i < str.length(); i++) {
            answer += (str.charAt(i) - '0');
        }
        return answer;
    }
}

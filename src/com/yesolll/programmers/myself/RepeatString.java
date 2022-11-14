package com.yesolll.programmers.myself;

public class RepeatString {
    public String solution(String my_string, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < my_string.length(); i++) {
            sb.append((""+my_string.charAt(i)).repeat(n));
        }
        answer = sb.toString();
        return answer;
    }
}

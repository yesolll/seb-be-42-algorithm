package com.yesolll.programmers.myself;

public class StringToInt {

    private boolean isNegativeNumber(String s) {
        return s.charAt(0) == '-';
    }

    public int solution(String s) {
        int answer = 0;
        boolean isNegative = isNegativeNumber(s);

        if (isNegative) s = s.substring(1,s.length());

        answer = isNegative ? Integer.parseInt(s) * -1 : Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        StringToInt q = new StringToInt();
        int output = q.solution("-1234");
        System.out.println(output);
    }

}

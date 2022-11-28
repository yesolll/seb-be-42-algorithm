package com.yesolll.programmers.myself.lv0;

public class IsSquareNumber {
    public static int solution(int n) {
        int answer = 0;
        answer = (Math.sqrt(n) == Math.floor(Math.sqrt(n))) ? 1 : 2;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(144));
    }
}

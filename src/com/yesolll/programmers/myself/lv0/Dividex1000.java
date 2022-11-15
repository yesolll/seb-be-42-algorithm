package com.yesolll.programmers.myself.lv0;

public class Dividex1000 {
    public static int solution(int num1, int num2) {

        int answer = 0;
        double div = num1 / (double) num2;
        answer = (int) Math.floor(div * 1000);
        return answer;
        
    }

    public static void main(String[] args) {
        int output = solution(1, 16);
        System.out.println(output);
    }
    
}

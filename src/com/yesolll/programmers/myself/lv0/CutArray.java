package com.yesolll.programmers.myself.lv0;

import java.util.Arrays;

public class CutArray {
    public static int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = {};
        answer = Arrays.copyOfRange(numbers, num1, num2 + 1);
        return answer;
    }
    
    public static void main(String[] args) {
        
    }
}

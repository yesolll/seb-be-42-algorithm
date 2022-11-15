package com.yesolll.programmers.myself;

import java.util.Arrays;

public class HigherThanMS {
    public int solution(int[] array, int height) {
        int answer = 0;
        // Arrays.stream(array).map(i -> i > height).count(); 요게 안 되네..
        answer = (int)Arrays.stream(array).filter(i -> i > height).count();
        // for (int a : array) {
        //     if ( a > height ) answer ++;
        // }
        return answer;
    }

    public static void main(String[] args) {
        HigherThanMS q = new HigherThanMS();
        int output = q.solution(new int[] {149, 180, 192, 170}, 167);
        System.out.println(output);
    }
}

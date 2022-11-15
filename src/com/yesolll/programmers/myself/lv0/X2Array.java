package com.yesolll.programmers.myself.lv0;

import java.util.Arrays;

public class X2Array {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = Arrays.stream(numbers).map(i -> i * 2).toArray();
        return answer;
    }
}

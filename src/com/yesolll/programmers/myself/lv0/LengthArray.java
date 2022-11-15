package com.yesolll.programmers.myself.lv0;

import java.util.Arrays;

public class LengthArray {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        answer = Arrays.stream(strlist).mapToInt(String::length).toArray();
        return answer;
    }
}

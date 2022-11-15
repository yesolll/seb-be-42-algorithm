package com.yesolll.programmers.myself;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        answer = sides[2] < sides[0] + sides[1] ? 1 : 2;
        return answer;
    }
}

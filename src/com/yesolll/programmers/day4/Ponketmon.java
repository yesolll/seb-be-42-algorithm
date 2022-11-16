package com.yesolll.programmers.day4;

import java.util.Arrays;

public class Ponketmon {
    public static void main(String[] args) {
        int[] nums = new int[] {3,3,3,2,2,2};
        
        int answer = nums.length / 2;

        int typeCnt = (int) Arrays.stream(nums).distinct().count();
        
        answer = typeCnt < answer ? typeCnt : answer;
        
    }
}

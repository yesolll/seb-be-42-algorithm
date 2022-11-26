package com.yesolll.programmers.day5;

import java.util.ArrayList;
import java.util.List;

public class MakePrime {
    public static int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        /* 1 .3개씩 더한 수 구하기 */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1;k < nums.length; k++) {
                    if ( (nums[i] + nums[j] + nums[k]) % 2 != 0 )list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        /* 2. 소수 판별하기 */
        for (int i : list) {
            boolean isNotPrime = false;
            for (int j = i-1; j >= 3; j--) {
                if (i % j == 0) {
                    isNotPrime = true;
                    break;
                }
            }
            if (!isNotPrime) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int output = solution(new int[]{1,2,7,6,4});
        System.out.println(output);
    }
}

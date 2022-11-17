package com.yesolll.programmers.myself.lv0;

import java.util.ArrayList;
import java.util.List;

public class IHateEven {
    public static int[] solution(int n) {
        int[] answer = {};
        List<Integer> oddList = new ArrayList<>();
        
        for (int i = 1; i <= n; i += 2) {
            
            oddList.add(i);
        }

        System.out.println(oddList);    
        answer = oddList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {
        solution(15);
    }
}

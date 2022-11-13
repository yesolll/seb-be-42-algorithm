package com.yesolll.programmers.myself;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MakeMaximum {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        answer = numbersList.stream().max(Integer::compare).orElse(-1);
        numbersList.remove(Integer.valueOf(answer));
        answer *= numbersList.stream().max(Integer::compare).orElse(-1);

        // Arrays.sort(numbers);
        // return numbers[numbers.length-1]*numbers[numbers.length-2]; 바보ㅠㅠㅜ
        return answer;
    }
    
    public static void main(String[] args) {
        MakeMaximum q = new MakeMaximum();
        int output = q.solution(new int[] {0, 31, 24, 10, 1, 9});
        System.out.println(output);
    }
}

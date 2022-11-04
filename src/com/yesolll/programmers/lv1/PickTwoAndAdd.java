package com.yesolll.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PickTwoAndAdd {

    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        List<Integer> sumValues = new ArrayList<>();
            
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i != j){
                    sumValues.add(numbers[i] + numbers[j]);
                }
            }
        }

        sumValues = sumValues.stream().distinct().collect(Collectors.toList());
        answer = sumValues.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        PickTwoAndAdd q = new PickTwoAndAdd();
        int[] output = q.solution(new int[] {5,0,2,7});
        System.out.println(Arrays.toString(output));
    }
}

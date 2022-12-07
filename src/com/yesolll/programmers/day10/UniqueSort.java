package com.yesolll.programmers.day10;

import java.util.*;
import java.util.Map.Entry;

public class UniqueSort {
    public static int[] solution(int[] numlist, int n) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> numMap = new TreeMap<>();
        // numlist: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11]
        // n: 6

        // key: 두 수의 차(diff), value: 차이나는 숫자들[](values)
        for (int i = 0; i < numlist.length; i++) {
            List<Integer> values = new ArrayList<>();
            int diff = Math.abs(numlist[i] - n); //4
            if (numMap.get(diff) != null) {
                values = numMap.get(diff);
            }
            values.add(numlist[i]); // [10] -> [10, 2]
            numMap.put(diff, values);
        }
        /*
         * { 
         *   0=[6], 
         *   1=[7, 5], 
         *   2=[8, 4], 
         *   3=[9, 3], 
         *   4=[10, 2], 
         *   5=[1, 11]
         * }
         */

        Iterator<Entry<Integer, List<Integer>>> iterator = numMap.entrySet().iterator();
        while (iterator.hasNext()) {
            List<Integer> value = iterator.next().getValue();
            Collections.sort(value);
            if (value.size() == 1) {
                answer.add(value.get(0));
            }
            else if (value.size() == 2) {
                answer.add(value.get(1));
                answer.add(value.get(0));
            }
        }
        /*
         * [6, 7, 5, 8, 4, 9, 3, 10, 2, 11, 1]
         */
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] output = solution(new int[]{10,9,8,7,6,5,4,3,2,1,11}, 6);
        for (int i : output) System.out.print(i + " ");
        
    }
}
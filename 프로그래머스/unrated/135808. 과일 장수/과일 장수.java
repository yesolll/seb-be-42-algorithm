import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        while (list.size() >= m) {
            answer += (list.get(m-1) * m);
            list = list.subList(m, list.size());
        }
        return answer;
    }
}
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = Arrays.stream(score).boxed().sorted().collect(Collectors.toList());
        while (list.size() >= m) {
            answer += (list.get(list.size()-(m)) * m);
            list = list.subList(0, list.size()-m);
        }
        return answer;
    }
}
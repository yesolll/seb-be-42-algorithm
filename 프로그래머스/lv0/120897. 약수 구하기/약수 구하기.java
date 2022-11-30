import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> measures = new ArrayList<>();
        measures.add(1);
        for (int i = 2; i < n; i++) {
            if (n % i == 0) measures.add(i);
        }
        if (n != 1) measures.add(n);
        return measures.stream().mapToInt(i->i).toArray();
    }
}
import java.util.stream.Stream;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] str = (n + "").split("");
        answer = Stream.of(str).mapToInt(Integer::parseInt).sum();
        return answer;
    }
}
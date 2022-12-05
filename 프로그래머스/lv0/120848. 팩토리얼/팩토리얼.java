class Solution {
    public int solution(int n) {
        int answer = 1;
        int factorial = 1;
        if (n == 1) return answer;
        while (factorial * answer <= n) {
            answer++;
            factorial = factorial * (answer);
        }
        return answer;
    }
}
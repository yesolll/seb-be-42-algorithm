class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 4; i <= n; i++){
            Inner: for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    answer ++;
                    break Inner;
                }
            }
        }
        return answer;
    }
}
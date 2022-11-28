class Solution {
    public int solution(int hp) {
        int[] power = {5, 3, 1};
        int idx = 0;
        int answer = 0;
        while (hp != 0) {
            answer += hp / power[idx];
            hp = hp % power[idx];
            idx++;
        }
        return answer;
    }
}
class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int remain = 0;
        
        while (10 <= chicken) {
            remain = chicken % 10;
            answer += chicken /= 10;
            chicken += remain;
        }

        return answer;
    }
}
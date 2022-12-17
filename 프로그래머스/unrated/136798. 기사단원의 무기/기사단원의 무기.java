class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for (int i = 2; i <= number; i++) {
            answer += getSteelWeight(i, limit, power);
        }
        return answer;
    }
    
    public int getSteelWeight(int num, int limit, int power) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(num); i ++) {
            if (i == Math.sqrt(num)) cnt ++;
            else if (num % i == 0) cnt += 2;
            
            if (cnt > limit) return power;
        }
        return cnt;
    }
}
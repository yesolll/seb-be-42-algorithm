class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer ++;
            answer = checkNumberThree(answer);
        }
        return answer;
    }

    public int checkNumberThree(int n) {
        if (!(n % 3 == 0 || String.valueOf(n).contains("3"))) { 
            return n;
        } else {
            n++;
            return checkNumberThree(n);
        }
    }
}
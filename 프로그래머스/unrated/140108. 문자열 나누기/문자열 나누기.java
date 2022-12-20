class Solution {
    public int solution(String s) {
        int answer = 0;
        char firstChar = s.charAt(0);
        int cnt = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (firstChar == s.charAt(i)) cnt++;
            else cnt--;
            if ( cnt == 0 ) {
                answer++;
                firstChar = s.charAt(i+1);
            }
        }
        answer++;
        return answer;
    }
}
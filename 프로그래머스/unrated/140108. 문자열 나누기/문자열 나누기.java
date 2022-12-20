class Solution {
    // 첫 글자 저장(firstChar)
    // 반복하면서 firstChar랑 같으면 cnt++ 아니면 --
    // cnt0이면(개수 똑같으면) answer++
    // 첫글자를 다음 글자로
    // 마지막 글자는 비교 안 했으니까 최종적으로 answer++
        
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
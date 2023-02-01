class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int round = 0;
        int zeroCnt = 0;
        
        while (!s.equals("1")) {
            round++;
            zeroCnt += s.chars().filter(c -> c == '0').count();
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
        }
        
        answer[0] = round;
        answer[1] = zeroCnt;
        return answer;
    }
}
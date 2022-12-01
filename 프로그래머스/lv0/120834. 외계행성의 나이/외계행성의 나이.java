class Solution {
    public String solution(int age) {
        String answer = "";
        String ageStr = String.valueOf(age);
        for (int i = 0; i < ageStr.length(); i++) {
            char alienAge = (char)(ageStr.charAt(i) + '1');
            answer += alienAge;
        }
        return answer;
    }
}
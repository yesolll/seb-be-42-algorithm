class Solution {
    public String solution(String polynomial) {        
        StringBuilder answer = new StringBuilder();
        int coefficient = 0;    // x항 계수
        int constant = 0;       // 상수항
        
        String[] nums = polynomial.split(" \\+ ");
        for (String num : nums) {
            if (num.contains("x")) {
                num = num.replace("x", "");
                int cur = num.isEmpty() ? 1 : Integer.parseInt(num);
                coefficient += cur;
            } else {
                constant += Integer.parseInt(num);
            }
        }
        
        if (coefficient != 0) {
            if (coefficient > 1) answer.append(coefficient);
            answer.append("x");
        }
        if (coefficient != 0 && constant != 0) answer.append(" + ");
        if (constant != 0) answer.append(constant);
        return answer.toString();
    }
}
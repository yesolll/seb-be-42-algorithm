class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int n = i; n <= j; n++) {
            String numStr = String.valueOf(n);
            if (numStr.indexOf(String.valueOf(k)) != -1) {
                for (int m = 0; m < numStr.length(); m++) {
                    if (numStr.charAt(m) == (char)(k+'0')) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
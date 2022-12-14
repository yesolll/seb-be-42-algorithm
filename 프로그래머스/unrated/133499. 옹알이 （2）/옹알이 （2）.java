class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            // "aya", "yee", "u", "maa", "yeyemawooye"
            
            // 1. 말할 수 있는 단어를 A, B, C, D로 치환
            String word = str.replace("aya", "A")
                             .replace("ye",  "B")
                             .replace("woo", "C")
                             .replace("ma",  "D");
            // => "A", "Be", "u", "Da", "BBDCB"

            // 2. 2회 이상 반복된 단어는 X로 치환            
            word = word.replaceAll("A{2,}+", "X")
                       .replaceAll("B{2,}+", "X")
                       .replaceAll("C{2,}+", "X")
                       .replaceAll("D{2,}+", "X");
            // "A", "Be", "u", "Da", "XDCB"

            // 결국 말할 수 있는 단어는 [A,B,C,D] 로만 이루어져있다.
            if(isAvailable(word)) answer++;
        }
        return answer;
    }
    
    // 3. [A,B,C,D] 로만 이루어져있으면 true
    private boolean isAvailable(String str){
        if(str.replaceAll("[A-D]", "").length() == 0) return true;
        return false;
    }
}
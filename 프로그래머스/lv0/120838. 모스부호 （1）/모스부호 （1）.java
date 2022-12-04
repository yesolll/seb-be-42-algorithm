import java.util.*;

class Solution {
    public String solution(String letter) {
        List<String> morse = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");
        
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] letterArr = letter.split(" ");
        for (int i = 0; i < letterArr.length; i++) {
            sb.append((char) (morse.indexOf(letterArr[i]) + 'a'));
        }
        return sb.toString();
    }
}
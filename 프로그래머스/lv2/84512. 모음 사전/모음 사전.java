import java.util.*;

class Solution {
    static String[] VOWELS = new String[]{"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        ArrayList<String> dictionary = new ArrayList<>();
        
        addWord(dictionary, word, "", 0);

        int answer = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            if(dictionary.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    private void addWord(ArrayList<String> dictionary, 
                          String word, 
                          String str, 
                          int depth) {
        dictionary.add(str);
        
        if(depth == VOWELS.length) return;
        
        for (int i = 0; i < VOWELS.length; i++) {
            addWord(dictionary, word, str + VOWELS[i], depth + 1);
        }
    }
}
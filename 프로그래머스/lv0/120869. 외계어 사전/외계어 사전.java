import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean[] isMatch = new boolean[spell.length];
        final boolean[] MATCH_ARRAY = new boolean[spell.length]; 
        Arrays.fill(MATCH_ARRAY,true);
        for (String str : dic) {
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < spell.length; j++) {
                    if (spell[j].equals(String.valueOf(str.charAt(i))) && (isMatch[j] == false)) {
                        isMatch[j] = true;
                    }
                }
            }
            if (Arrays.equals(isMatch, MATCH_ARRAY)) return 1;
            else Arrays.fill(isMatch,false);
        }
        return 2;
    }
}
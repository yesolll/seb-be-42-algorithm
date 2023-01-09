import java.util.*;

class Solution {
    public String[] solution(String[] files) {
//         int numIdx = 0;
//         int tailIdx = 0;
        
//         for(int i = 0; i < files.length; i++) {
//             for (int j = 0; j < files[i].length(); j++) {
//                 if (numIdx == 0 && files[i].charAt(j) >= 48 && files[i].charAt(j) <= 57) {
//                     numIdx = j;
//                 } else if ((tailIdx == 0 && numIdx != 0) &&
//                            (numIdx + 5 <= j || (files[i].charAt(j) < 48 || files[i].charAt(j) > 57))) {
//                     tailIdx = j;
//                 }
//             }
//         }
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String s1Head = s1.split("[0-9]")[0].toLowerCase();
                String s2Head = s2.split("[0-9]")[0].toLowerCase();
                
                int result = s1Head.compareTo(s2Head);
                if(result == 0) {
                    result = parseInt(s1.substring(s1Head.length())) - 
                             parseInt(s2.substring(s2Head.length()));
                }
                
                return result;
            }
        });
        return files;
    }
    
    public int parseInt(String str) {
        String number = "";
        
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && number.length() < 5) {
                number += c;
            } else break;
        }
        int lastIdx = number.length() >= 5 ? 5 : number.length();
        return Integer.parseInt(number.substring(0, lastIdx));
        
    }
}
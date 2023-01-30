import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i <= str1.length()-2; i++) {
            String str = str1.substring(i, i+2);
            if (!str.contains(" ")) list1.add(str);
        }
        for (int i = 0; i <= str2.length()-2; i++) {
            String str = str2.substring(i, i+2);
            if (!str.contains(" ")) list2.add(str);
        }
        
        List<String> union = new ArrayList<>();        // 합집합
        List<String> intersection = new ArrayList<>(); // 교집합
        
        for(String s : list1){
            if(list2.remove(s)) intersection.add(s);
            union.add(s);
        }
      
        for(String s : list2){
            union.add(s);
        }
        
        double jakard = 0;
        if(union.size() == 0) jakard = 1;
        else jakard = intersection.size() / (double) union.size();
        
        return (int) (jakard * 65536);
    }
}
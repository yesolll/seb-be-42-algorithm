import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            arr[i] = (my_string.charAt(i)+"").toLowerCase();
        }
        answer = Arrays.stream(arr).sorted().collect(Collectors.joining());
        return answer;
    }
}
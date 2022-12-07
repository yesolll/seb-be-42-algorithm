import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        return Arrays.equals(before.chars().sorted().toArray(), 
                             after.chars().sorted().toArray()
                            ) ? 1 : 0;
    }
}
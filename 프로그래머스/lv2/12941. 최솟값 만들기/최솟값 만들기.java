
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int bIdx = B.length - 1;
        for(int a : A){
            answer = answer + (a * B[bIdx]);
            bIdx--;
        }
        
        return answer;
    }
}
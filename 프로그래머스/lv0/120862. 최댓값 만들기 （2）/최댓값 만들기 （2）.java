import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int minusCnt = 0;
        int minusProduct = 0;
        int plusProduct = 0;
        Arrays.sort(numbers);
        minusProduct = numbers[0] * numbers[1];
        plusProduct = numbers[numbers.length-1] * numbers[numbers.length-2];
        
        return minusProduct > plusProduct ? minusProduct : plusProduct;
    }
}
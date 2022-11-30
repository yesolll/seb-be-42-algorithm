import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        if(direction.equals("right")) {
            answer = new int[numbers.length];
            answer[0] = numbers[numbers.length-1];
            System.arraycopy(numbers, 0, answer, 1, numbers.length-1);
        } else {
            answer = Arrays.copyOfRange(numbers, 1, numbers.length+1);
            answer[answer.length-1] = numbers[0];
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] nums = my_string.split(" ");
        answer += Integer.parseInt(nums[0]);
        for (int i = 1; i < nums.length; i+=2){
            if (nums[i].equals("+")) answer = add(answer, Integer.parseInt(nums[i+1]));
            else if (nums[i].equals("-")) answer = substract(answer, Integer.parseInt(nums[i+1]));
        }
        return answer;
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int substract(int num1, int num2) {
        return num1 - num2;
    }
}
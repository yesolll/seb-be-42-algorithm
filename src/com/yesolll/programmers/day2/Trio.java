package com.yesolll.programmers.day2;

public class Trio {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) { // 무조건 뒤로만 더하기
                for (int k = j+1; k < numbers.length; k++) {
                    if (numbers[i]+numbers[j]+numbers[k] == 0)
                    answer ++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Trio q = new Trio();
        int output = q.solution(new int[] {-3, -2, -1, 0, 1, 2, 3});
        System.out.println(output);
    }
}

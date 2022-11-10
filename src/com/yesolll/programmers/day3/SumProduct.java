package com.yesolll.programmers.day3;

public class SumProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        SumProduct q = new SumProduct();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        int output = q.solution(a, b);
        System.out.println(output);
    }
}

package com.yesolll.programmers.day9;

public class ChickenCoupon {
    public static int solution(int chicken) {
        
        int answer = 0;
        int remain = 0;
        
        while (10 <= chicken) {
            remain = chicken % 10;
            answer += chicken /= 10;
            chicken += remain;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1081));
    }
}

package com.yesolll.programmers.day2;

public class FiniteDemical {
    public int solution(int a, int b) {
        // 1. 약분 ( 유클리드 호제법 )
        // 2. 분모 소인수 확인

        int gcd = gratestCommonDivisor(a, b);
        a = a / gcd;
        b = b / gcd;

        while(true) {
            if      (b % 2 == 0) b /= 2;
            else if (b % 5 == 0) b /= 5;
            else if (b == 1) break;
            else    break;
        }
        if ( b != 1 ) return 2; 
        return 1;
    }


    public int gratestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int minus3questions(int a, int b) {
        int answer = 1;
        if ( b % a == 0) b = b / a;

        while(true) {
            if      (b % 2 == 0) b /= 2;
            else if (b % 5 == 0) b /= 5;
            else if (b == 1) break;
            else    break;
        }
        System.out.println(b);
        if ( b != 1 ) answer = 2; 
        return answer;
    }

    public static void main(String[] args) {
        FiniteDemical q = new FiniteDemical();
        q.solution(8, 30);
    }

}

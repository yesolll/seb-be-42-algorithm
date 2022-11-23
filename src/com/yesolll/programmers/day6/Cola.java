package com.yesolll.programmers.day6;

public class Cola {
    public static int solution(int a, int b, int n) {
        // n을 a로 나눈 몫 * b만큼 나한테 준다. => n
        // a보다 작아질 때까지
        // 처음 n은 내가 받은 거
        // 나머지를 더한 n은 내가 가지고 있는 거

        int answer = 0;
        int remain = 0;
        while (a <= n) {
            remain = n % a;
            n = (n / a) * b;
            
            answer += n;
            n += remain;
        }

        return answer * b;
    }

    public static void main(String[] args) {
        int output = solution(3, 2, 20);
        System.out.println(output);
    }
}

package com.yesolll.programmers.lv1;

public class FiniteDemical {
    public int solution(int a, int b) {
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

package com.yesolll.programmers.myself.lv0;

public class HarShadNumber {
    public static boolean solution(int x) {
        String str = String.valueOf(x);
        int sum = 0;

        for (int i = 0; i < str.length(); i++ ) {
            sum += str.charAt(i)-'0';
        }
        
        return x % sum == 0;
    }

    public static void main(String[] args) {
        solution(12);
    }
}

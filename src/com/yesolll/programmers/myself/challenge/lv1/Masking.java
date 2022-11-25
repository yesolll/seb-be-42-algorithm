package com.yesolll.programmers.myself.challenge.lv1;

public class Masking {
    public static String solution(String phone_number) {
        String answer = "";
        int repeatCnt = phone_number.length() - 4;
        String noneMasking = phone_number.substring(phone_number.length()-4);
        answer = "*".repeat(repeatCnt) + noneMasking;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("010294101"));
    }

}

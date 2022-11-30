package com.yesolll.programmers.day8;

public class Login {
    public static String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        String id = id_pw[0];
        String pw = id_pw[1];
        for(String[] arr : db) {
            if (id.equals(arr[0]) && pw.equals(arr[1])) answer = "login";
            if (id.equals(arr[0]) && !pw.equals(arr[1])) answer = "wrong pw";
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(
        // new String[]{"meosseugi", "1234"}, 
        // new String[][] {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}
        new String[] {"programmer01", "15789"},
        new String[][] {{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}}
        ));
    }
}

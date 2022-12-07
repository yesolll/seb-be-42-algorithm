package com.yesolll.programmers.day10;

public class NewId {
    public static String solution(String new_id) {
        // 1. 소문자
        new_id = new_id.toLowerCase();

        // 2. 소문자, 숫자, -_.
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        if (new_id.length() == 0){
            new_id = "a";
        }

        // 3. 연속된 . -> .
        new_id = new_id.replaceAll("[.]+",".");

        // 4-5. 양끝 . 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        if (new_id.length() == 0){
            new_id = "a";
        }

        // 6. 16자 이상 -> 15자로
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 7. 2자 이하 -> 3글자 될 때까지 맨 뒷 글자 붙이기
        while (new_id.length() <= 2) {
            new_id = new_id + (new_id.charAt(new_id.length()-1));
        }

        return new_id;
    }
    public static void main(String[] args) {
        String output = solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(output);
    }
}

package com.yesolll.programmers.myself.lv0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortString {
    public static String solution(String my_string) {
        String answer = "";
        String[] arr = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            arr[i] = (my_string.charAt(i)+"").toLowerCase();
        }
        answer = Arrays.stream(arr).sorted().collect(Collectors.joining());
        return answer;
    }

    public static void main(String[] args) {
        String output = solution("aCbfd");
        System.out.println(output);
    }
}

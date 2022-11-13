package com.yesolll.programmers.myself;

public class ReverseString {
    public void solution(String my_string) {
        StringBuffer sb = new StringBuffer(my_string);
        System.out.println(sb.reverse().toString());
    }
}

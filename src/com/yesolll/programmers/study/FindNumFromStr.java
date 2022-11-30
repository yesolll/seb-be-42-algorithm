package com.yesolll.programmers.study;

public class FindNumFromStr {
    public static void main(String[] args) {
        String str = "1RFfas46";
        String intStr = str.replaceAll("[^0-9]", ""); // == [^\\d]
        System.out.println(intStr);
        // System.out.println(intStr.chars().map(i->i-'0').sum());
    }
}

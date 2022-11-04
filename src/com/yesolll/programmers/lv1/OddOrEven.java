package com.yesolll.programmers.lv1;

import java.util.Scanner;

public class OddOrEven {

    static int num;

    static void input() {

        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        input.close();

    }

    public String solution(int num) {

        String result = "Odd";
        if (num % 2 == 0)  result = "Even";

        return result;
    }

    public static void main(String[] args) {
        OddOrEven q = new OddOrEven();
        input(); 
        String output = q.solution(num);
        System.out.println(output);
    }
    
}

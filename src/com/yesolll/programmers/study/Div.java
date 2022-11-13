package com.yesolll.programmers.study;

public class Div {

    public int solution(int num1, int num2) {
        
        int iValue = num1 / num2;
        System.out.printf("1. %d %% %d = %d\n", num1, num2, iValue);
        
        double dValue = num1 / num2;
        System.out.printf("2. %d %% %d = %f\n", num1, num2, dValue);

        double dValue2 = num1 / (double) num2;
        System.out.printf("3. %d %% %d = %f\n", num1, num2, dValue2);

        int castingValue = (int) (num1 / (double) num2); 
        System.out.printf("4. %d %% %d = %d\n", num1, num2, castingValue);

        long a = 10L;
        float b = 3.2f;
        
        float c = a * b;
        // long d = a * b;
        long e = (long)(a * b);


        return 0;
    }

    public static void main(String[] args) {
        Div div = new Div();
        div.solution(10, 3);
    }
    
}
